package com.kums.ecomdummy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.kums.ecomdummy.model.Product;
import com.kums.ecomdummy.repo.ProductRepo;


@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductById(int id) {
		return repo.findById(id).orElse(null);
	}

	public Product addProduct(Product product, MultipartFile imageFile) throws Exception {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws Exception {
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repo.save(product);
	}

	public void deleteProduct(int id) {
		Product product = repo.findById(id).orElse(null);
		repo.delete(product);
	}

	public List<Product> searchProducts(String keyword) {
		return repo.searchProducts(keyword);
	}
}
