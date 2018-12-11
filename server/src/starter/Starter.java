package starter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.MateriaDAO;
import dao.ProfesorDAO;
import negocio.Clase;
import negocio.Materia;
import negocio.Profesor;
import server.Server;

public class Starter
{

	public static void main(String[] args)
	{
		new Server();
		Materia m= new Materia("Lengua",1);
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
		Profesor p=new Profesor("23803","pepe","pepe@uade","234234242","domicilio",d,"123","domicilio clase",3f);
		Clase c =new Clase(2,34f,"Libre",p);
		c.agregarProfesor(p);
		ProfesorDAO.getInstancia().agregarProfesor(p);
		ArrayList <Materia> materias=new ArrayList<Materia>();
		materias.add(m);
		materias.add(m2);
		materias.add(m3);
		materias.add(m4);
		materias.add(m5);
		p.setMaterias(materias);
		ProfesorDAO.getInstancia().agregarMateriaDisponible(p);
	}
}
