package controller;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ClaseDAO;
import dao.ProfesorDAO;
import hibernate.hibernateUtil;
import negocio.Clase;
import negocio.Profesor;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d=Calendar.getInstance().getTime();
		Profesor p=new Profesor("23803","pepe","pepe@uade","234234242","domicilio",d,"123","domicilio clase",3f);
		Clase c =new Clase(12,34f,"soy el estado",p);
		c.agregarProfesor(p);
		//ProfesorDAO.getInstancia().agregarProfesor(p);
		ClaseDAO.getInstancia().agregarClase(c);
		System.exit(0);

	}

}
