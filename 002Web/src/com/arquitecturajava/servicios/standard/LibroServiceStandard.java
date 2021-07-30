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

	public LibroServiceStandard(LibroRepository repositorio, CapituloRepository repositorioCapitulo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo = repositorioCapitulo;
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

	@Override
	public List<Capitulo> buscarTodosLosCapitulos() {
		// TODO Auto-generated method stub
		return repositorioCapitulo.buscarTodos();
	}

	@Override
	public void borrarCapitulo(Capitulo capitulo) {
		repositorioCapitulo.borrar(capitulo);
		
	}

	@Override
	public void insertarCapitulo(Capitulo capitulo) {
		repositorioCapitulo.insertar(capitulo);
		
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		// TODO Auto-generated method stub
		return repositorio.buscarTodosCapitulos(libro);
	}
	
}
