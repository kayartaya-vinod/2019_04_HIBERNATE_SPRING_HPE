package training.programs;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig6;
import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class P03_TestingHibernateTemplateProductDao {

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig6.class);
		
		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		
		System.out.println("dao is an instanceof " + dao.getClass());
		int pc = dao.count();
		System.out.println("There are " + pc + " products.");
		
		Product p1 = dao.getProduct(20);
		System.out.println("p1.productName = " + p1.getProductName());
		System.out.println("p1.unitPrice = " + p1.getUnitPrice());
		
		try {
			p1.setUnitPrice(p1.getUnitPrice()+1);
			dao.updateProduct(p1);
			System.out.println("Product updated successfully!");
		} catch (DaoException e) {
			System.out.println("Unable to update the product...");
			System.out.println(e.getMessage());
		}
		
		List<Product> list = dao.getProductsByPriceRange(50.0, 100.0);
		System.out.println("There are " + list.size() 
			+ " products between $50 and $100");
		
		list = dao.getProductsByPriceRange(100.0, 50.0);
		System.out.println("There are " + list.size() 
			+ " products between $100 and $50");
		
		
		list = dao.getProductsBySupplier(p1.getSupplier().getSupplierId());
		System.out.println(p1.getSupplier().getCompanyName() 
				+ " supplies " + list.size() + " products");
		
		
		ctx.close();
	}
}
