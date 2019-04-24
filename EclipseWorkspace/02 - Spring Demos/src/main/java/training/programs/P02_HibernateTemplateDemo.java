package training.programs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import training.cfg.AppConfig6;
import training.entity.Product;

public class P02_HibernateTemplateDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig6.class);

		HibernateTemplate tpl = ctx.getBean(HibernateTemplate.class);
		Product p1 = tpl.get(Product.class, 17);
		System.out.println("Name     = " + p1.getProductName());
		System.out.println("Price    = $" + p1.getUnitPrice());
		System.out.println("Category = " + p1.getCategory().getCategoryName());
		System.out.println("Supplier = " + p1.getSupplier().getCompanyName());
		
		
		ctx.close();
	}
}







