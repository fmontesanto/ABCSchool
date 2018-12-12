package controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import antlr.collections.List;
import dao.AlumnoDAO;
import dao.ClaseDAO;
import dao.FacturaDAO;
import dao.MateriaDAO;
import dao.ProfesorDAO;
import dao.ResenaDAO;
import dao.ReservaDAO;
import entities.ClaseEntity;
import entities.MateriaEntity;
import entities.ResenaEntity;
import entities.ReservaEntity;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import negocio.Alumno;
import negocio.Clase;
import negocio.Factura;
import negocio.Materia;
import excepciones.ProfesorException;
import negocio.Profesor;
import negocio.Resena;
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
	
	public void altaClase(String materia,Date fecha,float horario, String estado,String dniProfesor) {
		Profesor profesor=buscarProfesor(dniProfesor);
		Materia mat=MateriaDAO.getInstancia().findByName(materia).toMateria();
		Clase clase=new Clase(mat,fecha,horario,estado,0,profesor);
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
		Reserva reserva=buscarReserva(idReserva);
		Date fechaActual=new java.sql.Date(Calendar.getInstance().getTime().getTime());
		reserva.generarFactura(fechaActual, tipo, remitente,medioPago);
	}
	public boolean logIn(String dni,String password, int codigo){
		switch (codigo) {
		case 1:
			Alumno alumno=buscarAlumno(dni);
			if (alumno!=null && password.equals(alumno.getContra())) 
				return true;
			else
				return false;
		case 2: 
			Profesor profesor=buscarProfesor(dni);
			if (profesor!=null && password.equals(profesor.getContra())) 
				return true;
			else
				return false;
		default: 
			return false;
		}
	}

	public ArrayList<Clase> verClasesDisponibles() { 
		ArrayList<ClaseEntity> clases=ClaseDAO.getInstancia().findAvailable();
		ArrayList<Clase> clases2= new ArrayList<Clase>();
		for(ClaseEntity c: clases){
			clases2.add(c.toClase());
		}
		return clases2;
	}
	
	
	public ArrayList<Reserva> obtenerReservasAlumno (String dniAlumno) { 		
		ArrayList<ReservaEntity> res = ReservaDAO.getInstancia().findByStudent(dniAlumno);
		return toReservas(res);
	}
	
	public ArrayList<Reserva> toReservas(ArrayList<ReservaEntity> reservas){
		ArrayList<Reserva> res = new ArrayList<Reserva>();
		for(ReservaEntity r : reservas){
			res.add(r.toReserva());
		}
		return res;
	}
	public ArrayList<Clase> obtenerClasesProfesor(String dniProf){
		ArrayList<ClaseEntity> clas = ClaseDAO.getInstancia().findByTeacher(dniProf);
		return toClases(clas);
	}		
	public void anadirResena(String dniProf,float puntuacion, String comentario) { 
		Profesor profesor=ProfesorDAO.getInstancia().findByDni(dniProf).toProfesor();
		Resena resena=new Resena(puntuacion,comentario,profesor);
		resena.save();
		profesor.agregarResena(puntuacion,comentario);
		profesor.calcularPuntuacion();
		profesor.update();
	}
	public ArrayList<Resena> obtenerResenasProfesor(String dniProfesor) {
		ArrayList<ResenaEntity> res = ResenaDAO.getInstancia().findByTeacher(dniProfesor);
		return toResenas(res);
	}		

	public ArrayList<Clase> toClases(ArrayList<ClaseEntity> clases){
		ArrayList<Clase> cla = new ArrayList<Clase>();
		for(ClaseEntity c : clases){
			cla.add(c.toClase());
		}
		return cla;
	}		

	public ArrayList<Resena> toResenas(ArrayList<ResenaEntity> resenas){
		ArrayList<Resena> res = new ArrayList<Resena>();
		for(ResenaEntity r : resenas){
			res.add(r.toResena());
		}
		return res;
	}
	public ArrayList<Materia> toMaterias (ArrayList<MateriaEntity> m){
		ArrayList<Materia> m2=new ArrayList<Materia>();
		for (MateriaEntity me:m) {
			m2.add(me.toMateria());
		}
	return m2;
	}

	public ArrayList<Materia> obtenerMateriasProfesor(int idUsuario){
	ArrayList<MateriaEntity> m=MateriaDAO.getInstancia().findByTeacher(idUsuario);
	return toMaterias(m);
	}
	
	public Factura buscarFactura(int idReserva) {
		Reserva reserva=buscarReserva(idReserva);
		Factura factura=FacturaDAO.findByReserva(idReserva).toFactura();
		return factura;
	}

	public ArrayList<Materia> obtenerMaterias(){
		ArrayList<MateriaEntity> materias = MateriaDAO.getInstancia().findAllSubjects();
		return toMaterias(materias);
	}
	
	public ArrayList<Clase> obtenerClasesReserva(int idReserva){
		ArrayList<ClaseEntity> clases = ClaseDAO.getInstancia().findByReservation(idReserva);
		return toClases(clases);
	}
}

