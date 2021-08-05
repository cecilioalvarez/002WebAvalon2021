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
public class ChapterRepositoryJDBC implements ChapterRepository {
    
    @Autowired
    private DataSource dataSource;

    @Override
    public Chapter select(Chapter chapter) {
        final String QUERY = "SELECT * FROM chapter c "
                + "INNER JOIN book b ON c.pk_fk_book = b.pk_isbn "
                + "INNER JOIN author a ON b.fk_author = a.pk_id "
                + "WHERE c.pk_title = ? AND b.pk_isbn = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, chapter.getPk_title());
            preparedStatement.setString(2, chapter.getPk_fk_book().getPk_isbn());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Author author = new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age"));
                Book book = new Book(resultSet.getString("pk_isbn"), resultSet.getString("title"), author);
                return new Chapter(resultSet.getString(1), resultSet.getInt(2), book);
            } else {
                return null;
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Chapter> select(Book book) {
        final String QUERY = "SELECT * FROM chapter c "
                + "INNER JOIN book b ON c.pk_fk_book = b.pk_isbn "
                + "INNER JOIN author a ON b.fk_author = a.pk_id "
                + "WHERE b.pk_isbn = ?";
        final List<Chapter> CHAPTERS = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age"));
                book = new Book(resultSet.getString("pk_isbn"), resultSet.getString("title"), author);
                CHAPTERS.add(new Chapter(resultSet.getString(1), resultSet.getInt(2), book));
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return CHAPTERS;
    }

    @Override
    public List<Chapter> select() {
        final String QUERY = "SELECT * FROM chapter c "
                + "INNER JOIN book b ON c.pk_fk_book = b.pk_isbn "
                + "INNER JOIN author a ON b.fk_author = a.pk_id";
        final List<Chapter> CHAPTERS = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
                Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                Author author = new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age"));
                Book book = new Book(resultSet.getString("pk_isbn"), resultSet.getString("title"), author);
                CHAPTERS.add(new Chapter(resultSet.getString(1), resultSet.getInt(2), book));
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return CHAPTERS;
    }

    @Override
    public int insert(Chapter chapter) {
        final String QUERY = "INSERT INTO chapter (pk_title, pages, pk_fk_book) VALUES (?, ?, ?)";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, chapter.getPk_title());
            preparedStatement.setInt(2, chapter.getPages());
            preparedStatement.setString(3, chapter.getPk_fk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de inserción: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Chapter chapter) {
        final String QUERY = "DELETE FROM chapter WHERE pk_title = ? AND pk_fk_book = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, chapter.getPk_title());
            preparedStatement.setString(2, chapter.getPk_fk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de borrado: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Book book) {
        final String QUERY = "DELETE FROM chapter WHERE pk_fk_book = ?";
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
    public int updateTitle(Chapter chapter, String title) {
        final String QUERY = "UPDATE chapter SET pk_title = ? WHERE pk_title = ? AND pk_fk_book = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, chapter.getPk_title());
            preparedStatement.setString(3, chapter.getPk_fk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updatePages(Chapter chapter, int pages) {
        final String QUERY = "UPDATE chapter SET pages = ? WHERE pk_title = ? AND pk_fk_book = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, pages);
            preparedStatement.setString(2, chapter.getPk_title());
            preparedStatement.setString(3, chapter.getPk_fk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateBook(Chapter chapter, Book book) {
        final String QUERY = "UPDATE chapter SET pk_fk_book = ? WHERE pk_title = ? AND pk_fk_book = ?";
        try (Connection conn = this.dataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            preparedStatement.setString(2, chapter.getPk_title());
            preparedStatement.setString(3, chapter.getPk_fk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }
}