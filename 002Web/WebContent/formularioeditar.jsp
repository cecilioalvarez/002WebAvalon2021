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
	<form action="ServletControlador" method="post">
		<p>
			ISBN:<input type="text" name="isbn" value="<%=libro.getIsbn()%>" readonly="readonly"/>
		</p>
		<p>
			TITULO:<input type="text" name="titulo" value="<%=libro.getTitulo()%>" />
		</p>
		<p>
			AUTOR:<input type="text" name="autor" value="<%=libro.getAutor()%>" />
		</p>
		<input type="hidden" name="accion" value="actualizar"/>
		<input type="submit" value="actualizar"/>
	</form>
</body>
</html>