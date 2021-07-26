package com.arquitecturajava.negocio;

import java.util.List;

public class Capitulo {
	private String titulo;
	private int paginas;
	private Libro libro;
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public Capitulo(String titulo, int paginas, Libro libro) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
		this.libro = libro;
	}
	public Capitulo(String titulo) {
		super();
		this.titulo = titulo;
	}
	
}
