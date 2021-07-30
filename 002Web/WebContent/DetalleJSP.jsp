<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.negocio.Capitulo" %>

<%
Libro libro = (Libro) request.getAttribute("milibro");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		ISBN:<%=libro.getIsbn()%>
	</p>
	<p>
		Título:<%=libro.getTitulo()%>
	</p>
	<p>
		Autor:<%=libro.getAutor()%>
	</p>
	<%if(libro.getListacoCapitulos().size()>0){ %>
	<a href="ServletControladorCapitulo?accion=formularioInsertar&isbn=<%=libro.getIsbn()%>" style="color: green">Agregar Capitulo</a>
	<table style="border-collapse: collapse;width: 100%;text-align: center;" border="2px solid black;">
		<thead>
		<tr style="background-color: #E1B933;color: white;" >
			<th>Libro</th>
			<th>Titulo de Capitulo</th>
			<th>Paginas</th>
			<th colspan="3">Acciones</th>
			<!-- <th>Borrar</th>
			<th>Detalle</th>
			<th>Modificar</th> -->
		</tr>
		</thead>
		<tbody>
			<%for(Capitulo chapter: libro.getListacoCapitulos()){ %>
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
	<%}else{ %>
		<p style="color: orange;">
			Sin Capítulos Registrados.<a href="ServletControladorCapitulo?accion=formularioInsertar&isbn=<%=libro.getIsbn()%>" style="color: green">Agregar Capitulo</a>
		</p>
	<%} %>
	<a href="ServletControlador" style="color: blue">Volver</a>
</body>
</html>