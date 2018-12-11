package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.AlumnoDAO;
import dao.ClaseDAO;
import dao.FacturaDAO;
import dao.ProfesorDAO;
import dao.ReservaDAO;
import entities.AlumnoEntity;
import entities.ClaseEntity;
import entities.FacturaEntity;
import entities.ProfesorEntity;
import entities.ReservaEntity;
import negocio.Alumno;
import negocio.Clase;
import negocio.Factura;
import negocio.Materia;
import negocio.Profesor;
import negocio.Reserva;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=Calendar.getInstance().getTime();
		Profesor p=new Profesor("23803","pepe","pepe@uade","234234242","domicilio",d,"123","domicilio clase",3f);
		Clase c =new Clase(2,34f,"Libre",p);
		c.agregarProfesor(p);
		ProfesorDAO.getInstancia().agregarProfesor(p);
		//ClaseDAO.getInstancia().modificarClase(c);
		//ClaseDAO.getInstancia().agregarClase(c);
		//Alumno a=new Alumno("1","pepe","pepe@uade","234234242","domicilio",d,"123");
		//Reserva r = new Reserva(5, 57f, 2000f, 1, false, d, a);
		//r.addClases(c);
		//Factura f= new Factura(d,35f,"tipo a","remitente ","medio de pago",123,r);
		//AlumnoDAO.getInstancia().agregarAlumno(a);
		//ReservaDAO.getInstancia().agregarReserva(r);
		//ReservaDAO.getInstancia().cancelarReserva(1);
		/*List<ClaseEntity> c = ClaseDAO.getInstancia().findBySubject(1);
		for(ClaseEntity cl : c)
			System.out.println(cl.getIdClase());*/
		//AlumnoEntity a=AlumnoDAO.getInstancia().findByDni("23832303");
		//Alumno al=new Alumno (a.getDni(),a.getNombre(),a.getMail(),a.getTelefono(),a.getDomicilio(),a.getFechaNacimiento(),a.getContra(),a.getSaldoAFavor());
		//ReservaEntity r = ReservaDAO.getInstancia().findById(10);
		//Reserva re = new Reserva(r.getIdReserva(), r.getDescuento(), r.getMonto(), r.getCantAlum(), r.isPaga(), r.getFecha(), al);
		//ClaseEntity c = ClaseDAO.getInstancia().findByCode(1);
		//ProfesorEntity p = ProfesorDAO.getInstancia().findByDni("23803");
		//Profesor pr = new Profesor(p.getDni(), p.getNombre(), p.getMail(), p.getTelefono(), p.getDomicilio(), p.getFechaNacimiento(), p.getContra(), p.getDomicilioClases(), p.getAnticipacionReserva());
		//Materia m = new Materia("Matematica", 1);
		//Clase clase = new Clase(m, c.getHorario(), c.getEstado(), c.getIdClase(), pr, re);
		//re.addClases(clase);
		//FacturaEntity f=FacturaDAO.getInstancia().findByCode(1);
		//Factura fe= new Factura(f.getFecha(),f.getMonto(),f.getTipo(),f.getRemitente(),f.getMedioPago(),f.getNroFactura(), re);
		//ReservaDAO.getInstancia().completarReserva(re);
		
		
		//Obtener clases disponibles
		/*ArrayList<Clase> clases = Controlador.getInstancia().obtenerClasesProfesor("40");
		for(Clase cl : clases){
			System.out.println(cl.getIdClase());
		}
		System.exit(0);
		*/

	}
}
