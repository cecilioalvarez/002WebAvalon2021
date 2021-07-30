<%-- 
    Document   : editBook
    Created on : 27-jul-2021, 9:14:15
    Author     : Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.arquitecturajava.repositories.services.LibraryServiceImplementation"%>
<%@page import="com.arquitecturajava.repositories.services.LibraryService"%>
<%@page import="java.util.List"%>
<%@page import="com.arquitecturajava.business.Author"%>
<%@page import="com.arquitecturajava.repositories.AuthorRepositoryJDBC"%>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page import="com.arquitecturajava.repositories.BookRepositoryJDBC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <form id="editBook" name="editBook" method="POST" action="LibraryServiceController">
            <fieldset>
                <legend>Datos del libro</legend>
                <div>
                    <label for="isbn">ISBN:</label>
                    <input type="text" id="isbn" name="isbn" value="${fn:toUpperCase(book.pk_isbn)}" readonly/>
                </div>
                <div>
                    <label for="title">Título:</label>
                    <input type="text" id="title" name="title" value="${book.title}"/>
                </div>
                <div>
                    <label for="author">Autor:</label>
                    <select id="author" name="author">
                        <c:forEach var="author" items="${authors}">
                        <option name="author" value="${author.pk_id}" 
                                <c:if test="${author == book.fk_author}">
                                selected="true"
                                </c:if>
                        >${author.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </fieldset>
            <input type="hidden" id="action" name="action" value="updateBook">
            <input type="submit" id="send" name="send" value="Actualizar"/>
        </form>
        <div class="links">
            <a href="LibraryServiceController">Volver al listado</a>  
        </div>
    </body>
</html>
