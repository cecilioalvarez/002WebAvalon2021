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
import com.arquitecturajava.spring.mappers.LibroCapitulosExtractor;
import com.arquitecturajava.spring.mappers.LibroMapper;
@Repository
public class LibroRepositoryJDBC implements LibroRepository {

	private DataSource dataSource;
	
	private JdbcTemplate plantilla;
	
	public LibroRepositoryJDBC(DataSource dataSource,JdbcTemplate plantilla) {
		super();
		this.dataSource = dataSource;
		this.plantilla=plantilla;
	}

	final static String CONSULTA_INSERTAR = "insert into Libros (isbn,titulo,autor) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Libros  where isbn =?";
	final static String CONSULTA_BUSCAR_TODOS = "select * from Libros";
	final static String CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO = "select * from Capitulos where libros_isbn=?";
	final static String CONSULTA_BUSCAR_TODOS_CON_CAPITULOS = "select Libros.isbn as isbn, Libros.titulo as titulo, Libros.autor as autor, Capitulos.titulo as tituloCapitulo, Capitulos.paginas as paginas from Libros,Capitulos where Libros.isbn= Capitulos.libros_isbn";
	final static String CONSULTA_BUSCAR_UNO = "select * from Libros where isbn=?";
	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from Libros where titulo=? and autor=?";
	final static String CONSULTA_ACTUALIZAR = "update Libros set titulo=? , autor=? where isbn=?";

	
	
	public void actualizar(Libro libro) {

		plantilla.update(CONSULTA_ACTUALIZAR,
				libro.getTitulo(),libro.getAutor(),libro.getIsbn());

	}

	public void insertar(Libro libro) {

			
			plantilla.update(CONSULTA_INSERTAR,
					libro.getIsbn(),libro.getTitulo(),libro.getAutor());
		

	}

	public void borrar(Libro libro) {

		plantilla.update(CONSULTA_BORRAR,
				libro.getIsbn());

	}
	// porque vamos a buscar todos los libros
	// no tiene mucho sentido instanciar un libro
	// para luego más adelante buscar todos

	public List<Libro> buscarTodos() {

		
		return plantilla.query(CONSULTA_BUSCAR_TODOS,new LibroMapper());
	

	}

	public List<Libro> buscarTituloyAutor(String titulo, String autor) {

		
		return plantilla.query(CONSULTA_BUSCAR_TITULO_AUTOR,new LibroMapper(),titulo,autor);
		
		}

	public Libro buscarUno(String isbn) {

		
		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO,new LibroMapper(),isbn);
		
		
		

	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {

		
		return plantilla.query(CONSULTA_BUSCAR_TODOS_CON_CAPITULOS,new LibroCapitulosExtractor());
		
		
		
		

	

	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {

		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();

		try (Connection conn = dataSource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO)) {

			sentencia.setString(1, libro.getIsbn());

			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				Libro l= new Libro(rs.getString("libros_isbn"));
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
