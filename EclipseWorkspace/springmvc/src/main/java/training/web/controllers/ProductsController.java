package training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import training.dao.DaoException;
import training.dao.ProductDao;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductDao dao;

	// this is a (request) handler 
	@RequestMapping("/info")
	public String info(Model model) {

		// all model data is kept in request scope
		model.addAttribute("name", "Vinod Kumar Kayartaya");
		model.addAttribute("email", "vinod@vinod.co");
		model.addAttribute("phone", "+91 9731 424 784");
		
		return "info";
	}
	
	@RequestMapping(path="/get-products-by-price", method=RequestMethod.GET)
	public String getProductsByPrice(
			@RequestParam("min_price") Double min, 
			@RequestParam("max_price") Double max, 
			Model model) throws DaoException {
		
		model.addAttribute("data", dao.getProductsByPriceRange(min, max));
		return "show-products";
	}
}







