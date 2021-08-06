package com.arquitecturajavaJSP.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.LibroRepository;
import com.arquitecturajavaJSP.Spring.mappers.LibroCapitulosExtractor;
import com.arquitecturajavaJSP.Spring.mappers.LibroMapper;
import com.arquitecturajavaJSP.negocio.Capitulo;

@Repository
public class Libro_RepositoryJDBC implements LibroRepository {
	
	private DataSource datasource;
	
	private JdbcTemplate plantilla;
	
	final static String QUERYINSERT = "INSERT INTO libro(isbn, titulo, autor) VALUES(?,?,?)";
	final static String QUERYDELETE= "DELETE FROM libro WHERE isbn=?";
	final static String QUERYSELECT = "SELECT * FROM libro";
	final static String queryFindAutor = "SELECT * FROM libro WHERE autor=?";
	final static String queryFindTitulo = "SELECT * FROM libro WHERE titulo=?";
	final static String QUERYFINDONE = "SELECT * FROM libro WHERE isbn=?";
	
	final static String QUERYSELECTWITHCHAPTERS="select libro.isbn as isbn, libro.titulo as titulo, libro.autor as autor, Capitulos.titulo as tituloCapitulo, Capitulos.paginas as paginas from libro,Capitulos where libro.isbn= Capitulos.libros_isbn";
	
	public Libro_RepositoryJDBC(DataSource datasource,JdbcTemplate plantilla) {
		super();
		this.datasource = datasource;
		this.plantilla = plantilla;
	}

	@Override
	public void addBook(Libro libro) {
		
		plantilla.update(QUERYINSERT,libro.getIsbn(),libro.getTitulo(),libro.getAutor());
		
	}
	
	@Override
	public void removeBook(Libro libro) {
		
		plantilla.update(QUERYDELETE,libro.getIsbn());
		
	}
	
	
	@Override
	public List<Libro>buscarTodosLibros(){
		//query devuelve 1 lista
		return plantilla.query(QUERYSELECT, new LibroMapper());
		
	}
	
	@Override
	public Libro buscarLibro(String isbn){
		//queryForObject devuelve sólo 1
		return plantilla.queryForObject(QUERYFINDONE, new LibroMapper(),isbn);
		
	}
	
	@Override
	public List<Libro> buscarLibroAutor(String autor){
		
		return plantilla.query(queryFindAutor, new LibroMapper(),autor);
		
	}
	
	@Override
	public List<Libro> buscarLibroTitulo(String titulo){
		
		return plantilla.query(queryFindTitulo, new LibroMapper(),titulo);
		
	}
	
	@Override
	public List<Libro> buscarLibroAutorTitulo(String autor,String titulo){
		
		return plantilla.query(queryFindTitulo, new LibroMapper(),autor,titulo);
		
	}
	
	@Override
	public int modifyBook(Libro libro) {
		final String QUERYUPDATE = "UPDATE libro set autor=?,titulo=? WHERE isbn=?";
		
		int modificado = plantilla.update(QUERYUPDATE,libro.getAutor(),libro.getTitulo(),libro.getIsbn());
		
		
		return modificado;
	}

	@Override
	public List<Libro> buscarTodosLibrosConCapitulos() {
		return plantilla.query(QUERYSELECTWITHCHAPTERS, new LibroCapitulosExtractor());
	}

	
	
	
	
	
}
