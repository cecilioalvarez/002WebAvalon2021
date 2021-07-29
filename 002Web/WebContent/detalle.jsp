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
<title>Insert title here</title>
</head>
<body>
<p>ISBN: <%=libro.getIsbn() %></p>
<p>Título: <%=libro.getTitulo() %></p>
<p>Autor: <%=libro.getAutor() %></p>
<a href="ServletControlador">Volver</a>


</body>
</html>