
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.negocio.Capitulo"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- <%
Capitulo chapter = (Capitulo) request.getAttribute("miCapitulo");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControladorCapitulo" method="POST">
	<p>
		Titulo de Capitulo: <input type="text" disabled="disabled" value="${miCapitulo.titulo}"/>
		<input type="hidden" name="titulo" value="${miCapitulo.titulo}"/>
	</p>
	<p>
		Páginas: <input type="number" name="paginas" value="${miCapitulo.paginas}"/>
	</p>
	<p>
		Libro ISBN: <input type="text" name="isbn" value="${miCapitulo.libro.isbn}"/>
	</p>
	<input type="hidden" name="accion" value="modificar"/>
	<input style="background-color: green;color: white;border-color: green" type="submit" value="Guardar Cambios"/>
</form>
<a href="ServletControlador?accion=detalle&isbn=${miCapitulo.libro.isbn}" style="color: blue">Volver</a>
</body>
</html>