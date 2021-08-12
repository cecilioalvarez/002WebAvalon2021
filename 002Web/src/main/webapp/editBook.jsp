<%-- 
    Document: editBook
    Created on: 27-jul-2021, 9:14:15
    Author: Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page import="com.arquitecturajava.business.Author"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Formulario: Edición de libro"/>
        <jsp:param name="description" value="Formulario de edición de un Libro de la BD."/>
    </jsp:include>
    <body>
        <header>
            <h1>Formulario de edición de un libro</h1>
        </header>
        <main>
            <form id="editBook" name="editBook" method="POST" action="LibraryServiceController">
                <fieldset>
                    <legend>Datos del libro</legend>
                    <div>
                        <label for="isbn">ISBN:</label>
                        <input type="text" id="isbn" name="isbn" value="${function:toUpperCase(book.pk_isbn)}" readonly/>
                    </div>
                    <div>
                        <label for="title">Título:</label>
                        <input type="text" id="title" name="title" value="${book.title}"/>
                    </div>
                    <div>
                        <label for="author">Autor:</label>
                        <select id="author" name="fk_author">
                            <core:forEach var="author" items="${authors}">
                            <option name="fk_author" value="${author.pk_id}" 
                                    <core:if test="${author == book.fk_author}">
                                    selected="true"
                                    </core:if>
                            >${author.name}</option>
                            </core:forEach>
                        </select>
                    </div>
                </fieldset>
                <input type="hidden" id="action" name="action" value="updateBook">
                <input type="submit" id="send" name="send" value="Actualizar"/>
            </form>
            <div class="links">
                <a href="LibraryServiceController">Volver al listado</a>  
            </div>
        </main>
    </body>
</html>
