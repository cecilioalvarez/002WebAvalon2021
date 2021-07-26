package com.arquitecturajava.negocio;

public class Capitulo {
	private String titulo;
	private int paginas;
	private Libro libro;

	public Capitulo() {
		super();
	}

	public Capitulo(String titulo, Libro libro) {
		super();
		this.titulo = titulo;
		this.libro = libro;
	}

	public Capitulo(String nombre, int paginas) {

		this.titulo = nombre;
		this.paginas = paginas;

	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Capitulo [titulo=" + titulo + ", paginas=" + paginas + ", libro=" + libro + "]";
	}
	

}
