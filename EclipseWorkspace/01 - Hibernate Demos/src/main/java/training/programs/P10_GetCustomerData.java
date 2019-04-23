package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Customer;
import training.entity.Employee;
import training.utils.HibernateUtil;

public class P10_GetCustomerData {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Customer c1 = session.get(Customer.class, "ANTON");
		
		System.out.println("Name = " + c1.getCompanyName());
		System.out.println("POC = " + c1.getContactName());
		System.out.println("City = " + c1.getContactDetails().getCity());
		
		System.out.println("Employees who have processed this customer's orders:");
		for(Employee e: c1.getEmployees()) {
			System.out.println(e.getFirstName() + " " + e.getLastName());
		}
		
		session.close();
	}
}








