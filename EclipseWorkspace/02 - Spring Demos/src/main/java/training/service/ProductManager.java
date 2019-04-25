package training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

@Service
public class ProductManager {

	@Autowired
	@Qualifier("htDao")
	private ProductDao dao;

	@Transactional(readOnly = false, rollbackFor = DaoException.class)
	public void updateProducts() throws DaoException {
		Product p1 = dao.getProduct(1);
		Product p2 = dao.getProduct(2);
		Product p3 = dao.getProduct(3);
		
		p1.setUnitPrice(18.0); // 18.0
		p2.setUnitPrice(19.0); // 19.0
		p3.setUnitPrice(10.0); // 10.0
		
		dao.updateProduct(p1);
		dao.updateProduct(p2);
		dao.updateProduct(p3); // (-ve price, will rollback all updates)
	}
}










