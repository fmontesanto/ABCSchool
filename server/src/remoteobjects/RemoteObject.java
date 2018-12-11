package remoteobjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.ArrayList;
import controller.Controlador;
import dto.AlumnoDTO;
import dto.ClaseDTO;
import dto.FacturaDTO;
import dto.MateriaDTO;
import dto.ProfesorDTO;
import dto.ResenaDTO;
import dto.ReservaDTO;
import excepciones.AlumnoException;
import excepciones.ConnectionException;
import excepciones.ProfesorException;
import interfaces.IRemota;
import negocio.Alumno;
import negocio.Clase;
import negocio.Materia;
import negocio.Profesor;
import negocio.Resena;
import negocio.Reserva;

public class RemoteObject extends UnicastRemoteObject implements IRemota {

	private static final long serialVersionUID = 1L;

	public RemoteObject() throws RemoteException {
		super();
	}

	public boolean logIn (String dni, String password, int codigo) throws RemoteException {
		return Controlador.getInstancia().logIn(dni, password, codigo);
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
	public void altaClase(String materia,Date fecha, float horario, String estado,String dniProfesor) throws RemoteException{
		Controlador.getInstancia().altaClase(materia, fecha, horario, estado, dniProfesor);
	}
	public MateriaDTO buscarMateria(String nombre) throws RemoteException {
		return Controlador.getInstancia().buscarMateria(nombre).toDTO();
	}
	public void altaMateria(String nombreMat)throws RemoteException {
		Controlador.getInstancia().altaMateria(nombreMat);
	}
	public ReservaDTO buscarReserva(int idReserva)throws RemoteException{
		return Controlador.getInstancia().buscarReserva(idReserva).toDTO();
	}
	public void altaReserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga,
			Date fecha, String dniAlumno,ArrayList<String> clases) throws RemoteException{
		Controlador.getInstancia().altaReserva(idReserva, descuento, monto, cantAlum, paga, fecha, dniAlumno, clases);
	}
	public void bajaReserva(int idReserva)throws RemoteException{
		Controlador.getInstancia().bajaReserva(idReserva);
	}
	public void generarFactura(int idReserva, String tipo, String remitente, String medioPago) throws RemoteException{
		Controlador.getInstancia().generarFactura(idReserva, tipo, remitente, medioPago);
	}
	public ArrayList<ClaseDTO> verClasesDisponibles() throws RemoteException{
		ArrayList<Clase>clases= Controlador.getInstancia().verClasesDisponibles();
		ArrayList<ClaseDTO> clasesDTO=new ArrayList<ClaseDTO>();
		for (Clase clase:clases) {
			clasesDTO.add(clase.DTO());
		}
		return clasesDTO;
	}
	public ArrayList<ReservaDTO>  obtenerReservasAlumno(String dniAlumno) throws RemoteException{
		ArrayList<Reserva>reservas= Controlador.getInstancia().obtenerReservasAlumno(dniAlumno);
		ArrayList<ReservaDTO> reservasDTO=new ArrayList<ReservaDTO>();
		for (Reserva reserva:reservas) {
			reservasDTO.add(reserva.toDTO());
		}
		return reservasDTO;
	}
	public ArrayList<ClaseDTO> obtenerClaseProfesor(String dniProf) throws RemoteException{
		ArrayList<Clase>clases= Controlador.getInstancia().obtenerClasesProfesor(dniProf);
		ArrayList<ClaseDTO> clasesDTO=new ArrayList<ClaseDTO>();
		for (Clase clase:clases) {
			clasesDTO.add(clase.DTO());
		}
		return clasesDTO;
	}
	public ArrayList<ResenaDTO> obtenerResenasProfesor(String dniProfesor) throws RemoteException {
		ArrayList<Resena>resenas= Controlador.getInstancia().obtenerResenasProfesor(dniProfesor);
		ArrayList<ResenaDTO> resenasDTO=new ArrayList<ResenaDTO>();
		for (Resena resena:resenas) {
			resenasDTO.add(resena.toDTO());
		}
		return resenasDTO;
	}
	public ArrayList<MateriaDTO> obtenerMateriasProfesor(int idUsuario) throws RemoteException {
		ArrayList<Materia>materias= Controlador.getInstancia().obtenerMateriasProfesor(idUsuario);
		ArrayList<MateriaDTO> materiasDTO=new ArrayList<MateriaDTO>();
		for (Materia materia:materias) {
			materiasDTO.add(materia.toDTO());
		}
		return materiasDTO;
	}
	public FacturaDTO buscarFactura(int idReserva) throws RemoteException {
		FacturaDTO facturaDto=Controlador.getInstancia().buscarFactura(idReserva).toDTO();
		return facturaDto;
	}
}