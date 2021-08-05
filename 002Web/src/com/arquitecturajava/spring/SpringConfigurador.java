package com.arquitecturajava.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.arquitecturajava")
@PropertySource("classpath:database.properties")
public class SpringConfigurador {
	@Value("${url}")
	private String url;
	@Value("${user}")
	private String user;
	@Value("${password}")
	private String password;
	
	
	// datasource
	// es un objeto que acabo de instanaciar a nivel de Spring Framework
	// ahora si que cargo la base de datos desde un dataSource
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword("");

		return dataSource;
	}
	
}
