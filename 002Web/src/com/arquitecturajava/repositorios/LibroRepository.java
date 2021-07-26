package com.arquitecturajava.repositorios;

import java.util.List;

import com.arquitecturajava.negocio.Libro;

public interface LibroRepository {

	void actualizar(Libro libro);

	void insertar(Libro libro);

	void borrar(Libro libro);

	List<Libro> buscarTodos();
	
	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);

	Libro buscarUno(String isbn);

}