package com.arquitecturajavaJSP.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.CapituloRepository;
import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.repositorios.jdbc.helper.DataBaseHelper;

public class Capitulo_RepositoryJDBC implements CapituloRepository {
	
	final static String QUERYINSERT = "INSERT INTO capitulos (titulo, paginas,libros_isbn) VALUES(?,?,?)";
	final static String QUERYDELETE= "DELETE FROM capitulos WHERE titulo=?";
	final static String QUERYSELECT = "SELECT * FROM capitulos";
	final static String QUERYFINDONE = "SELECT * FROM capitulos WHERE titulo=?";
	final static String QUERYFINDBYBOOK = "SELECT * FROM capitulos WHERE libros_isbn=?";
	final static String QUERYUPDATE = "UPDATE capitulos set libros_isbn=?,paginas=? WHERE titulo=?";
	private static DataBaseHelper helper= new DataBaseHelper();
	
	@Override
	public void addChapter(Capitulo chapter) {
		
		try(Connection conn = helper.getConexion();){
			conn.setAutoCommit(false);
			try(PreparedStatement prepSentencia = conn.prepareStatement(QUERYINSERT);){
				//PreparedStatement
			
				prepSentencia.setString(1, chapter.getTitulo());
				prepSentencia.setInt(2, chapter.getPaginas());
				prepSentencia.setString(3, chapter.getLibro().getIsbn());
			
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
	public void removeChapter(Capitulo chapter) {
		
		try(Connection conn = helper.getConexion();){
			conn.setAutoCommit(false);
			try(PreparedStatement prepSentencia = conn.prepareStatement(QUERYDELETE);){
				//PreparedStatement
			
				prepSentencia.setString(1, chapter.getTitulo());
			
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
	public List<Capitulo>getAllChapters(){
		
		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();
		try(Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();) {
			//Para Resultados de SELECT
			ResultSet rs = sentencia.executeQuery(QUERYSELECT);
			
			while (rs.next()) {
				Capitulo chapterAux = new Capitulo(rs.getString("titulo"), 
						rs.getInt("paginas"),new Libro(rs.getString("libros_isbn")));
				listaCapitulos.add(chapterAux);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCapitulos;
	}
	@Override
	public List<Capitulo>getAllChaptersByBook(Libro libro){
		
		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();
		try(Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERYFINDBYBOOK);) {
			
			sentencia.setString(1, libro.getIsbn());
			//Para Resultados de SELECT
			ResultSet rs = sentencia.executeQuery();
			
			while (rs.next()) {
				Capitulo chapterAux = new Capitulo(rs.getString("titulo"), 
						rs.getInt("paginas"),new Libro(rs.getString("libros_isbn")));
				listaCapitulos.add(chapterAux);
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCapitulos;
	}
	
	
	@Override
	public void modifyChapter(Capitulo chapter) {
		
		try(Connection conn = helper.getConexion();){
			conn.setAutoCommit(false);
			try(PreparedStatement prepSentencia = conn.prepareStatement(QUERYUPDATE);){
				//PreparedStatement
				
				prepSentencia.setString(1, chapter.getLibro().getIsbn());
				prepSentencia.setInt(2, chapter.getPaginas());
				
				prepSentencia.setString(3, chapter.getTitulo());
			
				prepSentencia.executeUpdate();
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
	public Capitulo getOneChapter(Capitulo chapter) {
		Capitulo miCapitulo =null;
		try(Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(QUERYFINDONE);) {
			sentencia.setString(1, chapter.getTitulo());
			//Para Resultados de SELECT
			ResultSet rs = sentencia.executeQuery();
			
			rs.next(); 
			miCapitulo = new Capitulo(rs.getString("titulo"), 
						rs.getInt("paginas"),new Libro(rs.getString("libros_isbn")));
				
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return miCapitulo;
	}
	
}
