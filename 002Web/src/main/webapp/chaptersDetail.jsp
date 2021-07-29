<%-- 
    Document   : showBookDetail
    Created on : 29-jul-2021, 11:52:29
    Author     : Germán Zunzunegui
--%>

<%@page import="com.arquitecturajava.business.Book"%>
<%@page import="com.arquitecturajava.business.Chapter"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Book book = (Book) request.getAttribute("book"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="author" content="Germán Zunzunegui Rodríguez"/>
        <meta name="description" content="Formulario de visualización de los capítulos del libro."/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <title>Capítulos del libro</title>
    </head>
    <body>
        <h2>CAPÍTULOS DE «<%=book.getTitle().toUpperCase() %>»</h2>
        <table>
            <thead>
                <tr>
                    <th>TÍTULO</th>
                    <th>PÁGINAS</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <% for (Chapter chapter : book.getChapters()) { %>
                <tr>
                    <td class="greatCell"><%=chapter.getPk_title() %></td>
                    <td class="veryTinyCell"><%=chapter.getPages() %></td>
                    <td class="tinyCell">
                        <a href='LibraryServiceController?action=deleteChapter&isbn=<%=book.getPk_isbn() %>&title=<%=chapter.getPk_title() %>'>Borrar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <div class="links">
            <a href='LibraryServiceController?action=addBookChapter&isbn=<%=book.getPk_isbn() %>'>Añadir un capítulo</a>
            <a href='LibraryServiceController'>Volver a la lista</a>
        </div>
    </body>
</html>