package com.arquitecturajava.repositorios;

import java.util.List;

import com.arquitecturajava.negocio.Libro;


public interface LibroRepository {

	void insertar(Libro libro);

	void actualizar(Libro libro);

	void borrar(Libro libro);

	List<Libro> buscarTodos();

	Libro buscarUno(String isbn);

	Libro buscarUnoPorTitulo(String titulo);

	Libro buscarUnoPorAutor(String autor);

	List<Libro> buscarTodosTituloAutor(String titulo, String autor);
	
	List<Libro> buscarTodosConCapitulos();

}