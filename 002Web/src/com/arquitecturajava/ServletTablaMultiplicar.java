package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTablaMultiplicar")
public class ServletTablaMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numero = Integer.parseInt(request.getParameter("numero"));
		PrintWriter writer = response.getWriter();
		writer.write("<html><body>");
		writer.write("<table>");
		for (int i = 1; i <= 10; i++) {
			writer.write("<tr><td>" + numero + " * "+ i + " = "+numero*i+"</tr></td>");
		}
		writer.write("</table></body></html>");

	}

}
