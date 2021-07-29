package com.arquitecturajava.repositorios;

import java.util.List;

import com.arquitecturajava.negocio.Capitulo;

public interface CapituloRepository {

	void insertar(Capitulo capitulo);

	void actualizar(Capitulo capitulo);

	void borrar(Capitulo capitulo);

	List<Capitulo> buscarTodos();

	Capitulo buscarUno(String titulo);


}