var btnMenu = document.getElementById('btn-menu');
var nav = document.getElementById('nav');

btnMenu.addEventListener('click', function () { /*cuando hago click, a nav se le agrega clase mostrar*/
  nav.classList.toggle('mostrar');
});

function validar(){
  if(!document.formulario.usr.value.length){
    alert("Completar nombre de usuario");
  }
  else if(!document.formulario.clave.value.length){
    alert("Completar contraseña");
  }
  else{
   window.open("file:///C:/Users/Juli%C3%A1n/Desktop/Todo/Universidad/3er%20a%C3%B1o/Univ.2do%20cuatrimestre%202018/Seminario%20de%20integracion%20profesional%20I/Web/Alumno/idex.html");
  }
  
};

