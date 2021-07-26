package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTablaMultiplicar
 */
@WebServlet("/ServletTablaMultiplicar")
public class ServletTablaMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int number = 0;
		if(request.getParameter("numero").chars().allMatch(Character::isDigit)) {
			number=Integer.parseInt(request.getParameter("numero"));
		}
		PrintWriter writer = response.getWriter();
		writer.println("<html><body><table>");
		for(int i=0; i<=10;i++) {
			writer.print("<tr><td>" + i + " * " + number + " = " + (i*number) + "</td></tr>");

		}
		writer.println("</table></body></html>");
	}

}
