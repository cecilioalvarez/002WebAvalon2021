package com.arquitecturajava.web;

import com.arquitecturajava.business.Book;
import com.arquitecturajava.repositories.BookRepositoryJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowLibraryServlet", urlPatterns = {"/ShowLibraryServlet"})
public class ShowLibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> BOOKS = new BookRepositoryJDBC().select();
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.print("<html>");
        out.println(ShowLibraryServlet.printBooksTable(BOOKS));
        out.print("</body></html>");
        processRequest(request, response);
    }
    
    private static String printBooksTable(List<Book> books) {
        String table =  "<table><thead><tr><td>ISBN</td><td>TÍTULO</td><td>AUTOR</td></tr></thead>"
                + "<tbody>";
        for (Book book : books) {
            table += "<tr>"
                    + "<td>" + book.getPk_isbn() + "</td>"
                    + "<td>" + book.getTitle() + "</td>"
                    + "<td>" + book.getFk_author().getName() + "</td>"
                    + "<td><a href='DeleteBookServlet?isbn=" + book.getPk_isbn() + "'>Borrar</a></td>"
                    + "</tr>";
        }
        return table + "</tbody></table>";
    }
}
