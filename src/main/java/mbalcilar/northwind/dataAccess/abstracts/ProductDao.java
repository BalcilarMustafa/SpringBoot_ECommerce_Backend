package mbalcilar.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mbalcilar.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{
	
	Product getByProductName(String productName);
	// select * from products where product_name = table
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	// select * from products where product_name = table and category_id =2
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	// select * from products where product_name = table or category_id =2
	
	List<Product> getByCategoryIn(List<Integer> categories);
	// select * from products where category_id in((1,2,3,4)
	
	List<Product> getByProductNameContains(String search);
	
	List<Product> getByProductNameStartsWith(String search);
	
	@Query("From Product where productName=:productName and categoryId=:categoryId")
	List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId);
	//JPQL (Java Persistence Query Language) 
	// select * from products where product_name = table and category_id =2
	

}
