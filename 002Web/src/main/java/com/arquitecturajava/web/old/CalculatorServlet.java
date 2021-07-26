package com.arquitecturajava.web.old;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/CalculatorServlet"})
public class CalculatorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CalculatorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private static double sum(double number1, double number2) {
        return number1 + number2;
    }
    
    private static double substract(double number1, double number2) {
        return number1 - number2;
    }
    
    private static double product(double number1, double number2) {
        return number1 * number2;
    }
    
    private static double divide(double number1, double number2) {
        return number1 / number2;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double number1 = Double.parseDouble(request.getParameter("firstNumber"));
        double number2 = Double.parseDouble(request.getParameter("secondNumber"));
        
        PrintWriter pw = response.getWriter();
        pw.println("<html><body><h3>Resultado de las operaciones con " + number1 + " y " + number2 + "</h3>"
                + "<p>Suma: " + CalculatorServlet.sum(number1, number2) + "</p>"
                + "<p>Resta: " + CalculatorServlet.substract(number1, number2) + "</p>"
                + "<p>Multiplicación: " + CalculatorServlet.product(number1, number2) + "</p>"
                + "<p>División: " + CalculatorServlet.divide(number1, number2) + "</p></body></html>");
        processRequest(request, response);
    }
}
