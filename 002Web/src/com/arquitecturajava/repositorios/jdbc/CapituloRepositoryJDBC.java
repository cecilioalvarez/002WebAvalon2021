package com.arquitecturajava.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.spring.mappers.CapituloMapper;
@Component
public class CapituloRepositoryJDBC implements CapituloRepository {

	private JdbcTemplate plantilla;
	private DataSource dataSource;
	
	public CapituloRepositoryJDBC(DataSource dataSource,JdbcTemplate plantilla) {
		super();
		this.dataSource = dataSource;
		this.plantilla=plantilla;
	}


	final static String CONSULTA_BUSCAR_TODOS = "select * from Capitulos";
	final static String CONSULTA_BORRAR = "delete from Capitulos where titulo=?";
	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas,libros_isbn) values (?,?,?)";
	
	
	
	
	@Override
	public List<Capitulo> buscarTodos() {
		
	
				return plantilla.query(CONSULTA_BUSCAR_TODOS,new CapituloMapper());
	}
	@Override
	public void borrar(Capitulo capitulo) {
		
		
		plantilla.update(CONSULTA_BORRAR,capitulo.getTitulo());
	}
	
	
	public void insertar(Capitulo capitulo) {

		plantilla.update(CONSULTA_INSERTAR,capitulo.getTitulo(),capitulo.getPaginas(),capitulo.getLibro().getIsbn());

	}

}
