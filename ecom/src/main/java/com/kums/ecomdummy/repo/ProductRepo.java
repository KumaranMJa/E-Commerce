package com.kums.ecomdummy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kums.ecomdummy.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	//JPQL - JPA Query Language
	//Method to search products by name and brand  ,[ : KEYWORD ]--> (:) IT WILL SEACH FOR THE VALUE IN THE BELOW METHOD
	
	@Query("Select p1 from Product p1 where LOWER(p1.name) LIKE LOWER (CONCAT('%', :keyword ,'%')) OR "+
			"LOWER(p1.description) LIKE LOWER (CONCAT('%', :keyword ,'%')) OR "+
			"LOWER(p1.brand) LIKE LOWER (CONCAT('%', :keyword ,'%')) OR "+
			"LOWER(p1.category) LIKE LOWER (CONCAT('%', :keyword ,'%'))")
	List<Product> searchProducts(String keyword);
	
	
}
