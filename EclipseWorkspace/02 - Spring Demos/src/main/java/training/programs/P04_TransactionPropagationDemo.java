package training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig6;
import training.dao.DaoException;
import training.service.ProductManager;

public class P04_TransactionPropagationDemo {

	public static void main(String[] args) throws DaoException {
		
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig6.class);
		
		// non-transactional context
		ProductManager pm = ctx.getBean(ProductManager.class);
		pm.updateProducts();
		System.out.println("Product prices updated successfully!");

		ctx.close();
		
	}
}
