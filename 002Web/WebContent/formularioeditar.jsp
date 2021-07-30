<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page  import="com.arquitecturajava.negocio.Libro" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ServletControlador" method="POST">
<p>
Isbn:<input type="text" name="isbn" value="${libro.isbn}" readonly="readonly"/>
</p>
<p>
Titulo:<input type="text" name="titulo" value="${libro.titulo}"/>
</p>
<p>
Autor:<input type="text" name="autor" value="${libro.autor}"/>
</p>
<input type="hidden" name="accion" value="actualizar"/>
<input type="submit" value="actualizar"/>
</form>

</body>
</html>