package com.arquitecturajava.repositories.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionSingleton {
    
    private final DatabaseHelper DB_PROPERTIES;
    private static Connection conn;
    
    private DbConnectionSingleton() throws SQLException {
        this.DB_PROPERTIES = new DatabaseHelper();
        DbConnectionSingleton.conn = DriverManager.getConnection(
                this.DB_PROPERTIES.getUrl(),
                this.DB_PROPERTIES.getUser(),
                this.DB_PROPERTIES.getPassword()
                /*"jdbc:mysql://localhost:3306/avalon", 
                "avalon", 
                "avalon"*/
        );
    }

    public static Connection getConnection() {
        try {
            if (DbConnectionSingleton.conn == null || DbConnectionSingleton.conn.isClosed()) {
                new DbConnectionSingleton();
            }
        } catch (SQLException sql_ex) {
            System.out.println("Se ha producido un error al obtener la conexión con la BD: "+ sql_ex.getMessage());
        }
        return DbConnectionSingleton.conn;
    }
}