<%-- 
    Document: booksList
    Created on: 26-jul-2021, 13:20:06
    Author: Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Formulario: Lista de libros"/>
        <jsp:param name="description" value="Formulario de visualización de Libros de la BD."/>
    </jsp:include>
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
            <div>
                <a href='LibraryServiceController?action=addBook'>Añadir un libro</a>
                <a href='LibraryServiceController?action=add2Books'>Añadir dos libros</a>
            </div>
        </main>
    </body>
</html>