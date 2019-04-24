package training.dao;

import java.util.List;

import training.entity.Product;

public interface ProductDao {

	// CRUD OPERATIONS RELEATED TO THE ENTITY 'Product'

	public void addProduct(Product product) throws DaoException;

	public Product getProduct(Integer id) throws DaoException;

	public void updateProduct(Product product) throws DaoException;

	public void deleteProduct(Integer id) throws DaoException;

	// QUERIES

	public List<Product> getAllProducts() throws DaoException;

	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public List<Product> getProductsByCategory(Integer categoryId) throws DaoException;

	public List<Product> getProductsBySupplier(Integer supplierId) throws DaoException;

	public List<Product> getOutOfStockProducts() throws DaoException;

	public int count() throws DaoException;
}
