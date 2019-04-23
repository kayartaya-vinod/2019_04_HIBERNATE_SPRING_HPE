package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Category;
import training.entity.Product;
import training.utils.HibernateUtil;

public class P06_GetCategoryAndProducts {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		Category c1 = session.get(Category.class, 3);
		System.out.println("Name = " + c1.getCategoryName());
		System.out.println("Desc = " + c1.getDescription());
		
		System.out.println("Products in this category are: ");
		for(Product p: c1.getProducts()) {
			System.out.println(p.getProductName());
		}
		
		session.close();
	}
}









