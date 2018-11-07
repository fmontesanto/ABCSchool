package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ClaseEntity;
import entities.ProfesorEntity;
import hibernate.hibernateUtil;
import negocio.Clase;
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

	/*public void borrarClase(Integer idClase)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity c=(ClaseEntity)session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, idClase).uniqueResult();
		//UbicacionEntity u=null;
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

	public void bajaClase(Clase cl)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ClaseEntity c=(ClaseEntity)session.createQuery("from ClaseEntity where idClase = ?").setParameter(0, cl.getNumero()).uniqueResult();
		if(c==null)
			System.out.println("Clase con ese id no existe");
		else
		{
			session.beginTransaction();
			session.delete(c);
			session.getTransaction().commit();
		}
		session.close();
	}*/
}
