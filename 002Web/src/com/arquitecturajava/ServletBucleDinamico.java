package com.arquitecturajava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletBucleDinamico")
public class ServletBucleDinamico extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		int tope = Integer.parseInt(request.getParameter("numero"));
		if(request.getParameter("numero").chars().allMatch(Character::isDigit)) {
			tope=Integer.parseInt(getServletInfo(request.getParameter("numero")));
		}
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
		for(int i=1; i<=tope ;i++) {
			writer.println("<p>" + i + "</p>");
		}
		writer.println("</body></html>");
	}
}
