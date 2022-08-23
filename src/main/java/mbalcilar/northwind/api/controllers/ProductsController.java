package mbalcilar.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mbalcilar.northwind.business.abstracts.ProductService;
import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;
import mbalcilar.northwind.core.utilities.results.SuccessResult;
import mbalcilar.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	
	private ProductService productservice;
	
	@Autowired
	public ProductsController(ProductService productservice) {
		super();
		this.productservice = productservice;
	}
	
	

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productservice.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productservice.add(product);
		
	}
	
}
