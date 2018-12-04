<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Nuevo usuario de Profesor</title>  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />  
	<link href="css/AltaProfesor.css" type="text/css" rel="stylesheet" />
	<script src="js/Redireccionar.js"></script>
  </head>
    
  <body>
    <header>
        <h1>Ingrese los datos del nuevo profesor</h1>
    </header>  
	
    <form action="AltaProfesorServlet" method="post">
		<div>
			<label for="dni">DNI:</label>
			<input type="text" id="dni" placeholder="ej: 31285677" />
		</div>
		<div>
			<label for="nombre">Nombre:</label>
			<input type="text" id="nombre" placeholder="ej: Daniela Hernandez" />
		</div>
		<div>
			<label for="domicilio">Domicilio:</label>
			<input type="text" id="domicilio" placeholder="ej: Rincon 1875" />
		</div>
		<div>
			<label for="domicilioClases">Domicilio de clases:</label>
			<input type="text" id="domicilioClases" placeholder="ej: Rincon 1875" />
		</div>
		<div>
			<label for="anticipacion">Horas de anticipacion de reserva:</label>
			<input type="text" id="anticipacion" placeholder="ej: 72" />
		</div>
		<div>
			<label for="mail">e-mail:</label>
			<input type="email" id="mail" placeholder="ej: user@domain.com" />
		</div>
		<div>
			<label for="telefono">Teléfono:</label>
			<input type="text" id="telefono" placeholder="ej: 1150557862" />
		</div>
		<div>
			<label for="fechaNac">Fecha de nacimiento:</label>
			<input type="text" id="fechaNac" placeholder="dd/mm/aaaa" />
		</div>
		<div>
			<label for="pass">Contraseña:</label>
			<input type="password" id="pass" />
		</div>
		<div>
			<label for="passConf">Confirmar contraseña:</label>
			<input type="password" id="passConf" />
		</div>
		
		<div>
            <input type="submit" value="Enviar datos" id="btn-enviar-datos" />
			<input type="button" value="Ir a Menu Principal" id="btn-menu-ppal" onclick="volverAlInicio();" />
		</div>
	</form>
      
  </body>
</html>