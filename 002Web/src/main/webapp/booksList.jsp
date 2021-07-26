<%-- 
    Document   : booksList
    Created on : 26-jul-2021, 13:20:06
    Author     : Germán Zunzunegui
--%>

<%@page import="java.util.List"%>
<%@page import="com.arquitecturajava.repositories.BookRepositoryJDBC"%>
<%@page import="com.arquitecturajava.repositories.BookRepository"%>
<%@page import="com.arquitecturajava.web.ShowLibraryServlet"%>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Book> books = new BookRepositoryJDBC().select(); 
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Germán Zunzunegui Rodríguez">
        <meta name="description" content="Formulario de visualización de Libros en la BD.">
        <link href="style/styles.css" rel="stylesheet" type="text/css">
        <title>Formulario: Lista de libros</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>TÍTULO</th>
                    <th>AUTOR</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <% for (Book book : books) { %>
                        <tr>
                            <td><%= book.getPk_isbn().toUpperCase() %></td>
                            <td><%= book.getTitle() %></td>
                            <td><%= book.getFk_author().getName() %></td>
                            <td><a href='DeleteBookServlet?isbn=<%=book.getPk_isbn() %>'>Borrar</a></td>
                        </tr>
                <%} %>
            </tbody>
        </table>
    </body>
</html>