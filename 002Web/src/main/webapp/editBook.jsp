<%-- 
    Document   : editBook
    Created on : 27-jul-2021, 9:14:15
    Author     : Germán Zunzunegui
--%>

<%@page import="com.arquitecturajava.repositories.services.LibraryServiceImplementation"%>
<%@page import="com.arquitecturajava.repositories.services.LibraryService"%>
<%@page import="java.util.List"%>
<%@page import="com.arquitecturajava.business.Author"%>
<%@page import="com.arquitecturajava.repositories.AuthorRepositoryJDBC"%>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page import="com.arquitecturajava.repositories.BookRepositoryJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Book book = (Book) request.getAttribute("book");
    List<Author> authors = (List) request.getAttribute("authors");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="author" content="Germán Zunzunegui Rodríguez"/>
        <meta name="description" content="Formulario de visualización de Libros en la BD."/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <title>Formulario: Edición de libro</title>
    </head>
    <body>
        <form id="editBook" name="editBook" method="GET" action="LibraryServiceController">
            <fieldset>
                <legend>Datos del libro</legend>
                <div>
                    <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" value="<%=book.getPk_isbn().toUpperCase() %>" readonly/>
                </div>
                <div>
                    <label for="title">Título:</label>
                    <input type="text" id="title" name="title" value="<%=book.getTitle()%>"/>
                </div>
                <div>
                    <label for="author">Autor:</label>
                    <select id="author" name="author">
                        <% for (Author author : authors) {%>
                        <option name="author" value="<%=author.getPk_id()%>" 
                                <% if (author.equals(book.getFk_author())) {%>
                                selected="true"
                            <% } %>
                        ><%=author.getName()%></option>
                        <% }%>
                    </select>
                </div>
            </fieldset>
            <input type="hidden" id="action" name="action" value="updateBook">
            <input type="submit" id="send" name="send" value="Actualizar"/>
        </form>
        <div>
            <a href="LibraryServiceController">Volver al listado</a>  
        </div>
    </body>
</html>
