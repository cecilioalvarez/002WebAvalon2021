package com.arquitecturajava.servicios.standard;

import java.util.List;

import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.CapituloRepository;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.servicios.LibroService;

public class LibroServiceStandard implements LibroService {
	
	private LibroRepository repositorio;
	private CapituloRepository repositorioCapitulo;

	public LibroServiceStandard(LibroRepository repositorio,CapituloRepository repositorioCapitulo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo=repositorioCapitulo;
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

	@Override
	public List<Capitulo> buscarTodosLosCapitulos() {
		// TODO Auto-generated method stub
		return repositorioCapitulo.buscarTodos();
	}
}
