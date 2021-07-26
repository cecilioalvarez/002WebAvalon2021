package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;


@WebServlet("/ServletLibrosLista")
public class ServletLibrosLista extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroRepository repositorio =new LibroRepositoryJDBC();
		List<Libro> listaLibros=repositorio.buscarTodos();
		PrintWriter writer=response.getWriter();
		writer.println("<html><body>");
		writer.println("<table border='1'>");
		for(Libro libro:listaLibros) {
			writer.println("<tr><td>"+libro.getIsbn()+"</td><td>"+libro.getTitulo()+"</td><td>"+libro.getAutor()+"</td><td><a href='ServletLibroBorrar?isbn="+libro.getIsbn()+"'>Borrar</a></td></tr>");
		}
		writer.println("</table>");
		writer.println("<a href='formularioLibro.html'>Insertar</a>");
		
		writer.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
