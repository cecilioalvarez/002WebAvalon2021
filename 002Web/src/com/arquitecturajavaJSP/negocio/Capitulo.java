package com.arquitecturajavaJSP.negocio;

public class Capitulo {

	private String titulo;
	private int paginas;
	private Libro libro;
	
	
	
	public Capitulo(String titulo, Libro libro) {
		super();
		this.titulo = titulo;
		this.libro = libro;
	}
	
	
	public Capitulo(String titulo, int paginas, Libro libro) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
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
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "El capitulo de titulo = " + titulo + ", tiene " + paginas + " paginas";
	}
	
	
}
