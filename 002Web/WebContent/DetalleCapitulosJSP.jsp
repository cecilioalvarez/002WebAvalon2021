<%@page import="com.arquitecturajavaJSP.negocio.Capitulo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- <%
Capitulo capitulo = (Capitulo) request.getAttribute("miCapitulo");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		Libro con ISBN:${miCapitulo.libro.isbn}
	</p>
	<p>
		Título de Capítulo:${miCapitulo.titulo}
	</p>
	<p>
		Nº Páginas:${miCapitulo.paginas}
	</p>
	<a href="ServletControlador?accion=detalle&isbn=${miCapitulo.libro.isbn}" style="color: blue">Volver</a>
	<%-- <p>
		Libro con ISBN:<%=capitulo.getLibro().getIsbn()%>
	</p>
	<p>
		Título de Capítulo:<%=capitulo.getTitulo()%>
	</p>
	<p>
		Nº Páginas:<%=capitulo.getPaginas()%>
	</p>
	<a href="ServletControlador?accion=detalle&isbn=<%=capitulo.getLibro().getIsbn()%>" style="color: blue">Volver</a>
 --%>
</body>
</html>