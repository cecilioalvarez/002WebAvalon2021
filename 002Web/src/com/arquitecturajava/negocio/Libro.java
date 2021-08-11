package com.arquitecturajava.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	@JsonIgnore
	private List<Capitulo> capitulos = new ArrayList<Capitulo>();
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	//Fortalece la relacion y la simplifica entre libro y capitulo
	public void addCapitulo(Capitulo c) {
		this.capitulos.add(c);
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Libro() {
		super();
	}
	public Libro(String isbn, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
	}
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(autor, isbn, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(titulo, other.titulo);
	}
	
}
