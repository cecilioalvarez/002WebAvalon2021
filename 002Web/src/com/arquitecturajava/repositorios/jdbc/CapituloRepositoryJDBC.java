package com.arquitecturajava.repositorios.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajavaspring.mappers.CapituloMapper;

@Component
public class CapituloRepositoryJDBC implements CapituloRepository{
	
	
	
	private JdbcTemplate plantilla;
	
	final static String CONSULTA_BUSCAR_TODOS = "select * from capitulos";
	final static String CONSULTA_BORRAR = "delete from capitulos where titulo=?";
	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas, libros_isbn) values (?,?,?)";

	
	public CapituloRepositoryJDBC(JdbcTemplate plantilla) {
		super();
		
		this.plantilla=plantilla;
	}


	@Override
	public List<Capitulo> buscarTodos() {
		return plantilla.query(CONSULTA_BUSCAR_TODOS, new CapituloMapper());
	}

	
	public void insertar(Capitulo capitulo) {

		plantilla.update(CONSULTA_INSERTAR, capitulo.getTitulo(),capitulo.getPaginas(),capitulo.getLibro().getIsbn());
	}


	@Override
	public void borrar(Capitulo capitulo) {
		plantilla.update(CONSULTA_BORRAR, capitulo.getTitulo());
		
	}
	
	

}
