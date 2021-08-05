package com.arquitecturajava.web;

import com.arquitecturajava.business.Author;
import com.arquitecturajava.business.Book;
import com.arquitecturajava.business.Chapter;
import com.arquitecturajava.repositories.AuthorRepositoryJDBC;
import com.arquitecturajava.repositories.services.LibraryService;
import com.arquitecturajava.repositories.services.LibraryServiceImplementation;
import com.arquitecturajava.spring.SpringConfig;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebServlet(name = "LibraryServiceController", urlPatterns = {"/LibraryServiceController"})
public class LibraryServiceController extends HttpServlet {
    
    private final LibraryService LIBRARY_SERVICE = new AnnotationConfigApplicationContext(SpringConfig.class)
            .getBean(LibraryServiceImplementation.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                case "showBookChapters":
                    this.goToChaptersDetailView(request, response);
                    break;
                case "deleteChapter":
                    this.deleteChapter(request, response);
                    break;
                case "addBookChapter":
                    this.goToAddChapterView(request, response);
                    break;
                case "createChapter":
                    this.insertChapter(request, response);
                    break;
                default:
                    response.sendRedirect("LibraryServiceController");
            }
        } else {
            request.setAttribute("bookList", this.LIBRARY_SERVICE.selectWithChapters());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("bookList.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
    
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book bookToDelete = new Book(request.getParameter("isbn"));
        this.LIBRARY_SERVICE.deleteBook(bookToDelete);
        response.sendRedirect("LibraryServiceController");
    }
    
    private void goToBookEditingView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book bookToEdit = new Book(request.getParameter("isbn"));
        request.setAttribute("book", this.LIBRARY_SERVICE.selectWithChapters(bookToEdit));
        request.setAttribute("authors", new AuthorRepositoryJDBC().select());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editBook.jsp");
        requestDispatcher.forward(request, response);
    }
    
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Book bookToUpdate = new Book(request.getParameter("isbn"), request.getParameter("title"), new Author(request.getParameter("author")));
        this.LIBRARY_SERVICE.update(bookToUpdate);
        response.sendRedirect("LibraryServiceController");
    }
    
    private void goToAuthorDetailView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Author authorToShow = this.LIBRARY_SERVICE.select(new Author(request.getParameter("id")));
        request.setAttribute("author", authorToShow);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("authorDetail.jsp");
        requestDispatcher.forward(request, response);
    }

    private void goToChaptersDetailView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book bookToShow = new Book(request.getParameter("isbn"));
        request.setAttribute("book", this.LIBRARY_SERVICE.selectWithChapters(bookToShow));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("chaptersDetail.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteChapter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book bookShown = new Book(request.getParameter("isbn"));
        Chapter chapterToDelete = new Chapter(request.getParameter("title"), bookShown);
        this.LIBRARY_SERVICE.delete(chapterToDelete);
        this.goToChaptersDetailView(request, response);
    }

    private void goToAddChapterView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book bookToAddChapter = new Book(request.getParameter("isbn"));
        request.setAttribute("book", this.LIBRARY_SERVICE.selectWithChapters(bookToAddChapter));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("addChapter.jsp");
        requestDispatcher.forward(request, response);
    }

    private void insertChapter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book bookShown = new Book(request.getParameter("isbn"));
        Chapter chapterToCreate = new Chapter(request.getParameter("title"), Integer.parseInt(request.getParameter("pages")), bookShown);
        this.LIBRARY_SERVICE.insert(chapterToCreate);
        this.goToChaptersDetailView(request, response);
    }
}
