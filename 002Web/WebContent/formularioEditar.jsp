<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="negocio.Libro"%>
<%@page import="repositorio.jdbc.*" %>
<%@page import="repositorio.servicios.LibroService" %>
<%@page import="repositorio.servicios.standard.*" %>
<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>

<%
LibroService repositorio = new LibroServiceStandard(new LibroRepositoryJDBC());
Libro libro = repositorio.buscarUno(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
<form action="ServletActualizar" method="POST">
	<p>
		Isbn:<input type="text" name="isbn" value="<%=libro.getIsbn()%>"/>
		
	</p>
	<p>
		Titulo:<input type="text" name="titulo" value="<%=libro.getTitulo()%>"/>
		
	</p>
	<p>
		Autor:<input type="text" name="autor" value="<%=libro.getAutor()%>"/>
		
	</p>
	<input type="submit" value="actualizar" />
</form>
</body>
</html>