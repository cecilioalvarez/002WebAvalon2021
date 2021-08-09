package repositorio.jdbc.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import arquitecturasring.mappers.CapituloMapper;
import arquitecturasring.mappers.LibroCapitulosExtractor;
import arquitecturasring.mappers.LibroMapper;
import negocio.Libro;
import negocio.Capitulo;
import repositorio.LibroRepository;

@Repository
public class LibroRepositoryJDBC implements LibroRepository {

	private JdbcTemplate plantilla;

	final static String CONSULTA_INSERTAR = "insert into Libros (isbn,titulo,autor) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Libros  where isbn =?";
	final static String CONSULTA_BUSCAR_TODOS = "select * from Libros";
	final static String CONSULTA_BUSCAR_TODOS_CON_CAPITULOS = "select Libros.isbn as isbn, Libros.titulo as titulo, Libros.autor as autor, Capitulos.titulo as tituloCapitulo, Capitulos.paginas as paginas from Libros,Capitulos where Libros.isbn= Capitulos.libros_isbn";
	final static String CONSULTA_BUSCAR_UNO = "select * from Libros where isbn=?";
	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from Libros where titulo=? and autor=?";
	final static String CONSULTA_ACTUALIZAR = "update Libros set titulo=? , autor=? where isbn=?";
	final static String CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO = "select * from Capitulos where libros_isbn=?";

	public LibroRepositoryJDBC(JdbcTemplate plantilla) {
		super();
		this.plantilla = plantilla;
	}

	public void actualizar(Libro libro) {

		plantilla.update(CONSULTA_ACTUALIZAR, libro.getTitulo(), libro.getAutor(), libro.getIsbn());
	}

	public void insertar(Libro libro) {

		plantilla.update(CONSULTA_INSERTAR, libro.getIsbn(), libro.getTitulo(), libro.getAutor());

	}

	public void borrar(Libro libro) {

		plantilla.update(CONSULTA_BORRAR, libro.getIsbn());

	}

	public List<Libro> buscarTodos() {

		return plantilla.query(CONSULTA_BUSCAR_TODOS, new LibroMapper());

	}

	public List<Libro> buscarTituloyAutor(String titulo, String autor) {

		return plantilla.query(CONSULTA_BUSCAR_TITULO_AUTOR, new LibroMapper(), titulo, autor);

	}

	public Libro buscarUno(String isbn) {
		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO, new LibroMapper(), isbn);

	}

	@Override
	 public List<Libro> buscarTodosConCapitulos() {
        return plantilla.query(CONSULTA_BUSCAR_TODOS_CON_CAPITULOS, new LibroCapitulosExtractor());
    }

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		return plantilla.query(CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO,new CapituloMapper(), libro.getIsbn());

	}
}
