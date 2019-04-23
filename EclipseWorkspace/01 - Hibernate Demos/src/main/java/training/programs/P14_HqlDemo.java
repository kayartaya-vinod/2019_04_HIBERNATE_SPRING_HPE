package training.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import training.entity.Product;
import training.entity.Shipper;
import training.utils.HibernateUtil;

public class P14_HqlDemo {

	private static Session session;
	
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		
		// printAllShippers();
		// printProductsByPage(4); // pageNum = 4 (records 31-40)
		// printProductsByPriceRange(50.0, 250.0); // min=50, max=250
		// printSupplierNames();
		// printProcuctAndCategoryNames();
		// printSupplierWithProductNames();
		// printCategorywiseAggregateDetails();
		increaseProductPriceBy(1.0); // incBy = 1.0
		
		session.close();
	}

	static void increaseProductPriceBy(double incBy) {

		Product p1 = session.get(Product.class, 1);
		System.out.println("Price = $" + p1.getUnitPrice());
		
		String hql = "update Product set unitPrice = unitPrice + :INC_BY";
		Query<?> qry = session.createQuery(hql);
		qry.setParameter("INC_BY", incBy);
		Transaction tx = session.beginTransaction();
		int n = qry.executeUpdate(); // does not update persistent entities in session
		tx.commit();
		System.out.printf("Price updated for %d products\n", n);
		
		session.refresh(p1);
		p1 = session.get(Product.class, 1);
		System.out.println("Price = $" + p1.getUnitPrice());
	}

	static void printCategorywiseAggregateDetails() {
		String hql = "select category.categoryName, count(p), "
				+ "avg(unitPrice), min(unitPrice), "
				+ "max(unitPrice) from Product p group by category.categoryName "
				+ "having count(p) >= 10 "
				+ "order by category.categoryName";
		
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.list();
		for(Object[] data: list) {
			System.out.printf("%-20s %3d %10.2f %10.2f %10.2f\n",
					data[0], data[1], data[2], data[3], data[4]);
		}
	}

	static void printSupplierWithProductNames() {
		String hql = "select s.companyName, p.productName "
				+ "from Supplier s join s.products as p";
		
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.list();
		for(Object[] data: list) {
			System.out.println(data[0] + " --> " + data[1]);
		}
	}

	static void printProcuctAndCategoryNames() {
		String hql = "select productName, category.categoryName from Product";
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.list();
		for(Object[] data: list) {
			System.out.println(data[0] + " --> " + data[1]);
		}
	}

	static void printSupplierNames() {
		String hql = "select companyName from Supplier";
		Query<String> qry = session.createQuery(hql, String.class);
		List<String> list = qry.list();
		for(String name: list) {
			System.out.println(name);
		}
		
	}

	static void printProductsByPriceRange(double min, double max) {
		String hql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setParameter("MIN_PRICE", min);
		qry.setParameter("MAX_PRICE", max);
		List<Product> list = qry.getResultList();
		for(Product p: list) {
			System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
		}
	}

	static void printProductsByPage(int pageNum) {
		String hql = "select p from Product p order by p.productId";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setMaxResults(10);
		qry.setFirstResult((pageNum - 1) * 10);
		List<Product> list = qry.list();
		for(Product p: list) {
			System.out.println(p.getProductId() + " --> " + p.getProductName());
		}
		
	}

	static void printAllShippers() {
		String hql = "from Shipper";
		Query<Shipper> qry = session.createQuery(hql, Shipper.class);
		List<Shipper> list = qry.getResultList();
		for(Shipper s: list) {
			System.out.println(s.getCompanyName() + " --> " + s.getPhone());
		}
	}
}







