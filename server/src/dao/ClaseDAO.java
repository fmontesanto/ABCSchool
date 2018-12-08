package dao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClaseEntity;
import entities.MateriaEntity;
import entities.ProfesorEntity;
import hibernate.hibernateUtil;
import negocio.Clase;

public class ClaseDAO {

	private static ClaseDAO instancia;

	private ClaseDAO(){ }

	public static ClaseDAO getInstancia(){
		if(instancia == null){
			instancia = new ClaseDAO();
		}
		return instancia;
	}

	public ClaseEntity findByCode(Integer idClase)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity cl = (ClaseEntity) session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, idClase).uniqueResult();
		session.close();
		return cl;
	}
	
	public List<ClaseEntity> findBySubject(Integer idMateria)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		List<ClaseEntity> result = null;
		Query   q = session.createQuery("from ClaseEntity where idMateria = ?").setParameter(0, idMateria);
		result = (List<ClaseEntity>) q.list();
		session.close();
		return result;
	}
	

	public void agregarClase(Clase cl)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity c=(ClaseEntity)session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, cl.getNumero()).uniqueResult();
		int flag=0;
		if(c!=null) 
			System.out.println("Clase ya existente con ese id");
		else
		{
			ProfesorEntity p = ProfesorDAO.getInstancia().findByDni(cl.getProfesor().getDni());
			if(p==null)
				flag=1;	
			else
				c=new ClaseEntity(cl.getHorario(), cl.getEstado(), p, cl.getFecha());
		}
		session.beginTransaction();
		if(flag==0)
			session.save(c);
		session.getTransaction().commit();
		session.close();
	}


	public void borrarClase(Integer idClase)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity c=(ClaseEntity)session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, idClase).uniqueResult();
		if(c==null) 
		{
			System.out.println("No existe Clase con ese id");
		}
		else
		{
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
		}
		session.close();
	}

	public void modificarClase(Clase cl)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity c=(ClaseEntity)session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, cl.getNumero()).uniqueResult();
		if(c==null)
			System.out.println("Clase con ese id no existe");
		else
		{
			if(!cl.getEstado().equals(c.getEstado()))
				c.setEstado(cl.getEstado());

			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
		}
		session.close();

	}
	public void agregarMateria(Clase cl)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity c=(ClaseEntity)session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, cl.getNumero()).uniqueResult();
		if(c==null)
			System.out.println("Clase con ese id no existe");
		else
		{
			MateriaEntity m=(MateriaEntity)MateriaDAO.getInstancia().findByCode(cl.getMateria().getIdMateria());
			if(m!=null)
				c.setMateria(m);
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
		}
		session.close();
	}
	public ArrayList<ClaseEntity> findByTeacher(String dni){
		int id = -1;
		id = ProfesorDAO.getInstancia().findByDni(dni).getIdUsuario();
		if(id != -1){
			SessionFactory sf = hibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			ArrayList<ClaseEntity> result = null;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date today = Calendar.getInstance().getTime();        
			String d = df.format(today);
			Query   q = session.createQuery("from ClaseEntity where idUsuario = ? and fecha >= ? ").setParameter(0, id).setParameter(1, d);
			result = (ArrayList<ClaseEntity>) q.list();
			session.close();
			return result;
		}
		else 
			return null;
	}
}
