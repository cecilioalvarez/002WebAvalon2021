<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true" import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página de error</title>
</head>
<body>
<h1>Error - ocurrio un error realizando la petición</h1>
<h3><%=exception.getMessage() %></h3>
<a href="ServletControlador">listado</a>
</body>
</html>