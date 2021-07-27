package com.arquitecturajava.servicios.standard;

import java.util.List;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.servicios.LibroService;

public class LibroServiceStandard implements LibroService {
	
	private LibroRepository repositorio;

	public LibroServiceStandard(LibroRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	public void insertar(Libro libro) {
		repositorio.insertar(libro);
	}

	public void borrar(Libro libro) {
		repositorio.borrar(libro);
	}

	public void actualizar(Libro libro) {
		repositorio.actualizar(libro);
	}

	public List<Libro> buscarTodos() {
		return repositorio.buscarTodos();
	}

	public Libro buscarUno(String isbn) {
		return repositorio.buscarUno(isbn);
	}

	public List<Libro> BuscarTodosConCapitulos() {
		return repositorio.BuscarTodosConCapitulos();
	}

	public Libro buscarPorTitulo(String titulo) {
		return repositorio.buscarPorTitulo(titulo);
	}

	public Libro buscarPorAutor(String autor) {
		return repositorio.buscarPorAutor(autor);
	}

	public List<Libro> buscarPorIituloAutor(String titulo, String autor) {
		return repositorio.buscarPorIituloAutor(titulo, autor);
	}
	
	
	

}
