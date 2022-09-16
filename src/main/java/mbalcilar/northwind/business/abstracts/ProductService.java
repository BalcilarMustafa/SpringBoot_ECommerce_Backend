package mbalcilar.northwind.business.abstracts;

import java.util.List;



import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;
import mbalcilar.northwind.entities.concretes.Product;
import mbalcilar.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
	
	DataResult<List<Product>>  getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>>  getByProductNameContains(String search);
	
	DataResult<List<Product>>  getByProductNameStartsWith(String search);
	
	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	DataResult<List<Product>> getAllSortAsc();
	DataResult<List<Product>> getAllSortDesc();
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	

}
