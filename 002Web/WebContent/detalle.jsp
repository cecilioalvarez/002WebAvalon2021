<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page  import="com.arquitecturajava.negocio.Libro" %>
<%@page  import="com.arquitecturajava.servicios.LibroService" %>
<%@page  import="com.arquitecturajava.servicios.standard.LibroServiceStandard" %>
<%@page  import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC"%>
<%
LibroService service= new LibroServiceStandard(new LibroRepositoryJDBC());
Libro libro=service.buscarUno(request.getParameter("isbn"));
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
</body>
</html>