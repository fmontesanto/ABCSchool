package com.Controller;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Hibernate.hibernateUtil;
import dao.UsuarioDao;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import excepciones.ProfesorException;
import excepciones.UsuarioException;
import negocio.Alumno;
import negocio.Profesor;
import negocio.Usuario;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.close();

	}
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException,AlumnoException{
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
	}

}
