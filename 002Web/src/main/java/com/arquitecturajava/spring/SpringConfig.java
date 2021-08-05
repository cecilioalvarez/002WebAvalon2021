package com.arquitecturajava.spring;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.arquitecturajava.*")
@PropertySource("classpath:databaseProperties/avalonDb.properties")
public class SpringConfig {

    @Value("${url}")
    private String url;
    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;
    
    @Bean
    public DataSource getDataSource() {
        return new DriverManagerDataSource(url, username, password);
    }
}