package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AlumnoEntity;
import entities.ProfesorEntity;
import entities.ReservaEntity;
import hibernate.hibernateUtil;
import negocio.Clase;
import negocio.Reserva;

public class ReservaDAO {
	
	private static ReservaDAO instancia;

	private ReservaDAO(){ }

	public static ReservaDAO getInstancia(){
		if(instancia == null){
			instancia = new ReservaDAO();
		}
		return instancia;
	}

	public ReservaEntity findById(Integer idReserva)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ReservaEntity r = (ReservaEntity) session.createQuery("from ReservaEntity where idReserva = ?").setParameter(0, idReserva).uniqueResult();
		session.close();
		return r;
	}

	public void agregarReserva(Reserva r)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ReservaEntity re=(ReservaEntity)session.createQuery("from ReservaEntity where idReserva = ?").setParameter(0, r.getIdReserva()).uniqueResult();
		int flag=0;
		if(re!=null) 
			System.out.println("Reserva ya existente con ese id");
		else
		{
			AlumnoEntity a = AlumnoDAO.getInstancia().findByDni(r.getAlumno().getDni());
			if(a==null)
				flag=1;	
			else
				re=new ClaseEntity(r.getHorario(), r.getEstado(), p);
		}
		session.beginTransaction();
		if(flag==0)
			session.save(re);
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

}
