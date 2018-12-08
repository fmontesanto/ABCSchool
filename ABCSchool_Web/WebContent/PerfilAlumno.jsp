<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- utf-8 para idioma español-->
    <meta charset="utf-8">
    <!-- viewport = todo lo que vez por pantalla; width= ancho de la pantalla; user-scalable si se puede hacer zoom o no-->
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale-1, minimun-scale=1">
    <title>ABC school</title>
    <!-- enlazo css con el doc html-->
    <link rel="stylesheet" href="css/Alumno/main.css">
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
            <li><a href="Inicio.jsp">
              <span>Cerrar sesion</span>
              </a>
            </li>
          </ul>
          
        </ul>
      </nav>
    </header>
    
 
    
   <!-- <table class="standard-table">
 <thead>
  <tr>
   <th scope="col">Elemento</th>
   <th scope="col">Descripción</th>
  </tr>
 </thead>
 <tbody>
  <tr>
   <td><a href="/es/docs/Web/HTML/Elemento/head" title="El elemento HTML &lt;head> provee información general (metadatos) acerca del documento, incluyendo su título y enlaces a scripts y hojas de estilos."><code>&lt;head&gt;</code></a></td>
   <td>Representa una colección de metadatos acerca del documento, incluyendo enlaces a, o definiciones de, scripts y hojas de estilo.</td>
  </tr>
  <tr>
   <td><a href="/es/docs/Web/HTML/Elemento/title" title="La documentación acerca de este tema no ha sido escrita todavía . ¡Por favor  considera contribuir !"><code>&lt;title&gt;</code></a></td>
   <td>Define el título del documento, el cual se muestra en la barra de título del navegador o en las pestañas de página. Solamente puede contener texto y cualquier otra etiqueta contenida no será interpretada.</td>
  </tr>
  <tr>
   <td><a href="/es/docs/Web/HTML/Elemento/base" title="El elemento HTML &lt;base> especifica la dirección URL base que se utilizará para todas las direcciones URL relativas contenidas dentro de un documento.  Sólo puede haber un elemento &lt;base> en un documento."><code>&lt;base&gt;</code></a></td>
   <td>Define la URL base para las URLs relativas en la página.</td>
  </tr>
  <tr>
   <td><a href="/es/docs/Web/HTML/Elemento/link" title="El elemento HTML &lt;link> especifica la relación entre el documento actual y un recurso externo. Los usos posibles de este elemento incluyen la definición de un marco relacional para navegación. Este elemento es más frecuentemente usado para enlazar hojas de estilos."><code>&lt;link&gt;</code></a></td>
   <td>Usada para enlazar JavaScript y CSS externos con el documento HTML actual.</td>
  </tr>
  <tr>
   <td><a href="/es/docs/Web/HTML/Elemento/meta" title='meta de "metainformation" - metainformación. Sirve para aportar información sobre el documento..'><code>&lt;meta&gt;</code></a></td>
   <td>Define los metadatos que no pueden ser definidos usando otro elemento HTML.</td>
  </tr>
  <tr>
   <td><a href="/es/docs/Web/HTML/Elemento/style" title="style - estilo. Es el elemento encargado de indicar la información de estilo."><code>&lt;style&gt;</code></a></td>
   <td>Etiqueta de estilo usada para escribir CSS en línea.</td>
  </tr>
 </tbody>
</table>-->
 
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
          
          <th style="vertical-align: inherit; background-color: white;"><b><span

                style="color: #ff6600;"><button>Agregar a reserva</button><br>
              </span></b></th>
            
        </tr>
    <% } %>
      </tbody>
        
    </table>
     <button>Reservar</button>
 
  </body>
  
  </html>