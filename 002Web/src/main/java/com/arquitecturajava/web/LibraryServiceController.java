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
        
        if (request.getParameter("action") != null) {
            switch (request.getParameter("action")) {
                case "deleteBook":
                    this.deleteBook(request, response);
                    break;
                case "editBook":
                    this.goToBookEditingView(request, response);
                    break;
                case "updateBook":
                    this.updateBook(request, response);
                    break;
                case "showAuthorDetail":
                    this.goToAuthorDetailView(request, response);
                    break;
                default:
                    response.sendRedirect("LibraryServiceController");
            }
        } else {
            request.setAttribute("bookList", this.libraryService.selectWithChapters());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookList.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.libraryService.delete(new Book(request.getParameter("isbn")));
        response.sendRedirect("LibraryServiceController");
    }
    
    private void goToBookEditingView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book bookToEdit = new Book(request.getParameter("isbn"));
        request.setAttribute("book", this.libraryService.selectWithChapters(bookToEdit));
        request.setAttribute("authors", new AuthorRepositoryJDBC().select());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editBook.jsp");
        requestDispatcher.forward(request, response);
    }
    
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book bookToUpdate = new Book(request.getParameter("isbn"), request.getParameter("title"), new Author(request.getParameter("author")));
        this.libraryService.update(bookToUpdate);
        response.sendRedirect("LibraryServiceController");
    }
    
    private void goToAuthorDetailView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Author author = new AuthorRepositoryJDBC().select(new Author(request.getParameter("id")));
        request.setAttribute("author", author);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("authorDetail.jsp");
        requestDispatcher.forward(request, response);
    }
}
