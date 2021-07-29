package com.arquitecturajava.repositories.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class DatabaseHelper {

    // Esta ruta funciona siempre que se ubique en la carpeta bin del directorio de instalación de Tomcat.
    private static final String DEFAULT_PROPERTIES_FILE_PATH = "databaseProperties\\avalonDb.properties";
    private String url;
    private String user;
    private String password;

    String getUrl() {
        return this.url;
    }

    String getUser() {
        return this.user;
    }

    String getPassword() {
        return this.password;
    }

    DatabaseHelper(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    DatabaseHelper(String propertiesFilePath) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(new File(propertiesFilePath)));
            this.url = prop.getProperty("url");
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
        } catch (FileNotFoundException fnf_ex) {
            System.err.println("Se ha producido un error al buscar el fichero de propiedades de la BD: " + fnf_ex.getMessage());
        } catch (IOException io_ex) {
            System.err.println("Se ha producido un error al leer el fichero de propiedades de la BD: " + io_ex.getMessage());
        }
    }

    DatabaseHelper() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(new File(DatabaseHelper.DEFAULT_PROPERTIES_FILE_PATH)));
            this.url = prop.getProperty("url");
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
        } catch (FileNotFoundException fnf_ex) {
            System.err.println("Se ha producido un error al buscar el fichero de propiedades de la BD: " + fnf_ex.getMessage());
        } catch (IOException io_ex) {
            System.err.println("Se ha producido un error al leer el fichero de propiedades de la BD: " + io_ex.getMessage());
        }
    }
}