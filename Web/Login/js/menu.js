var btnMenu = document.getElementById('btn-menu');
var nav = document.getElementById('nav');

btnMenu.addEventListener('click', function () { /*cuando hago click, a nav se le agrega clase mostrar*/
  nav.classList.toggle('mostrar');
});

function validar(){
  var usuario, contraseña;
  usuario = document.getElementById("usr").nodeValue;
  contraseña = document.getElementById("key").nodeValue;
  
  if(usuario == null)
    alert("copletar usr");
};

