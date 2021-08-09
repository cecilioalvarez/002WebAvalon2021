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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajavaspring.mappers.LibroCapitulosExtractor;
import com.arquitecturajavaspring.mappers.LibroMapper;

@Repository
public class LibroRepositoryJDBC implements LibroRepository {

	private DataSource dataSource;

	private JdbcTemplate plantilla;

	final static String CONSULTA_INSERTAR = "insert into libros (isbn,titulo,autor) values(?,?,?)";
	final static String CONSULTA_BORRAR = "delete from libros where isbn=?";
	final static String CONSULTA_BUSCAR_TODOS = "select * from libros";
	final static String CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO = "select * from capitulos where libros_isbn=?";
	final static String CONSULTA_BUSCAR_TODOS_CON_CAPITULOS = "select libros.*, capitulos.titulo as tituloCapitulo, capitulos.paginas from libros inner join capitulos on libros.isbn=capitulos.libros_isbn";
	final static String CONSULTA_BUSCAR_UNO = "select * from libros where isbn=?";
	final static String CONSULTA_ACTUALIZAR = "update libros set titulo=? , autor=? where isbn=?";
	final static String CONSULTA_BUSCAR_TITULO = "select * from libros where titulo=?";
	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from libros where titulo=? AND autor=?";

	public LibroRepositoryJDBC(DataSource dataSource, JdbcTemplate plantilla) {
		super();
		this.dataSource = dataSource;
		this.plantilla = plantilla;

	}

	public void insertar(Libro libro) {

		plantilla.update(CONSULTA_INSERTAR, libro.getIsbn(), libro.getTitulo(), libro.getAutor());

	}

	public void borrar(Libro libro) {

		plantilla.update(CONSULTA_BORRAR, libro.getIsbn());

	}

	public void actualizar(Libro libro) {

		plantilla.update(CONSULTA_ACTUALIZAR, libro.getTitulo(), libro.getAutor(), libro.getIsbn());

	}

	public List<Libro> buscarTodos() {

		return plantilla.query(CONSULTA_BUSCAR_TODOS, new LibroMapper());

	}

	public Libro buscarUno(String isbn) {
		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO, new LibroMapper(),isbn);

	}

	public Libro buscarPorTitulo(String titulo) {
		
		return plantilla.queryForObject(CONSULTA_BUSCAR_TITULO, new LibroMapper(),titulo);
		
	}

	public Libro buscarPorAutor(String autor) {
		
		return plantilla.queryForObject(CONSULTA_BUSCAR_TITULO, new LibroMapper(),autor);
		
	}

	public List<Libro> buscarPorIituloAutor(String titulo, String autor) {

		return plantilla.query(CONSULTA_BUSCAR_TITULO_AUTOR, new LibroMapper(),titulo,autor);

	}

	@Override
	public List<Libro> BuscarTodosConCapitulos() {
		return plantilla.query(CONSULTA_BUSCAR_TODOS_CON_CAPITULOS, new LibroCapitulosExtractor());
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();

		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO);
			sentencia.setString(1, libro.getIsbn());
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				Libro l = new Libro(rs.getString("libros_isbn"));
				Capitulo c = new Capitulo(rs.getString("titulo"), rs.getInt("paginas"), l);
				listaCapitulos.add(c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaCapitulos;
	}

}
