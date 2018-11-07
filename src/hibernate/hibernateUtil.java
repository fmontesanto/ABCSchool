
	package hibernate;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.AnnotationConfiguration;

import entities.AlumnoEntity;
import entities.ClaseEntity;
import entities.FacturaEntity;
import entities.ProfesorEntity;
import entities.ResenaEntity;
import entities.ReservaEntity;
import entities.UsuarioEntity;



	public class hibernateUtil {
		private static final SessionFactory sessionFactory;
		private static Session session;

		static {
			try {
				AnnotationConfiguration config = new AnnotationConfiguration();
				config.addAnnotatedClass(ClaseEntity.class);
				config.addAnnotatedClass(UsuarioEntity.class);
				config.addAnnotatedClass(ProfesorEntity.class);
				config.addAnnotatedClass(FacturaEntity.class);
				config.addAnnotatedClass(AlumnoEntity.class);
				config.addAnnotatedClass(ResenaEntity.class);
				config.addAnnotatedClass(ReservaEntity.class);
				sessionFactory = config.buildSessionFactory();
				session = sessionFactory.openSession();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}

		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public static Session getSession() {
			return session;
		}

	}



