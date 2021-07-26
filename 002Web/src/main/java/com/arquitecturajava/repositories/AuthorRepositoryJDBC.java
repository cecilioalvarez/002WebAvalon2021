package com.arquitecturajava.repositories;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.repositories.connection.DbConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryJDBC implements AuthorRepository {

    @Override
    public Author select(Author author) {
        final String QUERY = "SELECT * FROM author WHERE pk_id = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, author.getPk_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? new Author(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)) : null;
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Author> select() {
        final String QUERY = "SELECT * FROM author";
        final List<Author> AUTHORS = new ArrayList<>();
        try (Connection conn = DbConnectionSingleton.getConnection();
                Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                AUTHORS.add(new Author(resultSet.getString("pk_id"), resultSet.getString("name"), resultSet.getInt("age")));
            }
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de selección: " + sql_ex.getMessage());
        }
        return AUTHORS;
    }

    @Override
    public int insert(Author author) {
        final String QUERY = "INSERT INTO author (pk_id, name, age) VALUES (?, ?, ?)";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, author.getPk_id());
            preparedStatement.setString(2, author.getName());
            preparedStatement.setInt(3, author.getAge());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de inserción: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int delete(Author author) {
        final String QUERY = "DELETE FROM author WHERE pk_id = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, author.getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de borrado: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int update(Author author) {
        final String QUERY = "UPDATE author SET name = ?, age = ? WHERE pk_id = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setInt(2, author.getAge());
            preparedStatement.setString(3, author.getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updatePk_id(Author author, String pk_id) {
        final String QUERY = "UPDATE author SET pk_id = ? WHERE pk_id = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, pk_id);
            preparedStatement.setString(2, author.getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateName(Author author, String name) {
        final String QUERY = "UPDATE author SET name = ? WHERE pk_id = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, author.getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }

    @Override
    public int updateAge(Author author, int age) {
        final String QUERY = "UPDATE author SET age = ? WHERE pk_id = ?";
        try (Connection conn = DbConnectionSingleton.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, author.getPk_id());
            return preparedStatement.executeUpdate();
        } catch (SQLException sql_ex) {
            System.err.println("Error al lanzar la consulta de actualización: " + sql_ex.getMessage());
        }
        return 0;
    }
}