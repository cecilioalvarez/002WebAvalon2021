package com.arquitecturajava.servicios;

import java.util.List;
import com.arquitecturajava.negocio.Capitulo;
import com.arquitecturajava.negocio.Libro;
public interface LibroService {
	void actualizar(Libro libro);
	void insertar(Libro libro);
	void borrar(Libro libro);
	List<Libro> buscarTodos();
	List<Libro> buscarTodosConCapitulos();
	List<Libro> buscarTituloyAutor(String titulo, String autor);
	Libro buscarUno(String isbn);

	List<Capitulo> buscarTodosLosCapitulos() ;
	List<Capitulo> buscarTodosCapitulos(Libro libro) ;
	void borrarCapitulo(Capitulo capitulo);
	void insertarCapitulo(Capitulo capitulo);

} 