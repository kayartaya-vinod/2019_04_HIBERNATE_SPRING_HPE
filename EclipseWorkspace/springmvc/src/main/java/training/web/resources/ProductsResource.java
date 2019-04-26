package training.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

@Controller
@RequestMapping("/api/products")
public class ProductsResource {

	@Autowired
	private ProductDao dao;
	
	/// --> http://localhost:8080/springmvc/api/products/22
	@RequestMapping(path="/{pid}", method=RequestMethod.GET, 
			produces= {"application/json", "application/xml"})
	@ResponseBody
	public Product getOneProduct(@PathVariable("pid") Integer id) throws DaoException {
		return dao.getProduct(id);
	}
	
}




