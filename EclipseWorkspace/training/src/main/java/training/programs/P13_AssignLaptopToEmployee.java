package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Employee;
import training.entity.Laptop;
import training.utils.HibernateUtil;

public class P13_AssignLaptopToEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Laptop lt = new Laptop();
		lt.setSerialNumber("PQR8373");
		lt.setMake("Apple");
		lt.setModel("Macbook Pro");
		
		Employee emp = session.get(Employee.class, 4);
//		emp.setLaptop(lt);
		lt.setOwner(emp);
		
		session.persist(lt);
		
		session.beginTransaction().commit();
		session.close();
	}
}







