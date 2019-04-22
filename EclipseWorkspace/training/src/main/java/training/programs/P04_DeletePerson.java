package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Person;
import training.utils.HibernateUtil;

public class P04_DeletePerson {

	public static void main_not_correct_method(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		// transient object
		Person p1 = new Person();
		p1.setId(1);
		
		// persistent --> deleted
		session.remove(p1);
		session.beginTransaction().commit();
		System.out.println("Data deleted!");
		
		session.close();
	}
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		// persistent object
		Person p1 = session.get(Person.class, 2);
		
		if(p1!=null) {
			// deleted
			session.remove(p1);
			session.beginTransaction().commit();

			System.out.println("Data deleted!");
		}
		session.close();
	}
	
}
