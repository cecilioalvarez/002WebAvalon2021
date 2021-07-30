<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.arquitecturajava.negocio.Libro"%>

<%
Libro libro=(Libro)request.getAttribute("libro");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		ISBN: <%=libro.getIsbn()%>
	</p>
	<p>
		TITULO: <%=libro.getTitulo()%>
	</p>
	<p>
		AUTOR: <%=libro.getAutor()%>
	</p>
	<a href="ServletControlador">VOLVER A LA LISTA DE LIBROS</a>
</body>
</html>