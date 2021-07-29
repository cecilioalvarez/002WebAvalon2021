
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.negocio.Capitulo"%>

<%
Capitulo chapter = (Capitulo) request.getAttribute("miCapitulo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControladorCapitulo" method="POST">
	<p>
		Titulo de Capitulo: <input type="text" disabled="disabled" value="<%=chapter.getTitulo()%>"/>
		<input type="hidden" name="titulo" value="<%=chapter.getTitulo()%>"/>
	</p>
	<p>
		Páginas: <input type="number" name="paginas" value="<%=chapter.getPaginas()%>"/>
	</p>
	<p>
		Libro ISBN: <input type="text" name="isbn" value="<%=chapter.getLibro().getIsbn()%>"/>
	</p>
	<input type="hidden" name="accion" value="modificar"/>
	<input style="background-color: green;color: white;border-color: green" type="submit" value="Guardar Cambios"/>
</form>
<a href="ServletControlador?accion=detalle&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: blue">Volver</a>
</body>
</html>