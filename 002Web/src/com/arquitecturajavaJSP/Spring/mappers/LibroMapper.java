package com.arquitecturajavaJSP.Spring.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arquitecturajavaJSP.negocio.Libro;

public class LibroMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Libro(rs.getString("isbn"),rs.getString("autor"),rs.getString("titulo"));
	}

}
