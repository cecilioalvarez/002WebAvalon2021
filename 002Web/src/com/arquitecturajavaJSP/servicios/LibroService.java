package com.arquitecturajavaJSP.servicios;

import java.util.List;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;

public interface LibroService {

	void addBook(Libro libro);
	
	void addMultipleBooks(Libro ...libros);

	void removeBook(Libro libro);

	List<Libro> buscarTodosLibros();

	List<Libro> buscarTodosLibrosConCapitulos();

	Libro buscarLibro(String isbn);

	List<Libro> buscarLibroAutor(String autor);

	List<Libro> buscarLibroTitulo(String titulo);

	List<Libro> buscarLibroAutorTitulo(String autor, String titulo);

	int modifyBook(Libro libro);
	
	void addChapter(Capitulo chapter);

	void removeChapter(Capitulo chapter);

	List<Capitulo> getAllChapters();
	
	public List<Capitulo>getAllChaptersByBook(Libro libro);

	void modifyChapter(Capitulo chapter);

	Capitulo getOneChapter(Capitulo chapter);

	List<Capitulo> buscarTodosCapitulos(Libro libro);

}