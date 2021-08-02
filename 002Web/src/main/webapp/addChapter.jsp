<%-- 
    Document   : addChapter
    Created on : 29-jul-2021, 12:44:17
    Author     : Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="author" content="Germán Zunzunegui Rodríguez"/>
        <meta name="description" content="Formulario de creación de capítulos."/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <title>Creación de capítulo</title>
    </head>
    <body>
        <form id="createChapter" name="createChapter" method="POST" action="LibraryServiceController">
            <fieldset>
                <legend>Datos del nuevo capítulo de «${book.title}»</legend>
                <div>
                    <label for="isbn">Título:</label>
                    <input type="text" id="title" name="title" maxlength="64"/>
                </div>
                <div>
                    <label for="pages">Número de páginas:</label>
                    <input type="number" id="pages" name="pages" min="1"/>
                </div>
            </fieldset>
            <input type="hidden" id="isbn" name="isbn" value="${book.pk_isbn}"/>
            <input type="hidden" id="action" name="action" value="createChapter"/>
            <input type="submit" id="send" name="send" value="Añadir"/>
        </form>
        <div class="links">
            <a href="LibraryServiceController?action=showBookChapters&isbn=${book.pk_isbn}">Volver a la lista</a>  
        </div>
    </body>
</html>