package com.arquitecturajavaJSP.repositorios;

import java.util.List;

import com.arquitecturajavaJSP.negocio.Capitulo;
import com.arquitecturajavaJSP.negocio.Libro;


public interface CapituloRepository {

	void addChapter(Capitulo chapter);

	void removeChapter(Capitulo chapter);

	List<Capitulo> getAllChapters();
	
	Capitulo getOneChapter(Capitulo chapter);
	
	public List<Capitulo>getAllChaptersByBook(Libro libro);

	void modifyChapter(Capitulo chapter);

}