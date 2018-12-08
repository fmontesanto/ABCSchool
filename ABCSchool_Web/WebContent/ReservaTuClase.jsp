<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale-1, minimun-scale=1">
  <title>ABC school</title>
  <!-- enlazo css con el doc html-->
  <link rel="stylesheet" href="css/Alumno/ReservarClase.css" type="text/css" />
</head>
<body>

<header>
    <input type="checkbox" id="btn-menu">
    <label for="btn-menu"><img src="img/cloud-with-three-menu-dots_icon-icons.com_56533.png"></label>
    <nav class="menu">
      <ul>
        <li><a href="PerfilAlumno.jsp">Mis clases</a></li>
        <li><a href="ReservaTuClase.jsp">Reserva tu clase</a></li>
        <li><a href="">Mi perfil</a></li>
        <ul class="end">
          <li><a href="">
              <span>Cerrar sesion</span>
            </a>
          </li>
        </ul>
      </ul>
    </nav>
  </header>
  <div class="dropdown">
    <button onclick="myFunctionMateria()" class="dropbtn">Materia</button>
    <div id="myDropdownMateria" class="dropdown-content">
      <input type="text" placeholder="Search.." id="myInputMateria" onkeyup="filterFunction()">
      <a href="#Lengua">Lengua</a>
      <a href="#Matematicas">Matematicas</a>
      <a href="#Historia">Historia</a>
      <a href="#Civica">Civica</a>
      <a href="#Ingles">Ingles</a>
      <a href="#Frances">Frances</a>
      <a href="#Chino">Chino</a>
    </div>
  </div>
  <div class="dropdown">
    <button onclick="myFunctionProfesor()" class="dropbtn">Profesor</button>
    <div id="myDropdownProfesor" class="dropdown-content">
      <input type="text" placeholder="Search.." id="myInputProfesor" onkeyup="filterFunction()">
      <a href="#Marco">Marco</a>
      <a href="#Facundo">Facundo</a>
      <a href="#Agustina">Agustina</a>
      <a href="#Florencia">Florencia</a>
      <a href="#German">German</a>
      <a href="#Julian">Julian</a>
    </div>
  </div>
  <style>
    /* Dropdown Button */
    .dropbtn {
      background-color: #FFB940;
      color: white;
      padding: 16px;
      font-size: 16px;
      border: none;
      cursor: pointer;
    }

    /* Dropdown button on hover & focus */
    .dropbtn:hover,
    .dropbtn:focus {
      background-color: #ffd080;
    }

    /* The search field */
    #myInput {
      border-box: box-sizing;
      background-image: url('searchicon.png');
      background-position: 14px 12px;
      background-repeat: no-repeat;
      font-size: 16px;
      padding: 14px 20px 12px 45px;
      border: none;
      border-bottom: 1px solid #ddd;
    }

    /* The search field when it gets focus/clicked on */
    #myInput:focus {
      outline: 3px solid #ddd;
    }

    /* The container <div> - needed to position the dropdown content */
    .dropdown {
      position: relative;
      display: inline-block;
    }

    /* Dropdown Content (Hidden by Default) */
    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f6f6f6;
      min-width: 230px;
      border: 1px solid #ddd;
      z-index: 1;
    }

    /* Links inside the dropdown */
    .dropdown-content a {
      color: black;
      padding: 12px 16px;
      text-decoration: none;
      display: block;
    }

    /* Change color of dropdown links on hover */
    .dropdown-content a:hover {
      background-color: #f1f1f1
    }

    /* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
    .show {
      display: block;
    }
  </style>
  <script>
    /* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
    function myFunctionMateria() {
      document.getElementById("myDropdownMateria").classList.toggle("show");
    }

    function filterFunctionMateria() {
      var input, filter, ul, li, a, i;
      input = document.getElementById("myInputMateria");
      filter = input.value.toUpperCase();
      div = document.getElementById("myDropdownMateria");
      a = div.getElementsByTagName("a");
      for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
          a[i].style.display = "";
        } else {
          a[i].style.display = "none";
        }
      }
    }
  </script>
  <script>
    /* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
    function myFunctionProfesor() {
      document.getElementById("myDropdownProfesor").classList.toggle("show");
    }

    function filterFunctionProfesor() {
      var input, filter, ul, li, a, i;
      input = document.getElementById("myInputProfesor");
      filter = input.value.toUpperCase();
      div = document.getElementById("myDropdownProfesor");
      a = div.getElementsByTagName("a");
      for (i = 0; i < a.length; i++) {
        if (a[i].innerHTML.toUpperCase().indexOf(filter) > -1) {
          a[i].style.display = "";
        } else {
          a[i].style.display = "none";
        }
      }
    }
  </script>


</body>
</html>