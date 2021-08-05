<%-- 
    Document: booksList
    Created on: 26-jul-2021, 13:20:06
    Author: Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@page import="com.arquitecturajava.repositories.services.LibraryServiceImplementation"%>
<%@page import="com.arquitecturajava.repositories.services.LibraryService"%>
<%@page import="java.util.List"%>
<%@page import="com.arquitecturajava.repositories.BookRepositoryJDBC"%>
<%@page import="com.arquitecturajava.repositories.BookRepository"%>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="author" content="Germán Zunzunegui Rodríguez"/>
        <meta name="description" content="Formulario de visualización de Libros en la BD."/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="img/avalon.ico"/>
        <title>Formulario: Lista de libros</title>
    </head>
    <body>
        <header>
            <h1>DATOS DE LOS LIBROS</h1>
        </header>
        <main>
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
                    <core:forEach var="book" items="${bookList}">
                        <tr>
                            <td>${function:toUpperCase(book.pk_isbn)}</td>
                            <td>${book.title}</td>
                            <td>
                                <a href='LibraryServiceController?action=showAuthorDetail&id=${book.fk_author.pk_id}'>
                                    ${book.fk_author.name}
                                </a>
                            </td>
                            <td>
                                <a href='LibraryServiceController?action=editBook&isbn=${book.pk_isbn}'>Editar</a>
                                <a href='LibraryServiceController?action=deleteBook&isbn=${book.pk_isbn}'>Borrar</a>
                                <a href='LibraryServiceController?action=showBookChapters&isbn=${book.pk_isbn}'>Ver capítulos</a>
                            </td>
                        </tr>
                    </core:forEach>
                </tbody>
            </table>
        </main>
    </body>
</html>