package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.negocio.Libro;

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
		
		Libro libro = new Libro(isbn, titulo, autor);
		PrintWriter pw = response.getWriter();
		pw.print("<html><body>");
		pw.println("ISBN: "+isbn+"<br>");
		pw.println("Titulo: "+titulo+"<br>");
		pw.println("Autor: "+autor+"<br>");
		pw.print("</body></html>");
	}

}
