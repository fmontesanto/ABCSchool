/*
var btnMenu = document.getElementById('btn-menu');
var nav = document.getElementById('nav');

btnMenu.addEventListener('click', function () { //cuando hago click, a nav se le agrega clase mostrar
  nav.classList.toggle('mostrar');
});
*/

function validar(){
  if(!document.formulario.usr.value.length){
    alert("Completar nombre de usuario");
  }
  else if(!document.formulario.clave.value.length){
    alert("Completar contraseña");
  }
  else{
    var selectedValue = document.getElementById("log").value;
    switch(selectedValue){
           case "alumno":
           //window.open("http://127.0.0.1:49923/Alumno/index.html");
        	//llamar al BusinessDelegate   
        break;
          case "profesor":
            //window.open("http://127.0.0.1:49708/Profesor/index.html");
        	//llamar al BusinessDelegate  
        break;
          //case "admin":
    }
  }
}