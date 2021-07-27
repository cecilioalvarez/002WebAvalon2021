package com.arquitecturajava.servicios.standard;

import java.util.List;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.servicios.LibroService;

public class LibroServiceStandard implements LibroService  {

	private LibroRepository repositorio;

	public LibroServiceStandard(LibroRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	public void actualizar(Libro libro) {
		repositorio.actualizar(libro);
	}

	public void insertar(Libro libro) {
		repositorio.insertar(libro);
	}

	public void borrar(Libro libro) {
		repositorio.borrar(libro);
	}

	public List<Libro> buscarTodos() {
		return repositorio.buscarTodos();
	}

	public List<Libro> buscarTodosConCapitulos() {
		return repositorio.buscarTodosConCapitulos();
	}

	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		return repositorio.buscarTituloyAutor(titulo, autor);
	}

	public Libro buscarUno(String isbn) {
		return repositorio.buscarUno(isbn);
	}
	
	
}
