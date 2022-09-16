package mbalcilar.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mbalcilar.northwind.business.abstracts.ProductService;
import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;
import mbalcilar.northwind.core.utilities.results.SuccessDataResult;
import mbalcilar.northwind.entities.concretes.Product;
import mbalcilar.northwind.entities.dtos.ProductWithCategoryDto;

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
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productservice.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productservice.getByProductNameAndCategory(productName, categoryId);
	}
	
	
	@GetMapping("/getByProductNameOrCategory")
	public DataResult<List<Product>> getByProductNameOrCategory(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productservice.getByProductNameOrCategory(productName, categoryId);
	
	}
	
	
	@GetMapping("/getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return this.productservice.getByCategoryIn(categories);
		
	}
	
	
	
	
	@GetMapping("/getByProductNameContains")
	public DataResult <List<Product>> getByProductNameContains(@RequestParam String search) {
		return this.productservice.getByProductNameContains(search);
	}
	
	
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String search) {
		return this.productservice.getByProductNameStartsWith(search);
			
	}
	
	
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productservice.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllAsc")
	public DataResult<List<Product>> getAllSortAsc() {
		return this.productservice.getAllSortAsc();
	
	}
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSortDesc() {
		return this.productservice.getAllSortDesc();
	
	}
	
	@GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return this.productservice.getByNameAndCategory(productName, categoryId);
	}
	
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productservice.getProductWithCategoryDetails();
	}
	
	
}
