package training.programs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.ContactDetails;
import training.entity.Supplier;
import training.utils.HibernateUtil;

public class P08_GetSupplierData {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Supplier s1 = session.get(Supplier.class, 12);
		session.close();
		
		System.out.println("Company name   = " + s1.getCompanyName());
		System.out.println("Contact person = " + s1.getContactName());
		ContactDetails cd = s1.getContactDetails();
		System.out.println("City           = " + cd.getCity());
		System.out.println("Region         = " + cd.getRegion());
		System.out.println("Country        = " + cd.getCountry());
		
	}
}
