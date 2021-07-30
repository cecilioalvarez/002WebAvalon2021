<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="negocio.Libro"%>
<%@page import="repositorio.jdbc.*"%>
<%@page import="repositorio.servicios.LibroService"%>
<%@page import="repositorio.servicios.standard.*"%>
<%@page import="repositorio.jdbc.helper.LibroRepositoryJDBC"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
	<form action="ServletControlador" method="POST">
		<p>
			Isbn:<input type="text" name="isbn" value="${libro.isbn}" readonly="readonly" />

		</p>
		<p>
			Titulo:<input type="text" name="titulo"
				value="${libro.titulo}" />

		</p>
		<p>
			Autor:<input type="text" name="autor" value="${libro.autor}" />

		</p>
		<input type="hidden" name="accion" value="actualizar"/>
		<input type="submit" value="actualizar" />
	</form>
</body>
</html>