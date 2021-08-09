package com.arquitecturajava.repositorios.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
@Component
public class CapituloRepositoryJDBC implements CapituloRepository{
	private DataSource datasource;
	
	public CapituloRepositoryJDBC(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas,libros_isbn) values (?,?,?)";
	final static String CONSULTA_BORRAR = "delete from Capitulos where titulo =?";
	final static String CONSULTA = "select * from Capitulos";
	final static String CONSULTA_BUSCAR_UNO = "select * from Capitulos where titulo=?";
	final static String CONSULTA_BUSCAR_UNO_TITULO = "select * from Capitulos where titulo=?";


	@Override
	public void insertar(Capitulo capitulo) {

		try (Connection conn = datasource.getConnection();
				PreparedStatement sentencia = conn.prepareStatement(CONSULTA_INSERTAR);) {
			sentencia.setString(3, capitulo.getLibro().getIsbn());
			sentencia.setString(1, capitulo.getTitulo());
			sentencia.setInt(2, capitulo.getPaginas());
			sentencia.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void borrar(Capitulo capitulo) {

		try (Connection conn = datasource.getConnection();
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

		try (Connection conn = datasource.getConnection();
				Statement sentencia = conn.createStatement();
				ResultSet rs = sentencia.executeQuery(CONSULTA);) {
			while (rs.next()) {

				Capitulo c = new Capitulo(rs.getString("titulo"), rs.getInt("paginas"),new Libro(rs.getString("libros_isbn")));
				listaCapitulos.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaCapitulos;
	}
}
