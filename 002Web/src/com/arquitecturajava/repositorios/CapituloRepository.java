package com.arquitecturajava.repositorios;

import java.util.List;

import com.arquitecturajava.negocio.Capitulo;

public interface CapituloRepository {

	public void insertar(Capitulo capitulo);

	void actualizar(Capitulo capitulo);

	public void borrar(Capitulo capitulo);

	public List<Capitulo> buscarTodos();

	Capitulo buscarUno(String titulo);


}