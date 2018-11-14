package controller;

import java.util.Calendar;
import java.util.Date;

import dao.AlumnoDAO;
import dao.ClaseDAO;
import dao.ProfesorDAO;
import dao.ReservaDAO;
import negocio.Alumno;
import negocio.Clase;
import negocio.Factura;
import negocio.Profesor;
import negocio.Reserva;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=Calendar.getInstance().getTime();
		Profesor p=new Profesor("23803","pepe","pepe@uade","234234242","domicilio",d,"123","domicilio clase",3f);
		Clase c =new Clase(1,34f,"soy el estado",p);
		c.agregarProfesor(p);
		//ProfesorDAO.getInstancia().agregarProfesor(p);
		//ClaseDAO.getInstancia().modificarClase(c);
		//ClaseDAO.getInstancia().agregarClase(c);
		Alumno a=new Alumno("23832303","pepe","pepe@uade","234234242","domicilio",d,"123");
		Reserva r = new Reserva(8, 57f, 2000f, 1, false, d, a);
		r.addClases(c);
		//Factura f= new Factura(d,35f,"tipo a","remitente ","medio de pago",123,r);
		//AlumnoDAO.getInstancia().agregarAlumno(a);
		//ReservaDAO.getInstancia().agregarReserva(r);
		ReservaDAO.getInstancia().cancelarReserva(9);
	
		System.exit(0);
		

	}
}
