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