package com.arquitecturajava.viejo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOperaciones
 */
@WebServlet("/ServletOperaciones")
public class ServletOperaciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numero1 = 0;
		int numero2 = 0;
		if(request.getParameter("numero1").chars().allMatch(Character::isDigit)&&request.getParameter("numero2").chars().allMatch(Character::isDigit)) {
			numero1=Integer.parseInt(request.getParameter("numero1"));
			numero2=Integer.parseInt(request.getParameter("numero2"));
		}
		
		PrintWriter pw= response.getWriter();
		pw.println("<html><body>");
		pw.println("<p>" + numero1 + " + " + numero2 + " = " + (numero1+numero2) + "</p>");
		pw.println("<p>" + numero1 + " - " + numero2 + " = " + (numero1-numero2) + "</p>");
		pw.println("<p>" + numero1 + " * " + numero2 + " = " + (numero1*numero2) + "</p>");
		pw.println("<p>" + numero1 + " / " + numero2 + " = " + (numero1/numero2) + "</p>");
		pw.println("</body></html>");
	}

}
