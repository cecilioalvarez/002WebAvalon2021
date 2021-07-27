package com.arquitecturajava.web;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.repositories.AuthorRepositoryJDBC;
import com.arquitecturajava.repositories.BookRepositoryJDBC;
import com.arquitecturajava.repositories.services.LibraryService;
import com.arquitecturajava.repositories.services.LibraryServiceImplementation;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibraryServiceController", urlPatterns = {"/LibraryServiceController"})
public class LibraryServiceController extends HttpServlet {
    
    private LibraryService libraryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.libraryService = new LibraryServiceImplementation(new BookRepositoryJDBC());
        RequestDispatcher requestDispatcher = null;
        
        if (request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "delete":
                    this.libraryService.delete(new Book(request.getParameter("isbn")));
                    response.sendRedirect("LibraryServiceController");
                    break;
                case "editBook":
                    Book bookToEdit = new Book(request.getParameter("isbn"));
                    request.setAttribute("book", this.libraryService.selectWithChapters(bookToEdit));
                    request.setAttribute("authors", new AuthorRepositoryJDBC().select());
                    requestDispatcher = request.getRequestDispatcher("editBook.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                case "update":
                    Book bookToUpdate = new Book(request.getParameter("isbn"), request.getParameter("title"), new Author(request.getParameter("author")));
                    this.libraryService.update(bookToUpdate);
                    response.sendRedirect("LibraryServiceController");
                    break;
                case "authorDetail":
                    Author author = new AuthorRepositoryJDBC().select(new Author(request.getParameter("id")));
                    request.setAttribute("author", author);
                    requestDispatcher = request.getRequestDispatcher("authorDetail.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                default:
                    response.sendRedirect("LibraryServiceController");
            }
        } else {
            request.setAttribute("bookList", this.libraryService.selectWithChapters());
            requestDispatcher = request.getRequestDispatcher("bookList.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
