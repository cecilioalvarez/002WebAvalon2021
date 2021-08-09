package com.arquitecturajavaJSP.negocio;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Libro{

	private String isbn;
	private String autor;
	private String titulo;
	
	private List<Capitulo> listacoCapitulos= new ArrayList<Capitulo>();
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	public Libro() {
		super();
	}

	public Libro(String isbn, String autor, String titulo) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.titulo = titulo;
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public List<Capitulo> getListacoCapitulos() {
		return listacoCapitulos;
	}

	public void setListacoCapitulos(List<Capitulo> listacoCapitulos) {
		this.listacoCapitulos = listacoCapitulos;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
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
		return Objects.equals(isbn, other.isbn);
	}

	public void addCapitulo(Capitulo capitulo) {
		this.getListacoCapitulos().add(capitulo);
	}
	@Override
	public String toString() {
		return "El libro con ISBN " + this.isbn + " es " + this.titulo + ", de " + this.autor + ".";
	}
	
}
