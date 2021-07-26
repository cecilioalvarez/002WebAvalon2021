package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet011_Libro
 */
@WebServlet("/Servlet011_Libro")
public class Servlet011_Libro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn= request.getParameter("isbn");
		String titulo= request.getParameter("titulo");
		String autor= request.getParameter("autor");
		
		Libro libro = new Libro(isbn,titulo,autor);
		
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println(libro.getIsbn());
		pw.println(libro.getTitulo());
		pw.println(libro.getAutor());
		pw.println("</body></html>");
	}

}
