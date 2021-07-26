package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;
import com.arquitecturajava.repositorios.LibroRepository;
import com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC;




@WebServlet("/ServletLibro")
public class ServletLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		String titulo=request.getParameter("titulo");
		String autor=request.getParameter("autor");
		Libro libro=new Libro(isbn,titulo,autor);
		LibroRepository repositorio=new LibroRepositoryJDBC();
		repositorio.insertar(libro);
		
		response.sendRedirect("ServletLibrosLista");
		
		
//		PrintWriter pw=response.getWriter();
//		pw.println("<html><body>");
////		pw.println(libro.getTitulo());
////		pw.println(libro.getAutor());
////		pw.println(libro.getIsbn());
//		pw.println("insertado");
//		pw.println("</body></html>");
	}

}
