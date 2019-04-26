package training.web.resources;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;
import training.entity.ProductList;

@RestController
@RequestMapping("/api/products")
public class ProductsResource {

	@Autowired
	private ProductDao dao;
	
	/// --> http://localhost:8080/springmvc/api/products/22
	@RequestMapping(path="/{pid}", method=RequestMethod.GET, 
			produces= {"application/json", "application/xml"})
	public ResponseEntity<Product> getOneProduct(@PathVariable("pid") Integer id) throws DaoException {
		
		Product p = dao.getProduct(id);
		
		return ResponseEntity.ok(p);
	}
	
	@RequestMapping(method=RequestMethod.GET, produces= "application/json")
	public List<Product> getProductsAsJson(
			@RequestParam(required=false) Double min, 
			@RequestParam(required=false) Double max) throws DaoException {
		
		return getProductsByPrice(min, max);
	}

	@RequestMapping(method=RequestMethod.GET, produces= "application/xml")
	public ProductList getProductsAsXml(
			@RequestParam(required=false) Double min, 
			@RequestParam(required=false) Double max) throws DaoException {
		return new ProductList(getProductsByPrice(min, max));
	}
	
	private List<Product> getProductsByPrice(Double min, Double max) throws DaoException {
		if (min == null && max == null) {
			return dao.getAllProducts();
		} else if (min == null) {
			return dao.getProductsByPriceRange(0.0, max);
		} else if (max==null) {
			return dao.getProductsByPriceRange(min, 100000.0);
		} else {
			return dao.getProductsByPriceRange(min, max);
		}
	}
	
	
	@RequestMapping(method=RequestMethod.POST, 
			consumes = {"application/xml", "application/json"},
			produces = "application/json")
	public Map<String, Object> addProduct(
			@RequestBody Product pr) throws DaoException {
		
		Map<String, Object> m = new LinkedHashMap<String, Object>();
		
		try {
			dao.addProduct(pr);
			m.put("success", true);
			m.put("generated-id", pr.getProductId());
		} catch (Exception e) {
			m.put("success", false);
			m.put("reason", e.getMessage());
		}
		return m;
	}
	
}












