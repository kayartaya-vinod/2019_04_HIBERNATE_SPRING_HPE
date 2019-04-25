package training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import training.dao.DaoException;
import training.dao.ProductDao;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductDao dao;
	
	////// URL --> http://localhost:9999/springmvc/view-all-products
	@RequestMapping("/view-all-products")
	public ModelAndView viewAllProducts() throws DaoException {

		return new ModelAndView(
				"/WEB-INF/views/show-products.jsp", 
				"products", dao.getAllProducts());
		
	}

}





