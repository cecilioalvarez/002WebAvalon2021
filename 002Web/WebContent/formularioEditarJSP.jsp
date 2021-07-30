<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- <%
Libro libro = (Libro) request.getAttribute("milibro");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControlador" method="POST">
	<p>
		ISBN: <input type="text" disabled="disabled" value="${milibro.isbn}"/>
		<input type="hidden" name="isbn" value="${milibro.isbn}"/>
	</p>
	<p>
		Título: <input type="text" name="titulo" value="${milibro.titulo}"/>
	</p>
	<p>
		Autor: <input type="text" name="autor" value="${milibro.autor}"/>
	</p>
	<%-- <p>
		ISBN: <input type="text" disabled="disabled" value="<%=libro.getIsbn()%>"/>
		<input type="hidden" name="isbn" value="<%=libro.getIsbn()%>"/>
	</p>
	<p>
		Título: <input type="text" name="titulo" value="<%=libro.getTitulo()%>"/>
	</p>
	<p>
		Autor: <input type="text" name="autor" value="<%=libro.getAutor()%>"/>
	</p> --%>
	<input type="hidden" name="accion" value="modificar"/>
	<input style="background-color: green;color: white;border-color: green" type="submit" value="Guardar Cambios"/>
</form>
</body>
</html>