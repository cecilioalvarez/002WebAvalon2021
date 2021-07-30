<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.arquitecturajavaJSP.negocio.Libro" %>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%-- <%
String isbn = (String)request.getAttribute("miIsbn");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletControladorCapitulo" method="POST">
		<p>
		<label for="isbn">ISBN de Libro: </label>
		<!-- <input name="isbn"/> -->
		<input type="text" disabled="disabled" value="${miIsbn}"/>
		<input type="hidden" name="isbn" value="${miIsbn}"/>
		<%-- <input type="text" disabled="disabled" value="<%=isbn%>"/>
		<input type="hidden" name="isbn" value="<%=isbn%>"/> --%>
		</p>
		<p>
		<label for="titulo">Titulo de Capitulo: </label>
		<input name="titulo"/>
		</p>
		<p>
		<label for="paginas">Numero de páginas: </label>
		<input type="number" name="paginas"/>
		</p>
		<p>
		<input type="hidden" name="accion" value="insertar"/>
		<input type="submit" value="Enviar Datos"/>
		</p>
	</form>
</body>
</html>