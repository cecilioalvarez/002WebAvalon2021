<%-- 
    Document: chaptersDetail
    Created on: 29-jul-2021, 11:52:29
    Author: Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.arquitecturajava.business.Book"%>
<%@page import="com.arquitecturajava.business.Chapter"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="author" content="Germán Zunzunegui Rodríguez"/>
        <meta name="description" content="Formulario de visualización de los capítulos del libro."/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="img/avalon.ico"/>
        <title>Capítulos del libro</title>
    </head>
    <body>
        <header>
            <h1>CAPÍTULOS DE «${fn:toUpperCase(book.title)}»</h1>
        </header>
        <main>
            <table>
                <thead>
                    <tr>
                        <th>TÍTULO</th>
                        <th>PÁGINAS</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach var="chapter" items="${book.chapters}">
                    <tr>
                        <td class="greatCell">${chapter.pk_title}</td>
                        <td class="veryTinyCell">${chapter.pages}</td>
                        <td class="tinyCell">
                            <a href='LibraryServiceController?action=deleteChapter&isbn=${book.pk_isbn}&title=${chapter.pk_title}'>Borrar</a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="links">
                <a href='LibraryServiceController?action=addBookChapter&isbn=${book.pk_isbn}'>Añadir un capítulo</a>
                <a href='LibraryServiceController'>Volver a la lista</a>
            </div>
        </main>
    </body>
</html>