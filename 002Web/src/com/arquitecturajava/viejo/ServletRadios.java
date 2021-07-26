package com.arquitecturajava.viejo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletRadios
 */
@WebServlet("/ServletRadios")
public class ServletRadios extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter writer=response.getWriter();
		
		writer.println("<html><body>"+ 
		request.getParameter("lenguaje")+
		"</body></html>");
		
	}

	

}
