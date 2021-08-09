package com.arquitecturajavaspring.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arquitecturajava.negocio.Libro;

public class LibroMapper  implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Libro(rs.getString("isbn"),rs.getString("titulo"),rs.getString("autor"));
	}
	
	
}
