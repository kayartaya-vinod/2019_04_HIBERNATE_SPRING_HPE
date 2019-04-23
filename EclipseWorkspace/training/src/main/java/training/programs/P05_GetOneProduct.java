package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Product;
import training.entity.Supplier;
import training.utils.HibernateUtil;

public class P05_GetOneProduct {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Product p1 = session.get(Product.class, 1);
		
		// p1 now is a detached object
		System.out.println("Name    = " + p1.getProductName());
		System.out.println("Price = $" + p1.getUnitPrice());
		System.out.println("Desc = " + p1.getQuantityPerUnit());
		System.out.println("Category = " + p1.getCategory().getCategoryName());
		Supplier s1 = p1.getSupplier();
		System.out.println("Supplied by = " + s1.getCompanyName());
		
		System.out.println("Products supplied by this supplier:");
		for(Product p: s1.getProducts()) {
			System.out.println(p.getProductName() 
					+ " (" + p.getCategory().getCategoryName() + ")");
		}
		
		session.close();
		
	}
}






