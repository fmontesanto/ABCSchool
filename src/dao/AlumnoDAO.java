package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AlumnoEntity;
import hibernate.hibernateUtil;
import negocio.Alumno;

public class AlumnoDAO {
	
	private static AlumnoDAO instancia;

	private AlumnoDAO(){ }

	public static AlumnoDAO getInstancia(){
		if(instancia == null){
			instancia = new AlumnoDAO();
		}
		return instancia;
	}

	public AlumnoEntity findByDni(String dni)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AlumnoEntity a = (AlumnoEntity) session.createQuery("from AlumnoEntity where dni = ?").setParameter(0, dni).uniqueResult();
		session.close();
		return a;
	}

	public void agregarAlumno(Alumno a)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AlumnoEntity ae=(AlumnoEntity)session.createQuery("from AlumnoEntity where dni = ?").setParameter(0, a.getDni()).uniqueResult();
		if(ae!=null) 
			System.out.println("Alumno ya existente con ese dni");
		else
		{
			ae=new AlumnoEntity(a.getDni(), a.getNombre(), a.getMail(), a.getTelefono(), a.getDomicilio(), a.getFechaNacimiento(), a.getContra());
		}
		session.beginTransaction();
		session.save(ae);
		session.getTransaction().commit();
		session.close();
	}

	public void borrarAlumno(String dni)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AlumnoEntity a=(AlumnoEntity)session.createQuery("from AlumnoEntity where dni = ?").setParameter(0, dni).uniqueResult();
		if(a==null) 
		{
			System.out.println("No existe Alumno con ese dni");
		}
		else
		{
			session.beginTransaction();
			session.delete(a);
			session.getTransaction().commit();
		}
		session.close();
	}

	public void modificarAlumno(Alumno a)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AlumnoEntity ae=(AlumnoEntity)session.createQuery("from AlumnoEntity where dni = ?").setParameter(0, a.getDni()).uniqueResult();
		if(ae==null)
			System.out.println("Alumno con ese dni no existe");
		else
		{
			if(!a.getDomicilio().equals(ae.getDomicilio()))
				ae.setDomicilio(a.getDomicilio());
			if(a.getFechaNacimiento()!=ae.getFechaNacimiento())
				ae.setFechaNacimiento(a.getFechaNacimiento());
			if(!a.getMail().equals(ae.getMail()))
				ae.setMail(a.getMail());
			if(!a.getContra().equals(ae.getContra()))
				ae.setContra(a.getContra());
			if(!a.getTelefono().equals(ae.getTelefono()))
				ae.setTelefono(a.getTelefono());
			
			session.beginTransaction();
			session.update(ae);
			session.getTransaction().commit();
		}
		session.close();

	}

	public void bajaAlumno(Alumno a)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		AlumnoEntity ae=(AlumnoEntity)session.createQuery("from AlumnoEntity where dni = ?").setParameter(0, a.getDni()).uniqueResult();
		if(ae==null)
			System.out.println("Alumno con ese dni no existe");
		else
		{
			session.beginTransaction();
			session.delete(ae);
			session.getTransaction().commit();
		}
		session.close();
	}

}
