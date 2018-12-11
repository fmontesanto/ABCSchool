package starter;

import dao.MateriaDAO;
import negocio.Materia;
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
	}
}
