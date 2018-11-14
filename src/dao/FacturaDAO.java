package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.FacturaEntity;
import entities.ReservaEntity;
import hibernate.hibernateUtil;
import negocio.Factura;

public class FacturaDAO {
	
	private static FacturaDAO instancia;

	private FacturaDAO(){ }

	public static FacturaDAO getInstancia(){
		if(instancia == null){
			instancia = new FacturaDAO();
		}
		return instancia;
	}

	public FacturaEntity findByCode(Integer nro)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity f = (FacturaEntity) session.createQuery("from FacturaEntity where nroFactura = ?").setParameter(0, nro).uniqueResult();
		session.close();
		return f;
	}
	
	public void agregarFactura(Factura f)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		FacturaEntity fe=(FacturaEntity)session.createQuery("from FacturaEntity where nroFactura = ?").setParameter(0, f.getNumero()).uniqueResult();
		int flag=0;
		if(fe!=null) 
			System.out.println("Factura ya existente con ese nro");
		else
		{
			ReservaEntity r = ReservaDAO.getInstancia().findById(f.getReserva().getIdReserva());
			if(r==null)
				flag=1;	
			else
				fe=new FacturaEntity(f.getFecha(), f.getMonto(), f.getTipo(), f.getRemitente(), f.getMedioPago(), r);
		}
		session.beginTransaction();
		if(flag==0)
			session.save(fe);
		session.getTransaction().commit();
		session.close();
	}

}
