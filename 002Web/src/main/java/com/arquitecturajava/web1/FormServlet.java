package com.arquitecturajava.web1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlet", urlPatterns = {"/FormServlet"})
public class FormServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoopServer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoopServer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>");
        String language = request.getParameter("language");
        pw.println("<h3>El lenguaje de programación seleccionado es «" + language + "»</h3>");
        int number = Integer.parseInt(request.getParameter("numberField"));
        pw.println("<h3>A continuación se muestra la tabla de multiplicar del número «" + number + "»</h3>");
        pw.println("<table style='border: solid thin grey'><tbody>");
        for (int i = 1; i <= 10; i++) {
            pw.println("<tr><td>" + String.valueOf(i) + " * " +  String.valueOf(number) + " =</td><td>" + (i * number) + "</td></tr>");
        }
        pw.println("</tbody></table></body></html>");
        processRequest(request, response);
    }
}
