package com.arquitecturajavaspring;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
@ComponentScan("com.arquitecturajava.*")
@PropertySource("classpath:database.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfigurador implements ApplicationContextAware{
	
	@Value("${url}")
	private String url;
	@Value("${usuario}")
	private String usuario;
	@Value("${password}")
	private String password;
	private ApplicationContext contexto;
	
	@Bean
	public PlatformTransactionManager txManager() {
	    return new DataSourceTransactionManager(dataSource()); 
	}

	
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


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.contexto=applicationContext;
		
	}
	
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	@Bean
	public ISpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		return engine;
	}
	
	// la carpeta donde se van a ubicar los ficheros html
		private ITemplateResolver templateResolver() {
			// que resolutor de plantillas uso
			SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
			//contexto con todos los objetos de spring
			resolver.setApplicationContext(contexto);
			resolver.setPrefix("/WEB-INF/vistas/");
			resolver.setSuffix(".html");

			resolver.setCacheable(false);
			resolver.setTemplateMode(TemplateMode.HTML);
			return resolver;
		}



}
