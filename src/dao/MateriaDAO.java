package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClaseEntity;
import entities.MateriaEntity;
import entities.ProfesorEntity;
import hibernate.hibernateUtil;
import negocio.Clase;
import negocio.Materia;
import negocio.Profesor;

public class MateriaDAO {

	private static MateriaDAO instancia;

	private MateriaDAO(){ }

	public static MateriaDAO getInstancia(){
		if(instancia == null){
			instancia = new MateriaDAO();
		}
		return instancia;
	}

	public MateriaEntity findByCode(Integer idMateria)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MateriaEntity m = (MateriaEntity) session.createQuery("from MateriaEntity where idMateria = ?").setParameter(0, idMateria).uniqueResult();
		session.close();
		return m;
	}

	public void agregarMateria(Materia m) //CHEQUEAR
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MateriaEntity me=(MateriaEntity)session.createQuery("from MateriaEntity where idMateria = ?").setParameter(0, m.getIdMateria()).uniqueResult();
		int flag=0;
		if(me!=null) 
			System.out.println("Materia ya existente con ese id");
		else
		{
			List<ClaseEntity> clases = new ArrayList<ClaseEntity>();
			Set<ProfesorEntity> profesores = new HashSet<ProfesorEntity>();
			for(Clase c : m.getClases()){
				clases.add(ClaseDAO.getInstancia().findByCode(c.getNumero()));
			}
			for(Profesor p : m.getProfesores()){
				profesores.add(ProfesorDAO.getInstancia().findByDni(p.getDni()));
			}
			
			if(clases == null || profesores == null)
				flag=1;	
			else
				me=new MateriaEntity(m.getNombre(), clases, profesores);
		}
		session.beginTransaction();
		if(flag==0)
			session.save(me);
		session.getTransaction().commit();
		session.close();
	}
}
