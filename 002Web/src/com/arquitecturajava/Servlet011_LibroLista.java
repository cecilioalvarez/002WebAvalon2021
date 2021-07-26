package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;

import com.arquitecturajava.negocio.Libro;

/**
 * Servlet implementation class Servlet011_LibroLista
 */
@WebServlet("/Servlet011_LibroLista")
public class Servlet011_LibroLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 LibroRepository repositorio=new LibroRepositoryJDBC();
		 List<Libro> listaLibros= repositorio.buscarTodos();
		 PrintWriter writer =response.getWriter();
		 writer.println("<html><body>");
		 for (Libro libro: listaLibros) {
			 writer.println("<p>"+libro.getIsbn()+","+libro.getTitulo()+","+libro.getAutor()+"<p>");
		 }
		 writer.println("<body><html>");
	}

	

}
