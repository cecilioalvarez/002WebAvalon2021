package com.arquitecturajavaspring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@ComponentScan("com.arquitecturajava.*")
@PropertySource("classpath:database.properties")
public class SpringConfigurador {
	
	@Value("${url}")
	private String url;
	@Value("${usuario}")
	private String usuario;
	@Value("${password}")
	private String password;
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setUrl(url);
		dataSource.setUsername(usuario);
		dataSource.setPassword(password);

		return dataSource;

	}
	
	@Bean()
	public JdbcTemplate plantillaJDBC() {
		return new JdbcTemplate(dataSource());
	}

}
