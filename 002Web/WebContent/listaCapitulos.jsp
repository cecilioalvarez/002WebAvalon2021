<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Lista de capitulos</title>
</head>
<body>

<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Titulo</th>
				<th scope="col">Páginas</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="capitulo" items="${capitulos}">

			<tr>
				<td>${capitulo.titulo}</td>
				<td>${capitulo.paginas}</td> 
				<td><a
					href="ServletControladorCapitulos?accion=borrar&titulo=${capitulo.titulo}&isbn=${param.isbn}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	
	<p><a href="ServletControladorCapitulos?accion=formularioInsertar&isbn=${param.isbn}">nuevo capitulo</a></p>
	
	
	<p><a href="ServletControlador">Listado libros</a></p> 

</body>
</html>