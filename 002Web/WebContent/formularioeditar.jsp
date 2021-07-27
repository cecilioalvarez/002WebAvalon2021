<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page  import="com.arquitecturajava.negocio.Libro" %>
<%@page  import="com.arquitecturajava.repositorios.LibroRepository" %>
<%@page  import="com.arquitecturajava.repositorios.jdbc.LibroRepositoryJDBC" %>
<%
LibroRepository repositorio= new LibroRepositoryJDBC();
Libro libro=repositorio.buscarUno(request.getParameter("isbn"));
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServletActualizar" method="POST">
<p>
Isbn:<input type="text" name="isbn" value="<%=libro.getIsbn()%>"/>
</p>
<p>
Titulo:<input type="text" name="titulo" value="<%=libro.getTitulo()%>"/>
</p>
<p>
Autor:<input type="text" name="autor" value="<%=libro.getAutor()%>"/>
</p>
<input type="submit" value="actualizar"/>
</form>

</body>
</html>