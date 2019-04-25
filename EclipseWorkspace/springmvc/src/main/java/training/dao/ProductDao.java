package training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import training.entity.Product;

@Transactional(rollbackFor = { DaoException.class })
public interface ProductDao {

	// CRUD OPERATIONS RELEATED TO THE ENTITY 'Product'

	@Transactional(readOnly = false)
	public void addProduct(Product product) throws DaoException;

	public Product getProduct(Integer id) throws DaoException;

	@Transactional(readOnly = false)
	public void updateProduct(Product product) throws DaoException;

	@Transactional(readOnly = false)
	public void deleteProduct(Integer id) throws DaoException;

	// QUERIES

	public List<Product> getAllProducts() throws DaoException;

	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException;

	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException;

	public List<Product> getOutOfStockProducts() throws DaoException;

	public int count() throws DaoException;
}
