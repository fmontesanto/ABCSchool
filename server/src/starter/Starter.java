package starter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.sun.jmx.snmp.daemon.CommunicationException;

import dao.AlumnoDAO;
import dao.ClaseDAO;
import dao.MateriaDAO;
import dao.ProfesorDAO;
import dao.ReservaDAO;
import delegates.BusinessDelegate;
import negocio.Alumno;
import negocio.Clase;
import negocio.Materia;
import negocio.Profesor;
import negocio.Reserva;
import server.Server;

public class Starter
{

	public static void main(String[] args)
	{
		new Server();
		/*Materia m= new Materia("Lengua",1);
		Materia m2= new Materia("Matematica",2);
		Materia m3= new Materia("Fisica",3);
		Materia m4= new Materia("Programacion",4);
		Materia m5= new Materia("Latin",5);
		MateriaDAO.getInstancia().agregarMateria(m);
		MateriaDAO.getInstancia().agregarMateria(m2);
		MateriaDAO.getInstancia().agregarMateria(m3);
		MateriaDAO.getInstancia().agregarMateria(m4);
		MateriaDAO.getInstancia().agregarMateria(m5);
		Date d=Calendar.getInstance().getTime();
		Alumno a=new Alumno("1","pepe","pepe@uade","234234242","domicilio",d,"123");
		AlumnoDAO.getInstancia().agregarAlumno(a);
		Profesor p=new Profesor("23803","pepe","pepe@uade","234234242","domicilio",d,"123","domicilio clase",3f);
		Clase c =new Clase(2,34f,"Libre",p);
		c.agregarProfesor(p);
		ProfesorDAO.getInstancia().agregarProfesor(p);
		Reserva r = new Reserva(1, 0f, 400f, 1, false, d, a);
		r.addClase(c);
		ReservaDAO.getInstancia().agregarReserva(r);
		ArrayList <Materia> materias=new ArrayList<Materia>();
		materias.add(m);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		materias.add(m5);
		p.setMaterias(materias);
		ProfesorDAO.getInstancia().agregarMateriaDisponible(p);
		/*try {
           BusinessDelegate.getInstancia().obtenerReservasAlumno("1");
        } catch (CommunicationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (javax.naming.CommunicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
