package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Order;
import training.utils.HibernateUtil;

public class P11_GetOrderData {
	
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Order ord = session.get(Order.class, 10248);
		System.out.println("Customer name = " + ord.getCustomer().getCompanyName());
		System.out.println("Employee name = " + ord.getEmployee().getFirstName());
		System.out.println("Shipping address = " + ord.getShipDetails().getAddress());
		System.out.println("Shipping city = " + ord.getShipDetails().getCity());
		System.out.println("Shipped by = " + ord.getShippedBy().getCompanyName());
		
		session.close();
	}

}
