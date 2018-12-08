<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <!-- utf-8 para idioma español-->
    <!-- viewport = todo lo que vez por pantalla; width= ancho de la pantalla; user-scalable si se puede hacer zoom o no-->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale-1, minimun-scale=1">
    <title>ABC school</title>
    <!-- enlazo css con el doc html-->
    <link href="css/Alumno/main.css" type="text/css" rel="stylesheet" />
  </head>
  <body style="   ">
    <header> <input id="btn-menu" style="" type="checkbox"> <label for="btn-menu"

        style=""><img src="img/cloud-with-three-menu-dots_icon-icons.com_56533.png"></label>
      <nav class="menu">
        <ul>
          <li><a href="Inicio.jsp">Inicio</a></li>
          <li><a href="">Reserva tu clase</a></li>
          <li><a href="">Mi perfil</a></li>
          <li><a href="">Opciones</a></li>
          <ul class="end">
            <li><a href=""> <span>Cerrar sesion</span> </a> </li>
          </ul>
        </ul>
      </nav>
    </header>
    <table>
      <tbody>
        <tr>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #ff6600;">Materia</span></b></th>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #996633;"><span style="color: #ff6600;">Profesor</span></span></b></th>
          <th style="vertical-align: inherit; background-color: white; width: 200px; height: 46px;"><b><span

                style="color: #ff6600;">Día<br>
              </span></b></th>
        </tr>
        <% for(int i=0; i<5; i++) { %>
        <tr>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;"><%= i  %></span></b></th>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #996633;"><span style="color: #ff6600;">matematica</span></span></b></th>
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;">matematica<br>
              </span></b></th>
        </tr>
    <% } %>
      </tbody>
    </table>
  </body>
</html>
    