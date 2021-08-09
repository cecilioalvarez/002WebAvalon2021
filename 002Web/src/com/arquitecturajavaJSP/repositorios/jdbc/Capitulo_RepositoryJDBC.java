package com.arquitecturajavaJSP.repositorios.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajavaJSP.Spring.mappers.CapituloMapper;
import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.CapituloRepository;
@Component
public class Capitulo_RepositoryJDBC implements CapituloRepository {
	
	//Al usar Plantilla ya no es necesario agregarlo al constructor
	//private DataSource datasource;
	private JdbcTemplate plantilla;
	
	final static String QUERYINSERT = "INSERT INTO capitulos (titulo, paginas,libros_isbn) VALUES(?,?,?)";
	final static String QUERYDELETE= "DELETE FROM capitulos WHERE titulo=?";
	final static String QUERYSELECT = "SELECT * FROM capitulos";
	final static String QUERYFINDONE = "SELECT * FROM capitulos WHERE titulo=?";
	final static String QUERYFINDBYBOOK = "SELECT * FROM capitulos WHERE libros_isbn=?";
	final static String QUERYUPDATE = "UPDATE capitulos set libros_isbn=?,paginas=? WHERE titulo=?";
	
	//Spring Inyecta el datasource de Spring por el constructor
	public Capitulo_RepositoryJDBC(JdbcTemplate plantilla) {
		super();
		//this.datasource = datasource;
		this.plantilla = plantilla;
	}

	@Transactional
	@Override
	public void addChapter(Capitulo chapter) {
		
		plantilla.update(QUERYINSERT,chapter.getTitulo(),chapter.getPaginas(),chapter.getLibro().getIsbn());
		
	}
	
	@Transactional
	@Override
	public void removeChapter(Capitulo chapter) {
		
		plantilla.update(QUERYDELETE,chapter.getTitulo());
		
	}
	
	@Transactional
	@Override
	public void modifyChapter(Capitulo chapter) {
		
		plantilla.update(QUERYDELETE,chapter.getLibro().getIsbn(),chapter.getPaginas(),chapter.getTitulo());
		
	}
	
	@Override
	public List<Capitulo>getAllChapters(){
		
		return plantilla.query(QUERYSELECT,new CapituloMapper());
	}
	@Override
	public List<Capitulo>getAllChaptersByBook(Libro libro){
		
		return plantilla.query(QUERYFINDBYBOOK, new CapituloMapper(),libro.getIsbn());
	}
	
	

	@Override
	public Capitulo getOneChapter(Capitulo chapter) {
		
		return plantilla.queryForObject(QUERYFINDBYBOOK, new CapituloMapper(),chapter.getLibro().getIsbn());
		
	}
	
}
