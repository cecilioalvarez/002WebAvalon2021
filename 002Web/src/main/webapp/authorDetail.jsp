<%-- 
    Document: authorDetail
    Created on: 27-jul-2021, 13:08:34
    Author: Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.arquitecturajava.business.Author"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Detalles de autor"/>
        <jsp:param name="description" value="Tabla de visualización de Autor de la BD."/>
    </jsp:include>
    <body>
        <header>
            <h1>DATOS DEL AUTOR</h1>
        </header>
        <main>
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
                        <td class="cell-20">${fn:toUpperCase(author.pk_id)}</td>
                        <td class="cell-60">${author.name}</td>
                        <td class="cell-20">${author.age}</td>
                    </tr>
                </tbody>
            </table>
            <div>
                <a href='LibraryServiceController'>Volver a la lista</a>
            </div>
        </main>
    </body>
</html>
