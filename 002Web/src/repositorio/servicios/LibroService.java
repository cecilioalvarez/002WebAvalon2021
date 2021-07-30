package repositorio.servicios;

import java.util.List;

import negocio.Capitulo;
import negocio.Libro;

public interface LibroService {

	void actualizar(Libro libro);

	void insertar(Libro libro);

	void borrar(Libro libro);

	List<Libro> buscarTodos();

	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);

	Libro buscarUno(String isbn);

	List<Capitulo> buscarTodosLosCapitulos();
	
	List<Capitulo> buscarTodosLosCapitulos(Libro libro);

	void borrarCapitulo(Capitulo capitulo);
	
	void insertarCapitulo(Capitulo capitulo);
}