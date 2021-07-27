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

	@Override
	public void insertar(Libro libro) {
		repositorio.insertar(libro);
	}

	@Override
	public void actualizar(Libro libro) {
		repositorio.actualizar(libro);
	}

	@Override
	public void borrar(Libro libro) {
		repositorio.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodos() {
		return repositorio.buscarTodos();
	}

	@Override
	public Libro buscarUno(String isbn) {
		return repositorio.buscarUno(isbn);
	}

	@Override
	public Libro buscarUnoPorTitulo(String titulo) {
		return repositorio.buscarUnoPorTitulo(titulo);
	}

	@Override
	public Libro buscarUnoPorAutor(String autor) {
		return repositorio.buscarUnoPorAutor(autor);
	}

	@Override
	public List<Libro> buscarTodosTituloAutor(String titulo, String autor) {
		return repositorio.buscarTodosTituloAutor(titulo, autor);
	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {
		return repositorio.buscarTodosConCapitulos();
	}
	
}
