package controller;


import dao.AlumnoDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import dao.ClaseDAO;
import dao.FacturaDAO;
import dao.MateriaDAO;
import dao.ProfesorDAO;
import dao.ReservaDAO;
import entities.ClaseEntity;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import excepciones.ProfesorException;
import negocio.Alumno;
import negocio.Profesor;
import negocio.Reserva;
import hibernate.hibernateUtil;
import negocio.Clase;
import negocio.Factura;
import negocio.Materia;
import negocio.Profesor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password) throws ConnectionException,AlumnoException{
		Alumno alumno=new Alumno(dni,nombre,mail,telefono,domicilio,fechaNacimiento,password);
		alumno.save();
	}
	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento, String password) throws ConnectionException, AlumnoException {
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
		//alumno.delete();
	}
	private Alumno buscarAlumno(String dni) {
		Alumno alumno=AlumnoDAO.getInstancia().findByDni(dni);
	}
	
	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion) throws ConnectionException,ProfesorException{
		Profesor profesor=new Profesor(domicilioClases, domicilioClases, domicilioClases, domicilioClases, domicilioClases, fechaNacimiento, domicilioClases, domicilioClases, anticipacion);
		profesor.save();
	}
	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio, Date fechaNacimiento,String password, String domicilioClases,float anticipacion)throws ConnectionException,ProfesorException {
		Profesor profesor=buscarProfesor(dni);
		profesor.setNombre(nombre);
		profesor.setTelefono(telefono);
		profesor.setMail(mail);
		profesor.setDomicilio(domicilio);
		profesor.setDomicilioClases(domicilioClases);
		profesor.setFechaNacimiento(fechaNacimiento);
		profesor.setContra(password);
		profesor.setAnticipacionReserva(anticipacion);
		profesor.update();
	}
	public void bajaProfesor(String dni) {
		Profesor profesor=buscarProfesor(dni);
		profesor.delete();
		
	}
	private Profesor buscarProfesor(String dni) {
		try {
			Profesor profesor=ProfesorDAO.getInstancia().findByDni(dni);
		} catch (ConnectionException | ProfesorException e) {
			e.printStackTrace();
		}
		return profesor;
	}
	public void altaClase (String materia, Date fecha, float horaInicio, float horaFin, String estado, int numero, String dniProfesor){
		Materia mat=buscarMateriaXnombre(materia);
		Profesor prof=buscarProfesor(dniProfesor;)
		Clase clase=new Clase(mat,fecha,horaInicio,horaFin,estado,numero,prof);
		clase.save();
	}
	private Materia buscarMateriaXnombre(String materia) {
		Materia materia=MateriaDAO.getInstancia().findByName(materia);
		return materia;
	}
	
	private Clase buscarClase (int numero) {
		Clase clase=ClaseDAO.getInstancia().findByCode(numero);
		return clase;
	}
	public List<Clase> buscarClaseXmateria(String nombreMateria){
		Materia materia=buscarMateriaXnombre(nombreMateria);
		List<Clase> clases=ClaseDAO.getInstancia().findBySubject(materia.getIdMateria());
		return clases;	
	}
	private Factura buscarFactura(int numero) {
		Factura factura=FacturaDAO.getInstancia().findByCode(numero);
		return factura;
	}
	private Reserva buscarReserva(int numero) {
		Reserva reserva=ReservaDAO.getInstancia().findById(numero);
		return reserva;
	}
	public List<Clase>verClasesDisponibles(String materia) {
		List<Clase> clases=buscarClaseXmateria(materia);
		List<Clase> clasesDisponibles=new ArrayList<Clase>();
		for(int i=0;i<clases.size();i++) {
			if (clases.get(i).getEstado()=="disponible") {
				clasesDisponibles.add(clases.get(i));
			}
		}
		return clasesDisponibles;
	}
	
}
