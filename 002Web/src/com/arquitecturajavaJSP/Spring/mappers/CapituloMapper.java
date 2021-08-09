package com.arquitecturajavaJSP.Spring.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;

public class CapituloMapper implements RowMapper<Capitulo>{

	@Override
	public Capitulo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Capitulo(rs.getString("titulo"), rs.getInt("paginas"), new Libro(rs.getString("libros_isbn")));
	}

}
