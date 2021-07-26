package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.Libro_RepositoryJDBC;

@WebServlet("/ServletLibrosLista")
public class ServletLibrosLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LibroRepository repositorio = new Libro_RepositoryJDBC();
		List<Libro> listaLibros = repositorio.buscarTodosLibros();
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><table style='border-collapse: collapse;width: 100%;text-align: center;' border='2px solid black;'>");
		pw.print("<tr>");
		pw.print("<th>ISBN</th>");
		pw.print("<th>Titulo</th>");
		pw.print("<th>Autor</th>");
		pw.print("<th>Borrar</th>");
		pw.print("</tr>");
		for (Libro libro : listaLibros) {
			
			pw.print("<tr>");
			pw.print("<td>"+libro.getIsbn()+"</td>");
			pw.print("<td>"+libro.getTitulo()+"</td>");
			pw.print("<td>"+libro.getAutor()+"</td>");
			pw.print("<td>"
						+"<a href='ServletLibrosRemove?isbn="
						+libro.getIsbn()
						+"'>Borrar Libro</a>"
						+"</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.print("<a href='formularioLibro.html'>Insertar Libro</a>");
		pw.print("</body></html>");
	}

}
