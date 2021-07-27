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
	
	final static String CONSULTA_INSERTAR = "insert into libros (isbn,titulo,autor) values(?,?,?)";
	final static String CONSULTA_BORRAR = "delete from libros where isbn=?";
	final static String CONSULTA_BUSCAR_TODOS = "select * from libros";
	final static String CONSULTA_BUSCAR_TODOS_CON_CAPITULOS = "select libros.*, capitulos.titulo as tituloCapitulo, capitulos.paginas from libros inner join capitulos on libros.isbn=capitulos.libros_isbn";
	final static String CONSULTA_BUSCAR_UNO = "select * from libros where isbn=?";
	final static String CONSULTA_ACTUALIZAR = "update libros set titulo=? , autor=? where isbn=?";
	final static String CONSULTA_BUSCAR_TITULO = "select * from libros where titulo=?";
	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from libros where titulo=? AND autor=?";

	
	public void insertar(Libro libro) {

		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_INSERTAR);
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
		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BORRAR);
			sentencia.setString(1, libro.getIsbn());
			sentencia.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Libro> buscarTodos() {

		List<Libro> listaLibros = new ArrayList<Libro>();

		try {
			Connection conn = helper.getConexion();
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery(CONSULTA_BUSCAR_TODOS);
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
		Libro l = new Libro();
		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_UNO);

			sentencia.setString(1, isbn);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			l.setIsbn(rs.getString("isbn"));
			l.setTitulo(rs.getString("titulo"));
			l.setAutor(rs.getString("autor"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public void actualizar(Libro libro) {

		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_ACTUALIZAR);

			
			sentencia.setString(1, libro.getTitulo());
			sentencia.setString(2, libro.getAutor());
			sentencia.setString(3, libro.getIsbn());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Libro buscarPorTitulo(String titulo) {

		Libro l = new Libro();
		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TITULO);

			sentencia.setString(1, titulo);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			l.setIsbn(rs.getString("isbn"));
			l.setTitulo(rs.getString("titulo"));
			l.setAutor(rs.getString("autor"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	public Libro buscarPorAutor(String autor) {

		Libro l = new Libro();
		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TITULO);

			sentencia.setString(1, autor);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			l.setIsbn(rs.getString("isbn"));
			l.setTitulo(rs.getString("titulo"));
			l.setAutor(rs.getString("autor"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}
	
	public List<Libro> buscarPorIituloAutor(String titulo,String autor) {

		List<Libro> lista=new ArrayList<Libro>();
		try {
			Connection conn = helper.getConexion();
			PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_TITULO_AUTOR);

			sentencia.setString(1, titulo);
			sentencia.setString(2, autor);
			ResultSet rs = sentencia.executeQuery();
			rs.next();
			Libro l=new Libro(rs.getString("isbn"),rs.getString("titulo"),rs.getString("autor"));
			lista.add(l);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public List<Libro> BuscarTodosConCapitulos() {
		List<Libro> listaLibros = new ArrayList<Libro>();

		try {
			Connection conn = helper.getConexion();
			Statement sentencia = conn.createStatement();
			ResultSet rs = sentencia.executeQuery(CONSULTA_BUSCAR_TODOS_CON_CAPITULOS);
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));
				if(!listaLibros.contains(l)) {
					listaLibros.add(l);
					l.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"),rs.getInt("paginas")));
				}else {
					listaLibros.get(listaLibros.size()-1).addCapitulo(new Capitulo(rs.getString("tituloCapitulo"),rs.getInt("paginas")));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaLibros;
	}

}
