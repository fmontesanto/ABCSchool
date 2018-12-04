package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ProfesorEntity;
import entities.ResenaEntity;
import hibernate.hibernateUtil;
import negocio.Resena;

public class ResenaDAO {
	
	private static ResenaDAO instancia;

	private ResenaDAO(){ }

	public static ResenaDAO getInstancia(){
		if(instancia == null){
			instancia = new ResenaDAO();
		}
		return instancia;
	}

	public ResenaEntity findByCode(Integer idResena)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ResenaEntity r = (ResenaEntity) session.createQuery("from ResenaEntity where idResena = ?").setParameter(0, idResena).uniqueResult();
		session.close();
		return r;
	}

	public void agregarResena(Resena r)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ResenaEntity re=(ResenaEntity)session.createQuery("from ResenaEntity where idResena = ?").setParameter(0, r.getIdResena()).uniqueResult();
		int flag=0;
		if(re!=null) 
			System.out.println("Resena ya existente con ese id");
		else
		{
			ProfesorEntity p = ProfesorDAO.getInstancia().findByDni(r.getProfesor().getDni());
			if(p==null)
				flag=1;	
			else
				re=new ResenaEntity(r.getPuntuacion(), r.getComentario(), p);
		}
		session.beginTransaction();
		if(flag==0)
			session.save(re);
		session.getTransaction().commit();
		session.close();
	}
}
