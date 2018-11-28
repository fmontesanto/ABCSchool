package controller;

import hibernate.hibernateUtil;

import java.util.Date;


import java.util.Calendar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.AlumnoDAO;
import delegates.BusinessDelegate;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import interfaces.IRemota;
import negocio.Alumno;

import dao.ClaseDAO;
import dao.ProfesorDAO;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import excepciones.ProfesorException;
import negocio.Alumno;
import negocio.Profesor;
import hibernate.hibernateUtil;
import negocio.Clase;
import negocio.Profesor;
import negocio.Usuario;

public class Controlador {
	
	private static Controlador instancia;
	
	public static Controlador getInstancia(){
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	public static void main(String[] args) {}
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException,AlumnoException{
		Alumno a =new Alumno(dni,nombre,mail,telefono,domicilio,fechaNacimiento,password);
		AlumnoDAO.getInstancia().agregarAlumno(a);
	}
	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException, AlumnoException {
		Alumno alumno=buscarAlumno(dni);
		alumno.setNombre(nombre);
		alumno.setMail(mail);
		alumno.setTelefono(telefono);
		alumno.setFechaNacimiento(fechaNacimiento);
		alumno.setContra(password);
		AlumnoDAO.getInstancia().modificarAlumno(alumno);
	}
	
	public void bajaAlumno(String dni){
		Alumno alumno=buscarAlumno(dni);
		AlumnoDAO.getInstancia().bajaAlumno(alumno);
	}
	
	public Alumno buscarAlumno(String dni) {
		Alumno alumno=AlumnoDAO.getInstancia().findByDni(dni).toAlumno();
		return alumno;
	}
	
	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion) throws ConnectionException,ProfesorException{
		Profesor profesor=new Profesor(domicilioClases, domicilioClases, domicilioClases, domicilioClases, domicilioClases, fechaNacimiento, domicilioClases, domicilioClases, anticipacion);
		//profesor.save();
	}
	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion)throws ConnectionException,ProfesorException {
		Profesor profesor=buscarProfesor(dni);
	}
	public void bajaProfesor(String dni) {
		Profesor profesor=buscarProfesor(dni);
		//profesor.delete();
		
	}
	public Profesor buscarProfesor(String dni) {
		Profesor profesor=ProfesorDAO.getInstancia().findByDni(dni).toProfesor();
		return profesor;
	}
	
/*	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException,AlumnoException{
		Alumno alumno=new Alumno(dni,nombre,mail,telefono,domicilio,fechaNacimiento,password);
		//alumno.save();
	}
	
	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException, AlumnoException {
		Alumno alumno=buscarAlumno(dni);
		alumno.setNombre(nombre);
		alumno.setMail(mail);
		alumno.setTelefono(telefono);
		alumno.setFechaNacimiento(fechaNacimiento);
		alumno.setPassword(password);
		//alumno.update();
	}
	public void bajaAlumno(String dni){
		Alumno alumno=buscarAlumno(dni);
		//alumno.delete();
	}
	private Alumno buscarAlumno(String dni) {
		try {
			Alumno alumno=AlumnoDao.getInstance().buscarAlumno(dni);
		} catch (ConnectionException | AlumnoException e) {
			e.printStackTrace();
		}
		return alumno;
	}
	
	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion) throws ConnectionException,ProfesorException{
		Profesor profesor=new Profesor(domicilioClases, domicilioClases, domicilioClases, domicilioClases, domicilioClases, fechaNacimiento, domicilioClases, domicilioClases, anticipacion);
		//profesor.save();
	}
	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion)throws ConnectionException,ProfesorException {
		Profesor profesor=buscarProfesor(dni);
	}
	public void bajaProfesor(String dni) {
		Profesor profesor=buscarProfesor(dni);
		//profesor.delete();
		
	}
	
	private Profesor buscarProfesor(String dni) {
		try {
			Profesor alumno=ProfesorDao.getInstance().buscarAlumno(dni);
		} catch (ConnectionException | ProfesorException e) {
			e.printStackTrace();
		}
		return profesor;
	}*/

}
