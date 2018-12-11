package delegates;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import javax.naming.CommunicationException;

import dto.AlumnoDTO;
import dto.ClaseDTO;
import dto.ProfesorDTO;
import dto.ResenaDTO;
import dto.ReservaDTO;
import excepciones.ComunicacionException;
import excepciones.ConnectionException;
import interfaces.IRemota;
import negocio.Alumno;
import negocio.Materia;
import negocio.Profesor;
import negocio.Reserva;
import remoteobjects.FacturaDTO;

public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private IRemota remota;
	
	public static BusinessDelegate getInstancia() throws ComunicacionException{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	private BusinessDelegate() throws ComunicacionException {
		try {
			remota = (IRemota)Naming.lookup("rmi://localhost/Abc");
		} catch (MalformedURLException e) {
			throw new ComunicacionException("La direcci�n del servidor es incorrecta");
		} catch (RemoteException e) {
			throw new ComunicacionException("La conecci�n con el servidor es incorrecta");
		} catch (NotBoundException e) {
			throw new ComunicacionException("Error en el acceso al servidor");	
		}
	}
	
	public boolean logIn (String dni, String password, int codigo) throws ComunicacionException {
		try {
			 return remota.logIn(dni, password, codigo);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
	}
	}
	
	public void altaAlumno(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password) throws ComunicacionException{
		try {
			remota.altaAlumno(dni,nombre,mail,telefono,domicilio,fechaNacimiento,password);
		}catch (RemoteException e) {
			throw new ComunicacionException ("Error en la conexion");	
		}
	}
	
	public void modificarAlumno(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password) throws ComunicacionException {
		try {
			remota.modificarAlumno(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void bajaAlumno(String dni) throws ComunicacionException{
		try {
			remota.bajaAlumno(dni);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public Alumno buscarAlumno(String dni) throws ComunicacionException{
		try {
			return remota.buscarAlumno(dni);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}

	public void altaProfesor(String dni, String nombre, String mail, String telefono, String domicilio,
		Date fechaNacimiento, String password, String domicilioClases, float anticipacion) throws ComunicacionException{
		try {
			remota.altaProfesor(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password, domicilioClases, anticipacion);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void modificarProfesor(String dni, String nombre, String mail, String telefono, String domicilio,
			Date fechaNacimiento, String password, String domicilioClases, float anticipacion) throws ComunicacionExcepcion{
		try {
			remota.modificarProfesor(dni, nombre, mail, telefono, domicilio, fechaNacimiento, password, domicilioClases, anticipacion);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void bajaProfesor(String dni) throws ComunicacionException{
		try {
			remota.bajaProfesor(dni);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	public Profesor buscarProfesor(String dni) throws ComunicacionException{
		try {
			return remota.buscarProfesor(dni);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void altaClase(String materia,Date fecha, float horaInicio, float horaFin, String estado,String dniProfesor) throws ComunicacionException, ConnectionException{
		try {
			remota.altaClase(materia, fecha, horaInicio, horaFin, estado, dniProfesor);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public Materia buscarMateria(String nombre) throws ComunicacionException{
		try{
			return remota.buscarMateria(nombre);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void altaMateria(String nombreMat)throws ComunicacionException{
		try {
			remota.altaMateria(nombreMat);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public Reserva buscarReserva(int idReserva)throws ComunicacionException{
		try {
			return remota.buscarReserva(idReserva);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void altaReserva(Integer idReserva, Float descuento, Float monto, Integer cantAlum, boolean paga,
			Date fecha, String dniAlumno,ArrayList<String> clases) throws ComunicacionException{
		try {
			remota.altaReserva(idReserva, descuento, monto, cantAlum, paga, fecha, dniAlumno, clases);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void bajaReserva(int idReserva)throws ComunicacionException{
		try {
			remota.bajaReserva(idReserva);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public void generarFactura(int idReserva, String tipo, String remitente, String medioPago) throws ComunicacionException{
		try {
			remota.generarFactura(idReserva, tipo, remitente, medioPago);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public ArrayList<ClaseDTO> verClasesDisponibles() throws ComunicacionException{
		try {
			return remota.verClasesDisponibles();
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public ArrayList<ReservaDTO>  obtenerReservasAlumno(String dniAlumno) throws ComunicacionException{
		try {
			return remota.obtenerReservasAlumno(dniAlumno);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public ArrayList<ClaseDTO> obtenerClaseProfesor(String dniProf) throws ComunicacionException{
		try {
			return remota.obtenerClaseProfesor(dniProf);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public ArrayList<ResenaDTO> obtenerResenasProfesor(String dniProfesor) throws ComunicacionException{
		try {
			return remota.obtenerResenasProfesor(dniProfesor);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
	public ProfesorDTO obtenerProfesorDTO (String dniProf) throws ComunicacionException{
		try {
			return remota.obtenerProfesorDTO(dniProf);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
	}
	
	public AlumnoDTO obtenerAlumnoDTO(String dniAlumno) throws ComunicacionException{
		try {
			return remota.obtenerAlumnoDTO(dniAlumno);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	public FacturaDTO buscarFactura(int idReserva) throws ComunicacionException{
		try {
			return remota.buscarFactura(idReserva);
		}catch (RemoteException e) {
			throw new ComunicacionException("Error en la conexion");
		}
	}
	
}
