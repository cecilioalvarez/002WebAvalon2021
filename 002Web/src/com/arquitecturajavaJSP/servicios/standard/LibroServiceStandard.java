package com.arquitecturajavaJSP.servicios.standard;

import java.util.List;

import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.LibroRepository;
import com.arquitecturajavaJSP.servicios.LibroService;

public class LibroServiceStandard implements LibroService {

	private LibroRepository repositorio;

	public LibroServiceStandard(LibroRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public void addBook(Libro libro) {
		repositorio.addBook(libro);
	}

	@Override
	public void removeBook(Libro libro) {
		repositorio.removeBook(libro);
	}

	@Override
	public List<Libro> buscarTodosLibros() {
		return repositorio.buscarTodosLibros();
	}

	@Override
	public List<Libro> buscarTodosLibrosConCapitulos() {
		return repositorio.buscarTodosLibrosConCapitulos();
	}

	@Override
	public Libro buscarLibro(String isbn) {
		return repositorio.buscarLibro(isbn);
	}

	@Override
	public List<Libro> buscarLibroAutor(String autor) {
		return repositorio.buscarLibroAutor(autor);
	}

	@Override
	public List<Libro> buscarLibroTitulo(String titulo) {
		return repositorio.buscarLibroTitulo(titulo);
	}

	@Override
	public List<Libro> buscarLibroAutorTitulo(String autor, String titulo) {
		return repositorio.buscarLibroAutorTitulo(autor, titulo);
	}

	@Override
	public void modifyBook(Libro libro) {
		repositorio.modifyBook(libro);
	}
	
	
}
