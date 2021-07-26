package com.arquitecturajavaJSP.repositorios.jdbc.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseHelper {

	private String url;
	private String user;
	private String pass;
	private Properties dBProperties= new Properties();
	
	public DataBaseHelper(String url, String user, String pass) {
		super();
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	public DataBaseHelper() {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("DataBase.properties");

			dBProperties.load(input);

			url=dBProperties.getProperty("url");
			user=dBProperties.getProperty("user");
			pass=dBProperties.getProperty("pass");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public Connection getConexion() throws SQLException {
		return DriverManager.getConnection(getUrl(),getUser(),getPass());
	}
}
