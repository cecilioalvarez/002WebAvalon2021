<%-- 
    Document   : addBook
    Created on : 06-ago-2021, 11:00:18
    Author     : Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="function" %>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page import="com.arquitecturajava.business.Author"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Formulario: Creación de libro"/>
        <jsp:param name="description" value="Formulario de creación de libros."/>
    </jsp:include>
    <body>
        <header>
            <h1>Formulario de creación de un nuevo libro</h1>
        </header>
        <main>
            <form id="createBook" name="createBook" method="POST" action="createBook">
                <fieldset>
                    <legend>Datos del nuevo libro</legend>
                    <div>
                        <label for="isbn">ISBN:</label>
                        <input type="text" id="isbn" name="isbn" minlength="13" maxlength="13"/>
                    </div>
                    <div>
                        <label for="title">Título</label>
                        <input type="text" id="title" name="title" maxlength="64"/>
                    </div>
                    <div>
                        <label for="author">Autor:</label>
                        <select id="author" name="fk_author">
                            <core:forEach var="author" items="${authors}">
                            <option name="fk_author" value="${author.pk_id}">${author.name}</option>
                            </core:forEach>>
                        </select>
                    </div>
                </fieldset>
                <input type="submit" id="send" name="send" value="Añadir"/>
            </form>
            <div class="links">
                <a href="LibraryServiceController">Volver a la lista</a>  
            </div>
        </main>
    </body>
</html>