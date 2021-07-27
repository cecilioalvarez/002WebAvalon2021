package com.arquitecturajava.servicios;

import java.util.List;

import com.arquitecturajava.negocio.Libro;

public interface LibroService {

	void insertar(Libro libro);

	void borrar(Libro libro);

	void actualizar(Libro libro);

	List<Libro> buscarTodos();

	Libro buscarUno(String isbn);

	List<Libro> BuscarTodosConCapitulos();

	Libro buscarPorTitulo(String titulo);

	Libro buscarPorAutor(String autor);

	List<Libro> buscarPorIituloAutor(String titulo, String autor);

}