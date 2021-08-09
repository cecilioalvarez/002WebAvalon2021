package com.arquitecturajava.spring.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;

public class LibroCapitulosMapper implements RowMapper<Libro>{

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro libro = new Libro(rs.getString("isbn"), rs.getString("titulo"),rs.getString("autor"));
		Capitulo c = new Capitulo(rs.getString("titulo"),rs.getInt("paginas"), libro);
		libro.addCapitulo(c);
		rs.next();
		while(rs.getString("isbn").equals(libro.getIsbn())) {
			Capitulo c1 = new Capitulo(rs.getString("titulo"),rs.getInt("paginas"), libro);
			libro.addCapitulo(c1);
			rs.next();
		}
		rs.previous();
		return libro;
	}

}
