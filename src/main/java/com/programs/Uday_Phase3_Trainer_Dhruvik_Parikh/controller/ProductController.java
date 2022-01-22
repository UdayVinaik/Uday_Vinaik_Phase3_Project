package com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.dao.ProductDao;
import com.programs.Uday_Phase3_Trainer_Dhruvik_Parikh.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@GetMapping("/listProducts")
	public String listProducts(Model model) {
		
		List<Product> products =  productDao.getProducts();
		System.out.print(products);
		model.addAttribute("products",products);
		return "listProducts";
	}
	
	@RequestMapping("/listProductsByCategory")
	public String getByCategory(
			@RequestParam(value="category", required = true) String category,
			Model model) {
		
		List<Product> products = productDao.filterByCategory(category);
		model.addAttribute("products", products);
		return "listProducts";
	}
	
}
