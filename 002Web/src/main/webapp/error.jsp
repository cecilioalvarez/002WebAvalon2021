<%-- 
    Document   : error
    Created on : 09-ago-2021, 13:36:34
    Author     : Germán Zunzunegui
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Error en el servidor"/>
        <jsp:param name="description" value="Detalles de error en el servidor."/>
    </jsp:include>
    <body>
    <header>
        <h1>ERRORES</h1>
    </header>
    <body>
        <main>
            <label>A cotninuación se detalla el error producido:</label>
            <p><%=exception.getMessage()%></p>
        </main>
    </body>
</html>