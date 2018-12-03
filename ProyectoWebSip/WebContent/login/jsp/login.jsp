<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/login/css/main.css">
<link rel="stylesheet" href="/login/css/menuDesplegable.css">
</head>
<body>

    <header id="header" class="alt">
      <nav id="nav">
        <ul>
          <li><a href="/inicio.jsp">Home</a></li>
          <li><a href="index.html" class="button">Sign In</a></li>
        </ul>
      </nav>
    </header>





    <form action="", name="formulario">
      <img class="avatar" src="img/abc.jpg">       

      <h2>Login</h2>
      <input type="text" placeholder="&#129333; DNI" name="usr" required>
      <input type="password" placeholder="&#128273; Contraseña" name="clave" required>
      <div> Loguearse como:
        <select id="log" onchange="getSelectValue();">
         <option>-seleccion-</option>
          <option value="alu">Alumno</option>
          <option value="prof">Profesor</option>
          <option value="admin">Administrador</option>
        </select>
      </div>
      <input type="submit" value="Ingresar" onclick="validar()">

      <!-- <a etiqueta hyperlinks-->
      <br>
      <br>
      <ul>
        <a href="#">¿Olvidaste tu contraseña?</a>
      </ul>

    </form>

    <script src="js/menu.js"></script>

 
</body>
</html>