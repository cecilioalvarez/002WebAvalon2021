<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
<%@page import="com.arquitecturajavaJSP.negocio.Capitulo" %>
<!--  taglib permite usar la librería en esta clase-->
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- <%
Libro libro = (Libro) request.getAttribute("milibro");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- <p>
		ISBN:<%=libro.getIsbn()%>
	</p>
	<p>
		Título:<%=libro.getTitulo()%>
	</p>
	<p>
		Autor:<%=libro.getAutor()%>
	</p> --%>
	<p>
		ISBN:<c:out value="${milibro.isbn}"/>
	</p>
	<p>
		Título:<c:out value="${milibro.titulo}"/>
	</p>
	<p>
		Autor:<c:out value="${milibro.autor}"/>
	</p>
	<%-- <%if(libro.getListacoCapitulos().size()>0){ %> --%>
	
	<c:choose>
	  <c:when test="${milibro.listacoCapitulos.size() gt 0}">
	    <a href="ServletControladorCapitulo?accion=formularioInsertar&isbn=${milibro.isbn}" style="color: green">Agregar Capitulo</a>
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
			<c:forEach var="chapter" items="${milibro.listacoCapitulos}">
					<tr>
						<td><c:out value="${chapter.libro.isbn}"/></td>
		            	<td><c:out value="${chapter.titulo}"/></td>
		            	<td>${chapter.paginas}</td>
		            	<td><a href="ServletControladorCapitulo?accion=borrar&titulo=<c:out value="${chapter.titulo}"/>&isbn=${chapter.libro.isbn}" style="color: red">Borrar</a></td>
		            	<td><a href="ServletControladorCapitulo?accion=detalle&titulo=${chapter.titulo}&isbn=${chapter.libro.isbn}" style="color: purple">Detalle</a></td>
		            	<td><a href="ServletControladorCapitulo?accion=formularioModificar&titulo=${chapter.titulo}&isbn=${chapter.libro.isbn}" style="color: blue">Modificar</a></td>
					</tr>
			</c:forEach>	
				<%-- <%for(Capitulo chapter: libro.getListacoCapitulos()){ %>
		            <tr>
		            	<td><%=chapter.getLibro().getIsbn() %></td>
		            	<td><%=chapter.getTitulo() %></td>
		            	<td><%=chapter.getPaginas() %></td>
		            	<td><a href="ServletControladorCapitulo?accion=borrar&titulo=<%=chapter.getTitulo()%>&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: red">Borrar</a></td>
		            	<td><a href="ServletControladorCapitulo?accion=detalle&titulo=<%=chapter.getTitulo()%>&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: purple">Detalle</a></td>
		            	<td><a href="ServletControladorCapitulo?accion=formularioModificar&titulo=<%=chapter.getTitulo()%>&isbn=<%=chapter.getLibro().getIsbn()%>" style="color: blue">Modificar</a></td>
		            </tr>
	            <% } %> --%>
			</tbody>
		</table>
	  </c:when>
	  <c:otherwise>
	    <%-- <%}else{ %> --%>
			<p style="color: orange;">
				Sin Capítulos Registrados.<a href="ServletControladorCapitulo?accion=formularioInsertar&isbn=${milibro.isbn}" style="color: green">Agregar Capitulo</a>
			</p>
		<%-- <%} %> --%>
	  </c:otherwise>
	</c:choose>
	
	
	<a href="ServletControlador" style="color: blue">Volver</a>
</body>
</html>