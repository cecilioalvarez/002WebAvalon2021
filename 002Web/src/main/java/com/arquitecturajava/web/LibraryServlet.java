package com.arquitecturajava.web;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.repositories.AuthorRepository;
import com.arquitecturajava.repositories.AuthorRepositoryJDBC;
import com.arquitecturajava.repositories.BookRepository;
import com.arquitecturajava.repositories.BookRepositoryJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibraryServlet", urlPatterns = {"/LibraryServlet"})
public class LibraryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Author author = new Author(request.getParameter("id"), request.getParameter("name"), Integer.parseInt(request.getParameter("age")));
        AuthorRepository ar = new AuthorRepositoryJDBC();
        ar.insert(author);
        
        author = new AuthorRepositoryJDBC().select(new Author(request.getParameter("author")));
        
        Book book = new Book(request.getParameter("isbn"), request.getParameter("title"), author);
        BookRepository br = new BookRepositoryJDBC();
        br.insert(book);
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.print("<html><body>");
        out.println(LibraryServlet.printBookData(book));
        out.println("<a href='libraryForm.html'>Insertar otros</a>");
        out.print("</body></html>");
        processRequest(request, response);
    }
    
    private static String printBookData(Book book) {
        return "<table><thead><tr><td>ISBN</td><td>TÍTULO</td><td>AUTOR</td></tr></thead>"
                + "<tbody><tr>"
                + "<td>" + book.getPk_isbn() + "</td><td>" + book.getTitle() + "</td><td>" + book.getFk_author().getName() + "</td>"
                + "</tr></tbody></table>";
    }
}
