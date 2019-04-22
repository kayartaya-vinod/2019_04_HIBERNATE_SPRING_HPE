package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Product;
import training.utils.HibernateUtil;

public class P05_GetOneProduct {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Product p1 = session.get(Product.class, 13);
		
		// p1 now is a detached object
		System.out.println("Name    = " + p1.getProductName());
		System.out.println("Price = $" + p1.getUnitPrice());
		System.out.println("Desc = " + p1.getQuantityPerUnit());
		System.out.println("Category = " + p1.getCategory().getCategoryName());
		
		session.close();
		
	}
}






