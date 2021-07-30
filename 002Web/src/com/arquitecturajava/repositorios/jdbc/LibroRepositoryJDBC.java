package com.arquitecturajava.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.helper.DataBaseHelper;

public class LibroRepositoryJDBC implements LibroRepository {

	private static DataBaseHelper helper = new DataBaseHelper();
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

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_INSERTAR);) {

			sentencia.setString(1, libro.getIsbn());
			sentencia.setString(2, libro.getTitulo());
			sentencia.setString(3, libro.getAutor());
			sentencia.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actualizar(Libro libro) {

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(ACTUALIZA_DATO);) {

			sentencia.setString(1, libro.getTitulo());
			sentencia.setString(2, libro.getAutor());
			sentencia.setString(3, libro.getIsbn());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void borrar(Libro libro) {

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BORRAR);) {
			sentencia.setString(1, libro.getIsbn());
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Libro> buscarTodos() {

		List<Libro> listaLibros = new ArrayList<Libro>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA);) {
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

	@Override
	public Libro buscarUno(String isbn) {

		Libro libro = null;

		try (Connection conn = helper.getConexion();
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
	public Libro buscarUnoPorTitulo(String titulo) {

		Libro libro = null;

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_UNO_TITULO);) {
			sentencia.setString(1, titulo);
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
	public Libro buscarUnoPorAutor(String autor) {

		Libro libro = null;

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_UNO_AUTOR);) {
			sentencia.setString(1, autor);
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
	public List<Libro> buscarTodosTituloAutor(String titulo, String autor) {

		List<Libro> listaLibros = new ArrayList<Libro>();

		try (Connection conn = helper.getConexion();
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

	@Override
	public List<Libro> buscarTodosConCapitulos() {
		List<Libro> listaLibros = new ArrayList<Libro>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA_TODOS_CON_CAPITULOS);) {

			while (rs.next()) {

				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));
				// Le decimos que si contiene un libro ya con el mismo isbn, no lo vuelva a
				// repetir el mismo libro dos veces.

				if (!listaLibros.contains(l)) {
					// Añadimos libro y capitulo
					listaLibros.add(l);
					l.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"), rs.getInt("paginas"), l));
				} else {
					listaLibros.get(listaLibros.size() - 1)
							.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"), rs.getInt("paginas"), l));
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

		try (Connection conn = helper.getConexion()){
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_LIBRO_CAPITULOS);
				sentencia.setString(1, libro.getIsbn());
				ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {

				Capitulo c = new Capitulo(rs.getString("titulo"), rs.getInt("paginas"),null);
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
