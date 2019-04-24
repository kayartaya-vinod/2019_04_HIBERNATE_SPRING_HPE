package training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig5;
import training.dao.DaoException;
import training.dao.ProductDao;

public class P01_SpringAsFactoryDemo {

	public static void main(String[] args) throws DaoException {
		// a variable representing spring container
		AnnotationConfigApplicationContext ctx;

		// an object representing spring container based on AppConfig1
		ctx = new AnnotationConfigApplicationContext(AppConfig5.class);
		
		ProductDao dao = ctx.getBean(ProductDao.class);
		int pc = dao.count();
		
		System.out.println("There are " + pc + " products.");

		// close the spring container (releasing internal resources)
		ctx.close();
	}
}
