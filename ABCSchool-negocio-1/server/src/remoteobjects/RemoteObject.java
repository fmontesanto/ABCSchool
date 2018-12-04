package remoteobjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import controller.Controlador;
import dto.AlumnoDTO;
import dto.ProfesorDTO;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import excepciones.ProfesorException;
import interfaces.IRemota;

public class RemoteObject extends UnicastRemoteObject implements IRemota {

	private static final long serialVersionUID = 1L;

	public RemoteObject() throws RemoteException {
		super();
	}

	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password) throws RemoteException{
		try {
			Controlador.getInstancia().altaAlumno(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
	}

	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password) throws RemoteException {
		try {
			Controlador.getInstancia().modificarAlumno(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (AlumnoException e) {
			e.printStackTrace();
		}
	}

	public void bajaAlumno(String dni) throws RemoteException {
		Controlador.getInstancia().bajaAlumno(dni);
	}

	public AlumnoDTO buscarAlumno(String dni) throws RemoteException {
		return Controlador.getInstancia().buscarAlumno(dni).toDTO();
	}

	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, String domicilioClases, float anticipacion) throws RemoteException {
		try {
			Controlador.getInstancia().altaProfesor(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password, domicilioClases, anticipacion);
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (ProfesorException e) {
			e.printStackTrace();
		}
	}

	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, String domicilioClases, float anticipacion) throws RemoteException {
		try {
			Controlador.getInstancia().modificarProfesor(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password, domicilioClases, anticipacion);
		} catch (ConnectionException e) {
			e.printStackTrace();
		} catch (ProfesorException e) {
			e.printStackTrace();
		}
		
	}

	public void bajaProfesor(String dni) throws RemoteException {
		Controlador.getInstancia().bajaProfesor(dni);
	}

	public ProfesorDTO buscarProfesor(String dni) throws RemoteException {
		return Controlador.getInstancia().buscarProfesor(dni).toDTO();
	}
}