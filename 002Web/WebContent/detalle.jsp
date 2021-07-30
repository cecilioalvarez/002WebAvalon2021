<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="negocio.Libro"%>
<%@page import="repositorio.jdbc.*"%>
<%@page import="repositorio.servicios.LibroService"%>
<%@page import="repositorio.servicios.standard.*"%>
<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle</title>
</head>
<body>
	<p>
		Isbn:
		${libro.isbn}
	</p>
	<p>
		Titulo:
		${libro.titulo}
	</p>
	<p>
		Autor:
		${libro.autor}
	</p>
	<a href="ServletControlador">volver</a>
</body>
</html>