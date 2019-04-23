package training.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import training.entity.Category;

public final class HibernateUtil {
	private HibernateUtil() {
	}
	
	// static --> singleton
	// A.K.A Level-2 Cache
	private static SessionFactory factory;
	
	public static SessionFactory getSessionFactory() {
		if(factory==null) {
			// An empty configuration object
			Configuration cfg = new Configuration();
			// read from hibernate.cfg.xml file (in the build path)
			cfg.configure();
			
			// hibernate.cfg.xml:
			// <mapping class="training.entity.Category" />
			// cfg.addAnnotatedClass(Category.class);
			
			// build the session factory (represents a DB)
			factory = cfg.buildSessionFactory();
		}
		return factory;
	}
	
}
