package repositorio;

import java.util.List;

import negocio.Capitulo;

public interface CapituloRepository {
	public List<Capitulo> buscarTodos();

	public void borrarCapitulo(Capitulo capitulo);
	
	void insertarCapitulo(Capitulo capitulo);
}
