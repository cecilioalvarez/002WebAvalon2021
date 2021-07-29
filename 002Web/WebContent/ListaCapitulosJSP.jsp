<%@page import="com.arquitecturajavaJSP.negocio.Capitulo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>

<%
//Ya no accedo a DB desde jsp, sino al ServletControlador
List<Capitulo> listaCapitulos = (List<Capitulo>) request.getAttribute("capitulos");
%>
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
			<th>Libro</th>
			<th>Titulo</th>
			<th>Paginas</th>
			<th colspan="3">Acciones</th>
			<!-- <th>Borrar</th>
			<th>Detalle</th>
			<th>Modificar</th> -->
		</tr>
		</thead>
		<tbody>
			<%for(Capitulo chapter: listaCapitulos){ %>
	            <tr>
	            	<td><%=chapter.getLibro().getIsbn() %></td>
	            	<td><%=chapter.getTitulo() %></td>
	            	<td><%=chapter.getPaginas() %></td>
	            	<td><a href="ServletControladorCapitulo?accion=borrar&titulo=<%=chapter.getTitulo()%>&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: red">Borrar</a></td>
	            	<td><a href="ServletControladorCapitulo?accion=detalle&titulo=<%=chapter.getTitulo()%>&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: purple">Detalle</a></td>
	            	<td><a href="ServletControladorCapitulo?accion=formularioModificar&titulo=<%=chapter.getTitulo()%>&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: blue">Modificar</a></td>
	            </tr>
            <% } %>
			<tr></tr>
		</tbody>
	</table>
	<a href="ServletControladorCapitulo?accion=formularioInsertar" style="color: green">Nuevo Capitulo</a>
</body>
</html>