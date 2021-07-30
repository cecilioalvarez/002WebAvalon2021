<%-- 
    Document   : authorDetail
    Created on : 27-jul-2021, 13:08:34
    Author     : Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.arquitecturajava.business.Author"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h2>DATOS DEL AUTOR</h2>
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
                    <td class="tinyCell">${fn:toUpperCase(author.pk_id)}</td>
                    <td class="standardCell">${author.name}</td>
                    <td class="tinyCell">${author.age}</td>
                </tr>
            </tbody>
        </table>
        <div>
            <a href='LibraryServiceController'>Volver a la lista</a>
        </div>
    </body>
</html>
