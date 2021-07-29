package com.arquitecturajava.repositories;

import com.arquitecturajava.business.Book;
import com.arquitecturajava.business.Chapter;
import com.arquitecturajava.repositories.connection.DbConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChapterRepositoryJDBC implements ChapterRepository {

    @Override
    public Chapter select(Chapter chapter) {
        final String QUERY = "SELECT * FROM chapter WHERE pk_title = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, chapter.getPk_title());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? new Chapter(resultSet.getString(1), resultSet.getInt(2)) : null;
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Chapter> select(Book book) {
        final String QUERY = "SELECT * FROM chapter WHERE fk_book = ?";
        final List<Chapter> CHAPTERS = new ArrayList<>();
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CHAPTERS.add(new Chapter(resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return CHAPTERS;
    }

    @Override
    public List<Chapter> select() {
        final String QUERY = "SELECT * FROM chapter";
        final List<Chapter> CHAPTERS = new ArrayList<>();
        try (Connection conn = DbConnectionSingleton.getConnection();
                Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                CHAPTERS.add(new Chapter(resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return CHAPTERS;
    }

    @Override
    public int insert(Chapter chapter) {
        final String QUERY = "INSERT INTO chapter (pk_title, pages, fk_book) VALUES (?, ?, ?)";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, chapter.getPk_title());
            preparedStatement.setInt(2, chapter.getPages());
            preparedStatement.setString(3, chapter.getFk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de inserción: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Chapter chapter) {
        final String QUERY = "DELETE FROM chapter WHERE pk_title = ? AND fk_book = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, chapter.getPk_title());
            preparedStatement.setString(2, chapter.getFk_book().getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de borrado: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Book book) {
        final String QUERY = "DELETE FROM chapter WHERE fk_book = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de borrado: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int update(Chapter chapter) {
        final String QUERY = "UPDATE chapter SET pages = ?, fk_book = ? WHERE pk_title = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, chapter.getPages());
            preparedStatement.setString(2, chapter.getFk_book().getPk_isbn());
            preparedStatement.setString(3, chapter.getPk_title());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateTitle(Chapter chapter, String title) {
        final String QUERY = "UPDATE chapter SET pk_title = ? WHERE pk_title = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, chapter.getPk_title());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updatePages(Chapter chapter, int pages) {
        final String QUERY = "UPDATE chapter SET pages = ? WHERE pk_title = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, pages);
            preparedStatement.setString(2, chapter.getPk_title());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateBook(Chapter chapter, Book book) {
        final String QUERY = "UPDATE chapter SET fk_book = ? WHERE pk_title = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, book.getPk_isbn());
            preparedStatement.setString(2, chapter.getPk_title());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }
}