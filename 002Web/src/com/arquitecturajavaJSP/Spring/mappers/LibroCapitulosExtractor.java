package com.arquitecturajavaJSP.Spring.mappers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;

public class LibroCapitulosExtractor implements ResultSetExtractor<List<Libro>>{

	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Libro> listaLibros = new ArrayList<Libro>();
			
			while (rs.next()) {
				Libro l = new Libro(rs.getString("isbn"), rs.getString("autor"), rs.getString("titulo"));
				if (!listaLibros.contains(l)) {
					listaLibros.add(l);
					l.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"),rs.getInt("paginas"),l));
				}else {
					listaLibros.get(listaLibros.size()-1).addCapitulo(new Capitulo(rs.getString("tituloCapitulo"),rs.getInt("paginas"),l));
				}
				
			}
		return listaLibros;
	}

	

}
