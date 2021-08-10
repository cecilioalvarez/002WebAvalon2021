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
			ISBN1:<input type="text" name="isbn1" />
		</p>
		<p>
			Título1:<input type="text" name="titulo1" />
		</p>
		<p>
			Autor1:<input type="text" name="autor1" />
		</p>
		<p>
			ISBN2:<input type="text" name="isbn2" />
		</p>
		<p>
			Título2:<input type="text" name="titulo2" />
		</p>
		<p>
			Autor2:<input type="text" name="autor2" />
		</p>
		<input type="hidden" name="accion" value="insertar2">
		<p><input type="submit" value="enviar datos">
	</form>
	<a href="ServletControlador">listado</a>

</body>
</html>