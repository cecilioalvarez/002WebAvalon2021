package com.arquitecturajava.repositorios.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.jdbc.helper.DataBaseHelper;

public class CapituloRepositoryJDBC implements CapituloRepository {

	private static DataBaseHelper helper = new DataBaseHelper();
	
	final static String CONSULTA_BUSCAR_TODOS = "select * from Capitulos";
	
	@Override
	public List<Capitulo> buscarTodos() {
		
		
		List<Capitulo> listaCapitulos = new ArrayList<Capitulo>();

		try (Connection conn = helper.getConexion();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA_BUSCAR_TODOS);) {
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

}
