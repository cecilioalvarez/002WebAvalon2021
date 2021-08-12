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
<html lang="es">
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Formulario: Creación de 2 libros"/>
        <jsp:param name="description" value="Formulario de creación de libros."/>
    </jsp:include>
    <body>
        <header>
            <h1>Formulario de creación de dos nuevos libro</h1>
        </header>
        <main>
            <form id="createBook" name="createBook" method="POST" action="LibraryServiceController">
                <fieldset>
                    <legend>Datos del primer libro</legend>
                    <div>
                        <label for="isbn1">ISBN:</label>
                        <input type="text" id="isbn1" name="isbn1" minlength="13" maxlength="13"/>
                    </div>
                    <div>
                        <label for="title1">Título</label>
                        <input type="text" id="title1" name="title1" maxlength="64"/>
                    </div>
                    <div>
                        <label for="author1">Autor:</label>
                        <select id="author1" name="fk_author1">
                            <core:forEach var="author" items="${authors}">
                            <option name="fk_author1" value="${author.pk_id}">${author.name}</option>
                            </core:forEach>>
                        </select>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Datos del segundo libro</legend>
                    <div>
                        <label for="isbn2">ISBN:</label>
                        <input type="text" id="isbn2" name="isbn2" minlength="13" maxlength="13"/>
                    </div>
                    <div>
                        <label for="title2">Título</label>
                        <input type="text" id="title2" name="title2" maxlength="64"/>
                    </div>
                    <div>
                        <label for="author2">Autor:</label>
                        <select id="author2" name="fk_author2">
                            <core:forEach var="author" items="${authors}">
                            <option name="fk_author2" value="${author.pk_id}">${author.name}</option>
                            </core:forEach>>
                        </select>
                    </div>
                </fieldset>
                <input type="hidden" id="action" name="action" value="create2Books"/>
                <input type="submit" id="send" name="send" value="Añadir"/>
            </form>
            <div class="links">
                <a href="LibraryServiceController">Volver a la lista</a>  
            </div>
        </main>
    </body>
</html>