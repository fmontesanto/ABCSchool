<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="es">

<head>
	<title>ABC school</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link href="css/Login/main.css" type="text/css" rel="stylesheet" />
	<link href="css/Login/menuDesplegable.css" type="text/css" rel="stylesheet" />
</head>

<body class="landing is-preload">
	<header id="header" class="alt">
		<nav id="nav">
			<ul>
				<li><a href="Inicio.jsp">Home</a></li>
				<li><a href="AltaUsrAlumno.jsp" class="button">Sign Up</a></li>
			</ul>
		</nav>
	</header>

	<form action="LoginServlet" name="formulario">
		<img class="avatar" src="images/abc.jpg">
		<h2>Login</h2>
		<input type="text" placeholder="&#129333; DNI" name="usr" required>
		<input type="password" placeholder="&#128273; Contraseña" name="clave" required>
		<div>
			Loguearse como: <select id="log" name="rol">
				<option>-seleccion-</option>
				<option value="alumno">Alumno</option>
				<option value="profesor">Profesor</option>
				<option value="admin">Administrador</option>
			</select>
		</div>
		<input type="submit" value="Ingresar" onclick="validar()">
		<br> <br>
		<ul>
			<a href="#">¿Olvidaste tu contraseña?</a>
			<br>
			<a href="AltaUsrAlumno.jsp">Crear una cuenta</a>
		</ul>
	</form>

	<script src="js/menu.js"></script>
</body>

</html>