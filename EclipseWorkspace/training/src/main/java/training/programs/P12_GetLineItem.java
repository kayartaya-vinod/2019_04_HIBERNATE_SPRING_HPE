package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.LineItem;
import training.utils.HibernateUtil;

public class P12_GetLineItem {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		
		LineItem id = new LineItem(10250, 51);
		LineItem item = session.get(LineItem.class, id);
		
		System.out.println(item);
		
		session.close();
		
	}
}
