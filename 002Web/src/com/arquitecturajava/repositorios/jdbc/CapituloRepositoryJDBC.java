package com.arquitecturajava.repositorios.jdbc;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.spring.mappers.CapituloMapper;
@Repository
public class CapituloRepositoryJDBC implements CapituloRepository{
	private DataSource datasource;
	private JdbcTemplate plantilla;
	
	public CapituloRepositoryJDBC(DataSource datasource, JdbcTemplate plantilla) {
		super();
		this.datasource = datasource;
		this.plantilla = plantilla;
	}

	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas,libros_isbn) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Capitulos where titulo =?";
	final static String CONSULTA = "select * from Capitulos";
	final static String CONSULTA_BUSCAR_UNO = "select * from Capitulos where titulo=?";
	final static String CONSULTA_BUSCAR_UNO_TITULO = "select * from Capitulos where titulo=?";


	@Override
	public void insertar(Capitulo capitulo) {

		plantilla.update(CONSULTA_INSERTAR, capitulo.getTitulo(),capitulo.getPaginas(),capitulo.getLibro().getIsbn());
		
	}
	

	@Override
	public void borrar(Capitulo capitulo) {

		plantilla.update(CONSULTA_BORRAR, capitulo.getTitulo());
	}

	@Override
	public List<Capitulo> buscarTodos() {

		return plantilla.query(CONSULTA,new CapituloMapper());
	}
}
