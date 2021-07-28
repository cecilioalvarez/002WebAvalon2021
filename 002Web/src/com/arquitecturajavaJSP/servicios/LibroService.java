package com.arquitecturajavaJSP.servicios;

import java.util.List;

import com.arquitecturajavaJSP.negocio.Libro;

public interface LibroService {

	void addBook(Libro libro);

	void removeBook(Libro libro);

	List<Libro> buscarTodosLibros();

	List<Libro> buscarTodosLibrosConCapitulos();

	Libro buscarLibro(String isbn);

	List<Libro> buscarLibroAutor(String autor);

	List<Libro> buscarLibroTitulo(String titulo);

	List<Libro> buscarLibroAutorTitulo(String autor, String titulo);

	int modifyBook(Libro libro);

}