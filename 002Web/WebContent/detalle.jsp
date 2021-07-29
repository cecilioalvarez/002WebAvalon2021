<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page  import="com.arquitecturajava.negocio.Libro" %>

<%

Libro libro=(Libro)request.getAttribute("libro");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
Isbn:<%=libro.getIsbn()%>
</p>
<p>
Titulo:<%=libro.getTitulo()%>
</p>
<p>
Autor:<%=libro.getAutor()%>
</p>
<a href="ServletControlador">volver </a>
</body>
</html>