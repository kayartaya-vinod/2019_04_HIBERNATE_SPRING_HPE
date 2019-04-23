package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Employee;
import training.utils.HibernateUtil;

public class P09_GetEmployeeData {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Employee e1 = session.get(Employee.class, 5);
		
		System.out.println("Employee details:");
		System.out.println("Name is " + e1.getFirstName() + " " + e1.getLastName());
		System.out.println("Works as " + e1.getTitle());
		
		System.out.println("------------------");
		System.out.println("Manager details: ");
		Employee m1 = e1.getManager();
		System.out.println("Name is " + m1.getFirstName() + " " + m1.getLastName());
		System.out.println("Works as " + m1.getTitle());
		
		System.out.println("------------------");
		System.out.println("Subordinates: ");
		for(Employee e: e1.getSubordinates()) {
			System.out.println(e.getFirstName() + " " + e.getLastName());
		}
		
		session.close();
	}
}









