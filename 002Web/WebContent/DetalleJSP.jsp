<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>

<%
Libro libro = (Libro) request.getAttribute("milibro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		ISBN:<%=libro.getIsbn()%>
	</p>
	<p>
		Título:<%=libro.getTitulo()%>
	</p>
	<p>
		Autor:<%=libro.getAutor()%>
	</p>
	<a href="ServletControlador" style="color: blue">Volver</a>
</body>
</html>