<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<title>Insertar Libro</title>
</head>
<body>

	<form action="ServletControlador" method="POST">
		<p>
			ISBN:<input type="text" name="isbn" />
		</p>
		<p>
			Título:<input type="text" name="titulo" />
		</p>
		<p>
			Autor:<input type="text" name="autor" />
		</p>
		<input type="hidden" name="accion" value="insertar">
		<p><input type="submit" value="enviar datos">
	</form>
	<a href="ServletControlador">listado</a>

</body>
</html>