package training.dao.impl;

import java.util.List;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class DummyProductDao implements ProductDao {

	@Override
	public int count() throws DaoException {
		return -50;
	}

	@Override
	public void addProduct(Product product) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public Product getProduct(Integer id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void deleteProduct(Integer id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getAllProducts() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getOutOfStockProducts() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

}
