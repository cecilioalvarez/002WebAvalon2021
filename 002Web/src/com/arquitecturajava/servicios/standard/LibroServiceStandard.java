package com.arquitecturajava.servicios.standard;

import java.util.List;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.servicios.LibroService;

public class LibroServiceStandard implements LibroService  {

	private LibroRepository repositorio;
	private CapituloRepository repositorioCapitulo;

	
	public LibroServiceStandard(LibroRepository repositorio,CapituloRepository repositorioCapitulo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo = repositorioCapitulo;
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

	@Override
	public List<Capitulo> buscarTodosLosCapitulos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
