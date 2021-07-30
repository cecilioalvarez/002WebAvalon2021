<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<!--  taglib permite usar la librería en esta clase-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>

<%--Ahora se hace con JSTL y la lista de libros está en la request, se llama directamente
 <%
//Ya no accedo a DB desde jsp, sino al ServletControlador
List<Libro> listaLibros = (List<Libro>) request.getAttribute("libros");
%> --%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	a {
		text-decoration:none;
	}
</style>
</head>
<body>
	<table style="border-collapse: collapse;width: 100%;text-align: center;" border="2px solid black;">
		<thead>
		<tr style="background-color: #E1B933;color: white;" >
			<th>ISBN</th>
			<th>Titulo</th>
			<th>Autor</th>
			<th colspan="3">Acciones</th>
			<!-- <th>Borrar</th>
			<th>Detalle</th>
			<th>Modificar</th> -->
		</tr>
		</thead>
		<tbody>
		<c:forEach var="libro" items="${libros}">
			<tr>
	            	<td><c:out value="${libro.isbn}"/></td>
	            	<td><c:out value="${fn:toUpperCase(libro.titulo)}"/></td>
	            	<td><c:out value="${libro.autor}"/></td>
	            	<td><a href="ServletControlador?accion=borrar&isbn=<c:out value="${libro.isbn}"/>" style="color: red">Borrar</a></td>
	            	<td><a href="ServletControlador?accion=detalle&isbn=<c:out value="${libro.isbn}"/>" style="color: purple">Detalle</a></td>
	            	<td><a href="ServletControlador?accion=formularioModificar&isbn=<c:out value="${libro.isbn}"/>" style="color: blue">Modificar</a></td>
	            </tr>
		</c:forEach>
		
<%-- 			<%for(Libro libro: listaLibros){ %> --%>
<!-- 	            <tr> -->
<%-- 	            	<td><%=libro.getIsbn() %></td> --%>
<%-- 	            	<td><%=libro.getTitulo() %></td> --%>
<%-- 	            	<td><%=libro.getAutor() %></td> --%>
<%-- 	            	<td><a href="ServletControlador?accion=borrar&isbn=<%=libro.getIsbn()%>" style="color: red">Borrar</a></td> --%>
<%-- 	            	<td><a href="ServletControlador?accion=detalle&isbn=<%=libro.getIsbn()%>" style="color: purple">Detalle</a></td> --%>
<%-- 	            	<td><a href="ServletControlador?accion=formularioModificar&isbn=<%=libro.getIsbn()%>" style="color: blue">Modificar</a></td> --%>
<!-- 	            </tr> -->
<%--             <% } %> --%>
		</tbody>
	</table>
	<a href="ServletControlador?accion=formularioInsertar" style="color: green">Nuevo Libro</a>
</body>
</html>