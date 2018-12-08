package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.AlumnoEntity;
import entities.ClaseEntity;
import entities.ReservaEntity;
import hibernate.hibernateUtil;
import negocio.Alumno;
import negocio.Clase;
import negocio.Profesor;
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
			List<ClaseEntity> clases = new ArrayList<ClaseEntity>();
			for(Clase c : r.getClases()){
				ClaseEntity cc=ClaseDAO.getInstancia().findByCode(c.getNumero());
				if(cc.getEstado().equals("Libre")) {
					c.setEstado("Pendiente");
					ClaseDAO.getInstancia().modificarClase(c);
					clases.add(ClaseDAO.getInstancia().findByCode(c.getNumero()));
				}
				else{
					System.out.println("la clase esta ocupada amigita");
					flag=1;
				}
			}

			if(a == null || clases == null)
				flag=1;	
			else{
				re=new ReservaEntity(r.getDescuento(), r.getMonto(), r.getCantAlum(), false, r.getFecha(), clases, a);
			}
		}
		session.beginTransaction();
		if(flag==0)
			session.save(re);
		session.getTransaction().commit();
		session.close();
	}
	
	public void completarReserva(Reserva r){
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ReservaEntity re=(ReservaEntity)session.createQuery("from ReservaEntity where idReserva = ?").setParameter(0, r.getIdReserva()).uniqueResult();
		int flag=1;
		if(re==null) 
			System.out.println("Reserva no existente con ese id");
		else {
			if(re.getFactura()!= null)
				flag=0;
			for(Clase c : r.getClases()){
				ClaseEntity cc=ClaseDAO.getInstancia().findByCode(c.getNumero());
				if(cc.getEstado().equals("Pendiente")) {
					cc.setEstado("Ocupada");
					session.update(cc);
				}
			}
			re.setPaga(true);
		}
		session.beginTransaction();
		if(flag==0){
			session.update(re);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void cancelarReserva(Integer idReserva)
	{
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		ReservaEntity r=(ReservaEntity)session.createQuery("from ReservaEntity where idReserva = ?").setParameter(0, idReserva).uniqueResult();
		if(r==null) 
		{
			System.out.println("No existe Reserva con ese id");
		}
		else
		{
			for(ClaseEntity c : r.getClases()){
				c.setEstado("Libre");
				Profesor p = new Profesor(c.getProfesor().getDni(), c.getProfesor().getNombre(), c.getProfesor().getMail(), c.getProfesor().getTelefono(), 
						c.getProfesor().getDomicilio(), c.getProfesor().getFechaNacimiento(), c.getProfesor().getContra(), c.getProfesor().getDomicilioClases(), c.getProfesor().getAnticipacionReserva());
				Clase cl= new Clase(c.getIdClase(), c.getHorario(),c.getEstado(), p);
				ClaseDAO.getInstancia().modificarClase(cl);
			}
			
			Float monto = r.controlarFecha();
			if(monto != -1f){
				r.getAlumno().agregarSaldoAFavor(monto);
				Alumno a = new Alumno(r.getAlumno().getDni(), r.getAlumno().getNombre(), r.getAlumno().getMail(), r.getAlumno().getTelefono(), 
						r.getAlumno().getDomicilio(), r.getAlumno().getFechaNacimiento(), r.getAlumno().getContra());
				AlumnoDAO.getInstancia().modificarSaldo(a);
			}
			
			session.beginTransaction();
			session.delete(r);
			session.getTransaction().commit();
		}
		session.close();
	}
	public ArrayList<ReservaEntity> findByStudent(String dni)
	{
		int id = -1;
		id = AlumnoDAO.getInstancia().findByDni(dni).getIdUsuario();
		if(id != -1){
			SessionFactory sf = hibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			ArrayList<ReservaEntity> result = null;
			Query   q = session.createQuery("from ReservaEntity where idUsuario = ?").setParameter(0, id);
			result = (ArrayList<ReservaEntity>) q.list();
			session.close();
			return result;
		}
		else
			return null;
	}
}
