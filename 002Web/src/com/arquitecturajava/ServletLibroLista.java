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
import com.arquitecturajava.servicios.LibroService;
import com.arquitecturajava.servicios.standard.LibroServiceStandard;

/**
 * Servlet implementation class ServletLibroLista
 */
@WebServlet("/ServletLibroLista")
public class ServletLibroLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//LibroRepository repositorio = new LibroRepositoryJDBC();
		LibroService servicio = new LibroServiceStandard(new LibroRepositoryJDBC());
		List<Libro> listaLibros = servicio.buscarTodos();
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		writer.println("<table border='1px solid black'>");
		for(Libro libro: listaLibros) {
			writer.println("<tr><td>"+libro.getIsbn()+"</td><td>"+libro.getTitulo()+"</td><td>"
		+libro.getAutor()+"</td>"+"<td><a href='ServletLibroBorrar?isbn=" + libro.getIsbn() +"'>borrar</a></td></tr>");
		}
		writer.println("</table>"); 
		writer.println("<a href='FormularioLibro.html'> insertar</a>");
		writer.println("</body></html>"); 
		
	}
		
}
