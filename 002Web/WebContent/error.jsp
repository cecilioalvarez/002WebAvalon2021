<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" import="java.io.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
<h2 style="color: red">Error</h2>
<p>
<%=exception.getMessage()%>
</p>
<a href="ServletControlador" style="color: blue">Volver a Inicio</a>

</body>
</html>