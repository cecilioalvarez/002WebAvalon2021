package com.arquitecturajava.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.repositorios.jdbc.helper.DataBaseHelper;

public class Libro_RepositoryJDBC implements LibroRepository {
	
	final static String QUERYINSERT = "INSERT INTO libro(isbn, titulo, autor) VALUES(?,?,?)";
	final static String QUERYDELETE= "DELETE FROM libro WHERE isbn=?";
	final static String QUERYSELECT = "SELECT * FROM libro";
	final static String queryFindAutor = "SELECT * FROM libro WHERE autor=?";
	final static String queryFindTitulo = "SELECT * FROM libro WHERE titulo=?";
	final static String QUERYFINDONE = "SELECT * FROM libro WHERE isbn=?";
	final static String QUERYUPDATE = "UPDATE libro set autor=?,titulo=? WHERE isbn=?";
	final static String QUERYSELECTWITHCHAPTERS="select libro.isbn as isbn, libro.titulo as titulo, libro.autor as autor, Capitulos.titulo as tituloCapitulo, Capitulos.paginas as paginas from libro,Capitulos where libro.isbn= Capitulos.libros_isbn";
	private static DataBaseHelper helper= new DataBaseHelper();
	
	
	@Override
	public void addBook(Libro libro) {
		
		try(Connection conn = helper.getConexion();){
			conn.setAutoCommit(false);
			try(PreparedStatement prepSentencia = conn.prepareStatement(QUERYINSERT);){
				//PreparedStatement
			
				prepSentencia.setString(1, libro.getIsbn());
				prepSentencia.setString(2, libro.getTitulo());
				prepSentencia.setString(3, libro.getAutor());
			
				prepSentencia.execute();
			}catch (Exception ex) {
				ex.printStackTrace();
				conn.rollback();
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void removeBook(Libro libro) {
		
		try(Connection conn = helper.getConexion();){
			conn.setAutoCommit(false);
			try(PreparedStatement prepSentencia = conn.prepareStatement(QUERYDELETE);){
				//PreparedStatement
			
				prepSentencia.setString(1, libro.getIsbn());
			
				prepSentencia.execute();
			}catch (Exception ex) {
				ex.printStackTrace();
				conn.rollback();
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Libro>buscarTodosLibros(){
		
		List<Libro> listaLibros = new ArrayList<Libro>();
		try(Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();) {
			//Para Resultados de SELECT
			ResultSet rs = sentencia.executeQuery(QUERYSELECT);
			
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				listaLibros.add(l);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibros;
	}
	
	@Override
	public Libro buscarLibro(String isbn){
		
		Libro libro = null;
		try(Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERYFINDONE);) {
			sentencia.setString(1, isbn);
			//Para Resultados de SELECT
			
			ResultSet rs = sentencia.executeQuery();
			if(rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				libro= l;
			}
				
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libro;
	}
	
	@Override
	public List<Libro> buscarLibroAutor(String autor){
		
		List<Libro> librosAutor = new ArrayList<Libro>();
		try(Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(queryFindAutor);) {
			sentencia.setString(1, autor);
			//Para Resultados de SELECT
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				librosAutor.add(l);
			}
				
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return librosAutor;
	}
	
	@Override
	public List<Libro> buscarLibroTitulo(String titulo){
		
		List<Libro> librosAutor = new ArrayList<Libro>();
		try(Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(queryFindTitulo);) {
			sentencia.setString(1, titulo);
			//Para Resultados de SELECT
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				librosAutor.add(l);
			}
				
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return librosAutor;
	}
	
	@Override
	public List<Libro> buscarLibroAutorTitulo(String autor,String titulo){
		
		List<Libro> librosAutor = new ArrayList<Libro>();
		try(Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(queryFindTitulo);) {
			
			sentencia.setString(1, autor);
			sentencia.setString(2, titulo);
			//Para Resultados de SELECT
			
			ResultSet rs = sentencia.executeQuery();
			while(rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				librosAutor.add(l);
			}
				
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return librosAutor;
	}
	
	@Override
	public void modifyBook(Libro libro) {
		
		try(Connection conn = helper.getConexion();){
			conn.setAutoCommit(false);
			try(PreparedStatement prepSentencia = conn.prepareStatement(QUERYUPDATE);){
				//PreparedStatement
			
				prepSentencia.setString(1, libro.getAutor());
				prepSentencia.setString(2, libro.getTitulo());
				prepSentencia.setString(3, libro.getIsbn());
			
				prepSentencia.execute();
			}catch (Exception ex) {
				ex.printStackTrace();
				conn.rollback();
			}
			
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Libro> buscarTodosLibrosConCapitulos() {
		List<Libro> listaLibros = new ArrayList<Libro>();
		try(Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();) {
			//Para Resultados de SELECT
			ResultSet rs = sentencia.executeQuery(QUERYSELECTWITHCHAPTERS);
			
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				if (!listaLibros.contains(l)) {
					listaLibros.add(l);
					l.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"),rs.getInt("paginas"),l));
				}else {
					listaLibros.get(listaLibros.size()-1).addCapitulo(new Capitulo(rs.getString("tituloCapitulo"),rs.getInt("paginas"),l));
				}
				
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibros;
	}

	
	
	
	
	
}
