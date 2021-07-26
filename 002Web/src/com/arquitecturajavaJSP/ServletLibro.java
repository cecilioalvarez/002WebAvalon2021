package com.arquitecturajavaJSP;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.Libro_RepositoryJDBC;

/**
 * Servlet implementation class Libro
 */
@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		
		Libro libro = new Libro(isbn, autor, titulo);
		LibroRepository repositorio = new Libro_RepositoryJDBC();
		repositorio.addBook(libro);
		
		response.sendRedirect("ServletLibrosLista");
	}

}
