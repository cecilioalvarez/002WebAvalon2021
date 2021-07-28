<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.servicios.LibroService" %>
<%@page import="com.arquitecturajavaJSP.servicios.standard.LibroServiceStandard" %>
<%@page import="com.arquitecturajavaJSP.repositorios.jdbc.Libro_RepositoryJDBC" %>

<%
LibroService service = new LibroServiceStandard(new Libro_RepositoryJDBC());
Libro libro = service.buscarLibro(request.getParameter("isbn"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControlador" method="POST">
	<p>
		ISBN: <input type="text" disabled="disabled" value="<%=libro.getIsbn()%>"/>
		<input type="hidden" name="isbn" value="<%=libro.getIsbn()%>"/>
	</p>
	<p>
		Título: <input type="text" name="titulo" value="<%=libro.getTitulo()%>"/>
	</p>
	<p>
		Autor: <input type="text" name="autor" value="<%=libro.getAutor()%>"/>
	</p>
	<input type="hidden" name="accion" value="modificar"/>
	<input style="background-color: green;color: white;border-color: green" type="submit" value="Guardar Cambios"/>
</form>
</body>
</html>