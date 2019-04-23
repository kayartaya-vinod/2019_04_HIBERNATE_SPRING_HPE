package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Professor;
import training.entity.Student;
import training.utils.HibernateUtil;

public class P15_InheritanceDemo {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Student st = new Student(12, "Ramesh", "ramesh@exmaple.com", "Maths", 4.8);
		Professor pf = new Professor(77, "Kumar", "kumar@example.com", 45000.0);
		
		session.persist(st);
		session.persist(pf);
		
		session.beginTransaction().commit();
		session.close();
		
		System.out.println("Done!");
	}
}
