<%-- 
    Document   : authorDetail
    Created on : 27-jul-2021, 13:08:34
    Author     : Germán Zunzunegui
--%>

<%@page import="com.arquitecturajava.business.Author"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Author author = (Author) request.getAttribute("author"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta name="author" content="Germán Zunzunegui Rodríguez"/>
        <meta name="description" content="Formulario de visualización de Autor en la BD."/>
        <link href="style/styles.css" rel="stylesheet" type="text/css"/>
        <title>Detalles de autor</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>NIF</th>
                    <th>NOMBRE</th>
                    <th>EDAD</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=author.getPk_id().toUpperCase() %></td>
                    <td><%=author.getName() %></td>
                    <td><%=author.getAge() %></td>
                </tr>
            </tbody>
        </table>
        <div>
            <a href='LibraryServiceController'>Volver a la lista</a>
        </div>
    </body>
</html>
