package mbalcilar.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mbalcilar.northwind.business.abstracts.ProductService;
import mbalcilar.northwind.core.utilities.results.DataResult;
import mbalcilar.northwind.core.utilities.results.Result;
import mbalcilar.northwind.core.utilities.results.SuccessDataResult;
import mbalcilar.northwind.core.utilities.results.SuccessResult;
import mbalcilar.northwind.dataAccess.abstracts.ProductDao;
import mbalcilar.northwind.entities.concretes.Product;

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

	
}
