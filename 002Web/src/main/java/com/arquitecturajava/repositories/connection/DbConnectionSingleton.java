package com.arquitecturajava.repositories.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionSingleton {
    
    private static final DatabaseHelper DB_PROPERTIES = new DatabaseHelper();
    private static Connection conn;

    private static void createConnection() throws SQLException {
        DbConnectionSingleton.conn = DriverManager.getConnection(
                DbConnectionSingleton.DB_PROPERTIES.getUrl(), 
                DbConnectionSingleton.DB_PROPERTIES.getUser(), 
                DbConnectionSingleton.DB_PROPERTIES.getPassword()
                /*"jdbc:mysql://localhost:3306/avalon", 
                "avalon", 
                "avalon"*/
        );
    }

    public static Connection getConnection() {
        try {
            if (DbConnectionSingleton.conn == null || DbConnectionSingleton.conn.isClosed()) {
                DbConnectionSingleton.createConnection();
            }
        } catch (SQLException sql_ex) {
            System.out.println("Se ha producido un error al obtener la conexión con la BD: "+ sql_ex.getMessage());
        }
        return DbConnectionSingleton.conn;
    }
}