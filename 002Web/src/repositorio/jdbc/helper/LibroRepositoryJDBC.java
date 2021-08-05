package repositorio.jdbc.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import negocio.Libro;
import negocio.Capitulo;
import repositorio.LibroRepository;
@Component
public class LibroRepositoryJDBC implements LibroRepository {



	private DataSource datasource;
	
	final static String CONSULTA_INSERTAR = "insert into Libros (isbn,titulo,autor) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Libros  where isbn =?";
	final static String CONSULTA_BUSCAR_TODOS = "select * from Libros";
	final static String CONSULTA_BUSCAR_TODOS_CON_CAPITULOS = "select Libros.isbn as isbn, Libros.titulo as titulo, Libros.autor as autor, Capitulos.titulo as tituloCapitulo, Capitulos.paginas as paginas from Libros,Capitulos where Libros.isbn= Capitulos.libros_isbn";
	final static String CONSULTA_BUSCAR_UNO = "select * from Libros where isbn=?";
	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from Libros where titulo=? and autor=?";
	final static String CONSULTA_ACTUALIZAR = "update Libros set titulo=? , autor=? where isbn=?";
	final static String CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO = "select * from Capitulos where libros_isbn=?";

	
	
	public LibroRepositoryJDBC(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	public void actualizar(Libro libro) {

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_ACTUALIZAR);) {

			sentencia.setString(1, libro.getTitulo());
			sentencia.setString(2, libro.getAutor());
			sentencia.setString(3, libro.getIsbn());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertar(Libro libro) {

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_INSERTAR);) {

			sentencia.setString(1, libro.getIsbn());
			sentencia.setString(2, libro.getTitulo());
			sentencia.setString(3, libro.getAutor());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void borrar(Libro libro) {

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BORRAR);) {
			sentencia.setString(1, libro.getIsbn());
			sentencia.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// porque vamos a buscar todos los libros
	// no tiene mucho sentido instanciar un libro
	// para luego m�s adelante buscar todos

	public List<Libro> buscarTodos() {

		List<Libro> listaLibros = new ArrayList<Libro>();

		try (Connection conn = datasource.getConnection();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA_BUSCAR_TODOS);) {
			while (rs.next()) {

				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));
				listaLibros.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibros;

	}

	public List<Libro> buscarTituloyAutor(String titulo, String autor) {

		List<Libro> listaLibros = new ArrayList<Libro>();

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TITULO_AUTOR);) {
			sentencia.setString(1, titulo);
			sentencia.setString(2, autor);

			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {

				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));
				listaLibros.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibros;

	}

	public Libro buscarUno(String isbn) {

		Libro libro = null;

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_UNO);) {
			sentencia.setString(1, isbn);
			ResultSet rs = sentencia.executeQuery();
			rs.next();

			libro = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return libro;

	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {

		List<Libro> listaLibros = new ArrayList<Libro>();

		try (Connection conn = datasource.getConnection();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA_BUSCAR_TODOS_CON_CAPITULOS);) {
			while (rs.next()) {

				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));

				if (!listaLibros.contains(l)) {
					listaLibros.add(l);
					l.addCap(new Capitulo(rs.getString("tituloCapitulo"), rs.getInt("paginas")));
				} else {
					listaLibros.get(listaLibros.size() - 1)
							.addCap(new Capitulo(rs.getString("tituloCapitulo"), rs.getInt("paginas")));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibros;

	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO)) {

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
