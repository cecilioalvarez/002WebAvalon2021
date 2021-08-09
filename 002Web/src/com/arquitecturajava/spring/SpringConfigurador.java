package com.arquitecturajava.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.arquitecturajava")
@PropertySource("classpath:database.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfigurador {
	
	
	@Value("${url}")
	private String url;
	@Value("${usuario}")
	private String user;
	@Value("${password}")
	private String password;
	
	
	
	
	@Bean
	public PlatformTransactionManager txManager() {
		
	    return new DataSourceTransactionManager(dataSource()); // (2)
	}
	

	// datasource
	// es un objeto que acabo de instanaciar a nivel de Spring Framework
	// ahora si que cargo la base de datos desde un dataSource
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	public JdbcTemplate plantillaJDBC() {
		return new JdbcTemplate(dataSource());
	}

}
