package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Person;
import training.utils.HibernateUtil;

public class P03_GetAndUpdatePersonData {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();		
		Person p1 = session.get(Person.class, 1);
		session.close();
	
		
		p1.setHeight(6.1);
		
		// we want to update p1's data to db
		// create a new session
		System.out.println("Updating....");
		session = factory.openSession();		
		
		session.merge(p1); // try with session.update(p1) and check the diff.
		
		session.beginTransaction().commit();
		session.close();
	}
}









