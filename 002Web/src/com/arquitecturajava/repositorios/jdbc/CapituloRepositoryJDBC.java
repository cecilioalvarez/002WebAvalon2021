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
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.jdbc.helper.DataBaseHelper;

public class CapituloRepositoryJDBC implements CapituloRepository{
	private static DataBaseHelper helper = new DataBaseHelper();
	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas,libros_isbn) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Capitulos where titulo =?";
	final static String CONSULTA = "select * from Capitulos";
	final static String CONSULTA_BUSCAR_UNO = "select * from Capitulos where titulo=?";
	final static String CONSULTA_BUSCAR_UNO_TITULO = "select * from Capitulos where titulo=?";
	final static String ACTUALIZA_DATO = "update Capitulos set paginas=? where titulo =?";


	@Override
	public void insertar(Capitulo capitulo) {

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_INSERTAR);) {

			sentencia.setString(1, capitulo.getTitulo());
			sentencia.setInt(2, capitulo.getPaginas());
			sentencia.setString(3,capitulo.getLibro().getIsbn());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void actualizar(Capitulo capitulo) {

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(ACTUALIZA_DATO);) {

			sentencia.setInt(1, capitulo.getPaginas());
			sentencia.setString(2, capitulo.getTitulo());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void borrar(Capitulo capitulo) {

		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BORRAR);) {
			sentencia.setString(1, capitulo.getTitulo());
			sentencia.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Capitulo> buscarTodos() {

		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA);) {
			while (rs.next()) {

				Capitulo c = new Capitulo(rs.getString("titulo"), rs.getInt("paginas"),null);
				listaCapitulos.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCapitulos;
	}
	
	@Override
	public Capitulo buscarUno(String titulo) {

		Capitulo capitulo = null;
		
		try (Connection conn = helper.getConexion();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_BUSCAR_UNO);){
				sentencia.setString(1, titulo);
				ResultSet rs = sentencia.executeQuery();
				rs.next();

				capitulo = new Capitulo(rs.getString("titulo"), rs.getInt("paginas"),new Libro(rs.getString("libros_isbn")));
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return capitulo;
	}
	
}
