package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Category;
import training.entity.Product;
import training.utils.HibernateUtil;

public class P07_BidirectionalDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Category c1 = new Category();
		c1.setCategoryName("Stationaries");
		c1.setDescription("Paper, pen etc.");
		
		Product p1 = new Product();
		p1.setProductName("Pustak books");
		p1.setQuantityPerUnit("50 units of 100 pages book");
		p1.setUnitPrice(450.0);
		p1.setDiscontinued(0);
		c1.addProduct(p1);
		
		p1 = new Product();
		p1.setProductName("Hero pens");
		p1.setQuantityPerUnit("25 units");
		p1.setUnitPrice(700.0);
		p1.setDiscontinued(0);
		c1.addProduct(p1);
		
		session.persist(c1); // persists c1, and associated products
		
		
		session.beginTransaction().commit();
		session.close();
	}
}








