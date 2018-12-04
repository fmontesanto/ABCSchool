package controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import antlr.collections.List;
import dao.AlumnoDAO;
import dao.ClaseDAO;
import dao.MateriaDAO;
import dao.ProfesorDAO;
import dao.ReservaDAO;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import negocio.Alumno;
import negocio.Clase;
import negocio.Materia;
import excepciones.ProfesorException;
import negocio.Profesor;
import negocio.Reserva;


public class Controlador {
	
	private static Controlador instancia;
	
	public static Controlador getInstancia(){
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	public static void main(String[] args) {}
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException,AlumnoException{
		Alumno alumno =new Alumno(dni,nombre,mail,telefono,domicilio,fechaNacimiento,password);
		alumno.save();
	}
	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException, AlumnoException {
		Alumno alumno=buscarAlumno(dni);
		alumno.setNombre(nombre);
		alumno.setMail(mail);
		alumno.setTelefono(telefono);
		alumno.setFechaNacimiento(fechaNacimiento);
		alumno.setContra(password);
		alumno.update();
	}
	
	public void bajaAlumno(String dni){
		Alumno alumno=buscarAlumno(dni);
		alumno.delete();
	}
	
	public Alumno buscarAlumno(String dni) {
		Alumno alumno=AlumnoDAO.getInstancia().findByDni(dni).toAlumno();
		return alumno;
	}
	
	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion) throws ConnectionException,ProfesorException{
		Profesor profesor=new Profesor(domicilioClases, domicilioClases, domicilioClases, domicilioClases, domicilioClases, fechaNacimiento, domicilioClases, domicilioClases, anticipacion);
		profesor.save();
	}
	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion)throws ConnectionException,ProfesorException {
		Profesor profesor=buscarProfesor(dni);
		profesor.update();
	}
	public void bajaProfesor(String dni) {
		Profesor profesor=buscarProfesor(dni);
		profesor.delete();
		
	}
	public Profesor buscarProfesor(String dni) {
		Profesor profesor=ProfesorDAO.getInstancia().findByDni(dni).toProfesor();
		return profesor;
	}
	
	public void altaClase(String materia,Date fecha, float horaInicio, float horaFin, String estado,String dniProfesor) {
		Profesor profesor=buscarProfesor(dniProfesor);
		Materia mat=MateriaDAO.getInstancia().findByName(materia).toMateria();
		Clase clase=new Clase(mat,fecha,horaInicio,horaFin,estado,0,profesor);
		clase.save();
	}
	public Materia buscarMateria(String nombre) {
		Materia materia=MateriaDAO.getInstancia().findByName(nombre).toMateria();
		return materia;
	}
	public void altaMateria(String nombreMat) {
		Materia materia=buscarMateria(nombreMat);
		if (materia==null) {
			materia=new Materia(nombreMat,0);
			materia.save();
		}
	}
	public Reserva buscarReserva(int idReserva) {
		Reserva reserva=ReservaDAO.getInstancia().findById(idReserva).toReserva();
		return reserva;
	}
	public void altaReserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga,
			Date fecha, String dniAlumno,ArrayList<String> clases) {
		Alumno alumno = buscarAlumno(dniAlumno);
		Reserva reserva=new Reserva(0,descuento,monto,cantAlum,paga,fecha,alumno);
		for (String idClase:clases) {
			Clase clase=ClaseDAO.getInstancia().findByCode(Integer.valueOf(idClase)).toClase(); //falta el toClase
			reserva.addClase(clase);
			//hay que setear el estado de la clase a pendientePago o algo asi y hacer un update (falta update)
		}
		reserva.save();
	}
	public void bajaReserva(int idReserva) {
		Reserva reserva=buscarReserva(idReserva);
		reserva.delete();
	}
	public void generarFactura(int idReserva, String tipo, String remitente, String medioPago) {
		Date fechaActual=new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Reserva reserva=buscarReserva(idReserva);
		//Reserva tiene que crear la factura, es la que posee la reserva, cambiar. 
		Factura factura=new Factura(fechaActual monto, tipo,remitente, medioPago, Integer nroFactura,Reserva reserva);
		
	}
	public boolean logIn() {
		//TODO
	}
	public void verClasesDisponibles() { //devuelve un arrayList de DTO
		//TODO
		//Hay que buscar en las tablas todas las clases con estado disponible. funcion en entity..
		// mucho mas facil que tener que agarrar cada materia y hacer un findBymateria...
	}
	public void verReservas () { //Devuelve arrayList de reservas DTO de un determinado usuario
		//TODO
	}
	public void anadirResena() { //idprof,puntaje,comentario --> busco prof, prof.anadir resena--> actualizar puntuacion prof.
		//TODO	
	}
	public void mostrarResenas() { // devolver arrayList de resenasdto de un determinado prof
		//TODO
	}
	public void mostrarProfesor () {  //Devolver profesorDTO 
		//TODO	
	}
	public void mostrarUsuario () { //Devolver UsuarioDTO 
		//TODO 	
	}
	
}
