package com.arquitecturajava.repositories;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.business.Chapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryJDBC implements BookRepository {
    
    @Autowired
    private DataSource dataSource;

    @Override
    public Book selectWithChapters(Book book) {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book "
                + "WHERE b.pk_isbn = ?";
        Book searchedBook = null;
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (searchedBook == null) {
                    Author author = new Author(resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
                    searchedBook = new Book(resultSet.getString(1), resultSet.getString(2), author);
                }
                if (resultSet.getString("pk_title") != null) {
                    searchedBook.addChapter(new Chapter(resultSet.getString("pk_title"), resultSet.getInt("pages"), book));
                }
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return searchedBook;
    }

    @Override
    public List<Book> selectWithChapters() {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book";
        final List<Book> BOOKS = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
                Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("pk_isbn"));
                if (!BOOKS.contains(book)) {
                    book.setTitle(resultSet.getString("title"));
                    book.setFk_author(new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age")));
                    BOOKS.add(book);
                } else {
                    book = BOOKS.get(BOOKS.size() - 1);
                }
                if (resultSet.getString("pk_title") != null) {
                    book.addChapter(new Chapter(resultSet.getString("pk_title"), resultSet.getInt("pages"), book));
                }
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return BOOKS;
    }
    
    public List<Book> select() {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book";
        final List<Book> BOOKS = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
                Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("pk_isbn"));
                if (!BOOKS.contains(book)) {
                    book.setTitle(resultSet.getString("title"));
                    book.setFk_author(new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age")));
                    BOOKS.add(book);
                } else {
                    book = BOOKS.get(BOOKS.size() - 1);
                }
                if (resultSet.getString("pk_title") != null) {
                    book.addChapter(new Chapter(resultSet.getString("pk_title"), resultSet.getInt("pages"), book));
                }
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return BOOKS;
    }

    @Override
    public List<Book> select(Author fk_author) {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book"
                + "WHERE a.pk_id = ?";
        final List<Book> BOOKS = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, fk_author.getPk_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("pk_isbn"));
                if (!BOOKS.contains(book)) {
                    book.setTitle(resultSet.getString("title"));
                    book.setFk_author(new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age")));
                    BOOKS.add(book);
                } else {
                    book = BOOKS.get(BOOKS.size() - 1);
                }
                if (resultSet.getString("pk_title") != null) {
                    book.addChapter(new Chapter(resultSet.getString("pk_title"), resultSet.getInt("pages"), book));
                }
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return BOOKS;
    }

    @Override
    public int insert(Book book) {
        final String QUERY = "INSERT INTO book (pk_isbn, title, fk_author) VALUES (?, ?, ?)";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getFk_author().getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de inserción: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Book book) {
        final String QUERY = "DELETE FROM book WHERE pk_isbn = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de borrado: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteBooks(Author fk_author) {
        final String QUERY = "DELETE FROM book WHERE fk_author = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, fk_author.getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de borrado: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int update(Book book) {
        final String QUERY = "UPDATE book SET title = ?, fk_author = ? WHERE pk_isbn = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getFk_author().getPk_id());
            preparedStatement.setString(3, book.getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updatePk_isbn(Book book, String pk_isbn) {
        final String QUERY = "UPDATE book SET pk_isbn = ? WHERE pk_isbn = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, pk_isbn);
            preparedStatement.setString(2, book.getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateTitle(Book book, String title) {
        final String QUERY = "UPDATE book SET title = ? WHERE pk_isbn = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, book.getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateAuthor(Book book, Author author) {
        final String QUERY = "UPDATE book SET fk_author = ? WHERE pk_isbn = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, author.getPk_id());
            preparedStatement.setString(2, book.getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }
}