package com.arquitecturajava.repositorios;

import java.util.List;

import com.arquitecturajava.negocio.Capitulo;

public interface CapituloRepository {
	public List<Capitulo> buscarTodos();
	public void borrar(Capitulo capitulo);
	public void insertar(Capitulo capitulo);
	

}
