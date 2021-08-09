package com.arquitecturajavaJSP.servicios.standard;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;
import com.arquitecturajavaJSP.repositorios.CapituloRepository;
import com.arquitecturajavaJSP.repositorios.LibroRepository;
import com.arquitecturajavaJSP.servicios.LibroService;
@Service
public class LibroServiceStandard implements LibroService {

	private LibroRepository repositorio;
	private CapituloRepository repositorioCapitulo;

	public LibroServiceStandard(LibroRepository repositorio,CapituloRepository capRepo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo=capRepo;
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
	public List<Capitulo> buscarTodosCapitulos(Libro libro){
		return repositorio.buscarTodosCapitulos(libro);
	}

	@Override
	public int modifyBook(Libro libro) {
		return repositorio.modifyBook(libro);
	}
	@Override
	public void addChapter(Capitulo chapter) {
		repositorioCapitulo.addChapter(chapter);
	}
	@Override
	public void removeChapter(Capitulo chapter) {
		repositorioCapitulo.removeChapter(chapter);
	}
	@Override
	public List<Capitulo> getAllChapters() {
		return repositorioCapitulo.getAllChapters();
	}
	@Override
	public Capitulo getOneChapter(Capitulo chapter) {
		return repositorioCapitulo.getOneChapter(chapter);
	}
	public List<Capitulo>getAllChaptersByBook(Libro libro){
		return repositorioCapitulo.getAllChaptersByBook(libro);
	};
	@Override
	public void modifyChapter(Capitulo chapter) {
		repositorioCapitulo.modifyChapter(chapter);
	}
}
