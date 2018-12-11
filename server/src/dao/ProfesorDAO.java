package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MateriaEntity;
import entities.ProfesorEntity;
import hibernate.hibernateUtil;
import negocio.Materia;
import negocio.Profesor;

public class ProfesorDAO {

	private static ProfesorDAO instancia;

	private ProfesorDAO(){ }

	public static ProfesorDAO getInstancia(){
		if(instancia == null){
			instancia = new ProfesorDAO();
		}
		return instancia;
	}

	public ProfesorEntity findByDni(String dni)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity p = (ProfesorEntity) session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, dni).uniqueResult();
		session.close();
		return p;
	}
	
	public ProfesorEntity findByName(String nombre)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity p = (ProfesorEntity) session.createQuery("from ProfesorEntity where nombre = ?").setParameter(0, nombre).uniqueResult();
		session.close();
		return p;
	}

	public void agregarProfesor(Profesor p)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity pe=(ProfesorEntity)session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, p.getDni()).uniqueResult();
		if(pe!=null) 
			System.out.println("Profesor ya existente con ese dni");
		else
		{
			pe=new ProfesorEntity(p.getDni(), p.getNombre(), p.getMail(), p.getTelefono(), p.getDomicilio(), p.getFechaNacimiento(), p.getContra(), p.getDomicilioClases(), p.getAnticipacionReserva());
		}
		session.beginTransaction();
		session.save(pe);
		session.getTransaction().commit();
		session.close();
	}

	public void borrarPorfesor(String dni)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity p=(ProfesorEntity)session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, dni).uniqueResult();
		if(p==null) 
		{
			System.out.println("No existe Profesor con ese dni");
		}
		else
		{
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
		}
		session.close();
	}

	public void modificarProfesor(Profesor pr)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity p=(ProfesorEntity)session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, pr.getDni()).uniqueResult();
		if(p==null)
			System.out.println("Profesor con ese dni no existe");
		else
		{
			if(!pr.getDomicilio().equals(p.getDomicilio()))
				p.setDomicilio(pr.getDomicilio());
			if(pr.getFechaNacimiento()!=p.getFechaNacimiento())
				p.setFechaNacimiento(pr.getFechaNacimiento());
			if(!pr.getMail().equals(p.getMail()))
				p.setMail(pr.getMail());
			if(!pr.getContra().equals(p.getContra()))
				p.setContra(pr.getContra());
			if(!pr.getDomicilioClases().equals(p.getDomicilioClases()))
				p.setDomicilioClases(pr.getDomicilioClases());
			if(!pr.getTelefono().equals(p.getTelefono()))
				p.setTelefono(pr.getTelefono());
			if(pr.getAnticipacionReserva()!=p.getAnticipacionReserva())
				p.setAnticipacionReserva(pr.getAnticipacionReserva());
			
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
		}
		session.close();

	}

	public void bajaProfesor(Profesor pr)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity p=(ProfesorEntity)session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, pr.getDni()).uniqueResult();
		if(p==null)
			System.out.println("Profesor con ese dni no existe");
		else
		{
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
		}
		session.close();
	}
	
	public void agregarMateriaDisponible(Profesor p)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity pr=(ProfesorEntity)session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, p.getDni()).uniqueResult();
		if(pr==null) 
		{
			System.out.println("No existe Profesor con ese dni");
		}
		else
		{
			for(Materia ma : p.getMaterias()){
				MateriaEntity m=(MateriaEntity)MateriaDAO.getInstancia().findByCode(ma.getIdMateria());
				if(m!=null)
					pr.setMaterias(m);
			}
			session.beginTransaction();
			session.save(pr);
			session.getTransaction().commit();
		}
		session.close();
	}
	public void agregarClases(Profesor p)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ProfesorEntity pr=(ProfesorEntity)session.createQuery("from ProfesorEntity where dni = ?").setParameter(0, p.getDni()).uniqueResult();
		if(pr==null) 
		{
			System.out.println("No existe Profesor con ese dni");
		}
		else
		{
			for(Materia ma : p.getMaterias()){
				MateriaEntity m=(MateriaEntity)MateriaDAO.getInstancia().findByCode(ma.getIdMateria());
				if(m!=null)
					pr.setMaterias(m);
			}
			session.beginTransaction();
			session.save(pr);
			session.getTransaction().commit();
		}
		session.close();
	}

}
