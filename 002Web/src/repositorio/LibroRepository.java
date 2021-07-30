package repositorio;

import java.util.List;

import negocio.Capitulo;
import negocio.Libro;

public interface LibroRepository {

	void actualizar(Libro libro);

	void insertar(Libro libro);

	void borrar(Libro libro);

	List<Libro> buscarTodos();
	
	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);

	Libro buscarUno(String isbn);
	
	List<Capitulo> buscarTodosCapitulos(Libro libro);
	

}