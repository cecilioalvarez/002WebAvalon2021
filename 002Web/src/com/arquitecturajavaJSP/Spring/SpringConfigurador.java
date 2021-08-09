package com.arquitecturajavaJSP.Spring;


import javax.sql.DataSource;

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
@ComponentScan("com.arquitecturajavaJSP.*")
@PropertySource("classpath:DataBase.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfigurador {
	
	@Value("${url}")
	private String url;
	@Value("${user}")
	private String usuario;
	@Value("${pass}")
	private String password;
	
	//private String driver;
	
	
	//dataSource,registrado en el inyector de dependencias para poder usarlo
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(url);
		dataSource.setUsername(usuario);
		dataSource.setPassword(password);

		return dataSource;

	}
	
	@Bean
	public JdbcTemplate plantillaJDBC() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public PlatformTransactionManager txManager() {
	    return new DataSourceTransactionManager(dataSource());
	}

}
