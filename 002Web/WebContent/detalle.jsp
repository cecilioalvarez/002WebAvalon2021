<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.arquitecturajava.negocio.Libro"%>

<%
Libro libro=(Libro)request.getAttribute("libro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Detalle Título</title>
</head>
<body>
<p>ISBN: <%=libro.getIsbn() %></p>
<p>Título: <%=libro.getTitulo() %></p>
<p>Autor: <%=libro.getAutor() %></p>
<a href="ServletControlador">Volver</a>


</body>
</html>