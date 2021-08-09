package com.arquitecturajava.repositorios.jdbc;

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
import org.springframework.stereotype.Repository;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.spring.mappers.LibroCapitulosMapper;
import com.arquitecturajava.spring.mappers.LibroMapper;
@Repository
public class LibroRepositoryJDBC implements LibroRepository {

	private DataSource datasource;
	private JdbcTemplate plantilla;
	
	public LibroRepositoryJDBC(DataSource datasource, JdbcTemplate plantilla) {
		super();
		this.datasource = datasource;
		this.plantilla = plantilla;
	}

	final static String CONSULTA_INSERTAR = "insert into Libro (isbn,titulo,autor) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Libro where isbn =?";
	final static String CONSULTA = "select * from Libro";
	final static String CONSULTA_LIBRO_CAPITULOS = "select * from capitulos where libros_isbn=?";
	final static String CONSULTA_TODOS_CON_CAPITULOS = "SELECT libro.isbn as isbn, libro.titulo as titulo, libro.autor as autor, capitulos.titulo as tituloCapitulo, capitulos.paginas as paginas from Libro, capitulos where Libro.isbn = capitulos.libros_isbn;";
	final static String CONSULTA_BUSCAR_UNO = "select * from Libro where isbn=?";
	final static String CONSULTA_BUSCAR_UNO_TITULO = "select * from Libro where titulo=?";
	final static String CONSULTA_BUSCAR_UNO_AUTOR = "select * from Libro where autor=?";
	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from Libro where titulo =? and autor =?";
	final static String ACTUALIZA_DATO = "update Libro set titulo=?, autor =? where isbn =?";

	@Override
	public void insertar(Libro libro) {

			plantilla.update(CONSULTA_INSERTAR, libro.getIsbn(),libro.getTitulo(),libro.getAutor());
	}

	@Override
	public void actualizar(Libro libro) {

		plantilla.update(ACTUALIZA_DATO, libro.getTitulo(),libro.getAutor(),libro.getIsbn());

	}

	@Override
	public void borrar(Libro libro) {

		plantilla.update(CONSULTA_BORRAR, libro.getIsbn());

	}

	@Override
	public List<Libro> buscarTodos() {

			return	plantilla.query(CONSULTA, new LibroMapper()); 
	}

	@Override
	public Libro buscarUno(String isbn) {
		
		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO, new LibroMapper(),isbn);
	}

	@Override
	public Libro buscarUnoPorTitulo(String titulo) {

		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO_TITULO, new LibroMapper(), titulo);
		
	}

	@Override
	public Libro buscarUnoPorAutor(String autor) {

		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO_AUTOR, new LibroMapper(), autor);
	}

	@Override
	public List<Libro> buscarTodosTituloAutor(String titulo, String autor) {

		return	plantilla.query(CONSULTA_BUSCAR_TITULO_AUTOR, new LibroMapper(),titulo,autor); 
	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {
		return plantilla.query(CONSULTA_TODOS_CON_CAPITULOS, new LibroCapitulosMapper());
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
	
		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();

		try (Connection conn = datasource.getConnection()){
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_LIBRO_CAPITULOS);
				sentencia.setString(1, libro.getIsbn());
				ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				Libro l= new Libro(rs.getString("libros_isbn"));
				Capitulo c = new Capitulo(rs.getString("titulo"), rs.getInt("paginas"),l);
				listaCapitulos.add(c);
			}
		}catch(

	SQLException e)
	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return listaCapitulos;
}

}
