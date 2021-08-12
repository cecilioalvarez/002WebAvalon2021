package com.arquitecturajava.ajax;

import com.arquitecturajava.business.Book;
import com.arquitecturajava.repositories.BookRepositoryJDBC;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AjaxTestServlet", urlPatterns = {"/AjaxTestServlet"})
public class AjaxTestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            final List<Book> BOOKS = new BookRepositoryJDBC().selectBooks();
            ObjectMapper mapper = new ObjectMapper();
            out.println(mapper.writeValueAsString(BOOKS));
        } catch (IOException io_ex) {
            System.err.println("Se ha producido un error al acceder al canal de respuesta del servidor: " + io_ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    private String getHeader(String title, String description) {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"es\">\n" 
                + "<head>\n" 
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" 
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" 
                + "<meta name=\"author\" content=\"Germán Zunzunegui Rodríguez\"/>\n" 
                + "<meta name=\"description\" content=\"" + description + "\"/>\n" 
                + "<script src=\"js/libs/jQuery.js\" type=\"text/javascript\"></script>\n" 
                + "<script src=\"js/customTable.js\" type=\"text/javascript\"></script>\n" 
                + "<link href=\"style/styles.css\" rel=\"stylesheet\" type=\"text/css\"/>\n" 
                + "<title>" + title + "</title>\n" 
                + "</head>";
    }
}
