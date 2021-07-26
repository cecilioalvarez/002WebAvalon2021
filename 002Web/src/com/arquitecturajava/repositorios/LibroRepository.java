package com.arquitecturajava.repositorios;

import java.util.List;

import com.arquitecturajava.negocio.Libro;

public interface LibroRepository {

	void addBook(Libro libro);

	void removeBook(Libro libro);

	List<Libro> buscarTodosLibros();
	
	List<Libro> buscarTodosLibrosConCapitulos();

	Libro buscarLibro(String isbn);

	List<Libro> buscarLibroAutor(String autor);

	List<Libro> buscarLibroTitulo(String titulo);

	List<Libro> buscarLibroAutorTitulo(String autor, String titulo);

	void modifyBook(Libro libro);

}