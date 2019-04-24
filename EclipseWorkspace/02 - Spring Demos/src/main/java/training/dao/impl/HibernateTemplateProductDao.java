package training.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

@Repository("htDao")
public class HibernateTemplateProductDao implements ProductDao {

	@Autowired(required = false)
	private HibernateTemplate template;

	@Override
	public void addProduct(Product product) throws DaoException {
		// We must handle exceptions from 'persist' function,
		// and rethrow them in the form of DaoException.
		// Wel will use AOP to remove this cross-cutting concern
		template.persist(product);
	}

	@Override
	public Product getProduct(Integer id) throws DaoException {
		return template.get(Product.class, id);
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		template.merge(product);
	}

	@Override
	public void deleteProduct(Integer id) throws DaoException {
		Product p1 = getProduct(id);
		if(p1==null) {
			throw new DaoException("Invalid id for deletion " + id);
		}
		template.delete(p1);
	}

	@Override
	public List<Product> getAllProducts() throws DaoException {
		// valid with HibernateTemplate version older than 5.0.4
		// return (List<Product>) template.find("from Product");
		
		String hql = "from Product";
		List<Product> list = template.execute(
				sess->sess.createQuery(hql, Product.class).list());
		return list;
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		// dc.add(Restrictions.ge("unitPrice", min));
		// dc.add(Restrictions.le("unitPrice", max));
		dc.add(Restrictions.between("unitPrice", min, max));
		return (List<Product>) template.findByCriteria(dc);
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		List<Product> list = template.execute(
				session->{
					String hql = "from Product where category.categoryId=:CAT_ID";
					Query<Product> qry = session.createQuery(hql,Product.class);
					qry.setParameter("CAT_ID", categoryId);
					return qry.getResultList();
				});
		
		return list;
	}

	@Override
	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		List<Product> list = template.execute(
				session->{
					String hql = "from Product where supplier.supplierId=:SUP_ID";
					Query<Product> qry = session.createQuery(hql,Product.class);
					qry.setParameter("SUP_ID", supplierId);
					return qry.getResultList();
				});
		
		return list;
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		String hql = "from Product where unitsInStock=0";
		List<Product> list = template.execute(
				sess->sess.createQuery(hql, Product.class).list());
		return list;
	}

	@Override
	public int count() throws DaoException {
		String hql = "select count(p) from Product p";
		Long pc = template.execute(
				sess->sess.createQuery(hql, Long.class).uniqueResult());
		return pc.intValue();
	}

}








