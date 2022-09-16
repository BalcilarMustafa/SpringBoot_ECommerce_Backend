package mbalcilar.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import mbalcilar.northwind.business.abstracts.ProductService;
import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;
import mbalcilar.northwind.core.utilities.results.SuccessDataResult;
import mbalcilar.northwind.core.utilities.results.SuccessResult;
import mbalcilar.northwind.dataAccess.abstracts.ProductDao;
import mbalcilar.northwind.entities.concretes.Product;
import mbalcilar.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{

	
	private ProductDao productdao;
	
	@Autowired
	public ProductManager(ProductDao productdao) {
		super();
		this.productdao = productdao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(),"Data is listed");
				
	}

	@Override
	public Result add(Product product) {

		this.productdao.save(product);
		return new SuccessResult("product added");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>(this.productdao.getByProductName(productName),"Data is listed");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
	
		return new SuccessDataResult<Product>(this.productdao.getByProductNameAndCategory_CategoryId(productName, categoryId),"Data is listed");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productdao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data is listed");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>(this.productdao.getByCategoryIn(categories),"Data is listed");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String search) {
		
		return new SuccessDataResult<List<Product>>(this.productdao.getByProductNameContains(search),"Data is listed");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String search) {
		
		return new SuccessDataResult<List<Product>>(this.productdao.getByProductNameStartsWith(search),"Data is listed");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>(this.productdao.getByNameAndCategory_CategoryId(productName, categoryId),"Data is listed");
	}

	
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSortAsc() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "productName");
		
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(sort), "Success");
		
	}
	
	@Override
	public DataResult<List<Product>> getAllSortDesc() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(sort), "Success");
		
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productdao.getProductWithCategoryDetails(), "Data is listed");
	}

	
}
