package com.arquitecturajava.primerosServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMultiplicar
 */
@WebServlet("/ServletMultiplicar")
public class ServletMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//int num1= Integer.parseInt(request.getParameter("numero1"));
		double num1= Double.parseDouble(request.getParameter("numero1"));
		PrintWriter writer=response.getWriter();
		writer.write("<html><body>");
		writer.write("<table style=\"border-collapse: collapse;width: 50%;text-align: center;\" border=\"2px solid black;\">");
		for (int i = 0; i < 11; i++) {
			writer.write("<tr>");
			writer.write("<td>"+num1+"</td>");
			writer.write("<td>X</td>");
			writer.write("<td>"+i+"</td>");
			writer.write("<td>=</td>");
			writer.write("<td>"+num1*i+"</td>");
			writer.write("</tr>");
			//Otra forma de hacerlo en una sola linea
			//writer.println("<tr><td>" + i + " * " + number + " = " + i * number + "</tr></td>");

		}
		writer.write("</table>");
		writer.write("</body></html>");
	}

}
