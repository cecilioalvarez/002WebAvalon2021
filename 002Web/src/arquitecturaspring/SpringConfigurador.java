package arquitecturaspring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("repositorio.*")
//accedo a las propiedades
@PropertySource("classpath:database.properties")
public class SpringConfigurador {

	@Value("${url}")
	private String url;
	@Value("${user}")
	private String user;
	@Value("${password}")
	private String password;

	private String driver;

	//Objeto que se acaba de instanciar a nivel de Spring Framework
	//cargo la base de datos desde un dataSource
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
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
