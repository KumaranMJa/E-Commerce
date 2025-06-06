package com.kums.ecomdummy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kums.ecomdummy.model.Product;
import com.kums.ecomdummy.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String greet() {
		return "It's Working";
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	/*
	//To get the manual http status code we use Response Entity
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(service.getAllProducts(), HttpStatus.FOUND);
	}*/
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product product = service.getProductById(id);
		if(product != null) {
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/*@GetMapping("/products/{proId}")
	public Product getProductById(@PathVariable int proId) {
		return service.getProductById(proId);
	}*/
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile ){
		try{
			Product product1 = service.addProduct(product,imageFile);
			return new ResponseEntity<>(product1 , HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("product/{id}/image")
	public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
		Product product = service.getProductById(id); //from db product will be coming within product object
		byte[] imageFile = product.getImageDate();
		return ResponseEntity.ok()
				//.contentType(MediaType.valueOf(product.getImageType()))
				.body(imageFile);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,@RequestPart MultipartFile imageFile){
		Product product1 = null;
		try {
			product1 = service.updateProduct(id,product,imageFile);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to Upload" , HttpStatus.BAD_REQUEST);
		}
		if(product1 != null) {
			return new ResponseEntity<>("Updated", HttpStatus.OK);
			}
		return new ResponseEntity<>("Failed to Upload" , HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		 Product product = service.getProductById(id);
		 if(product != null) {
			 service.deleteProduct(id);
			 return new ResponseEntity<>("Deleted", HttpStatus.OK);
		 }
		 return new ResponseEntity<>("Failed to Delete",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam  String keyword){
		List<Product> products = service.searchProducts(keyword);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
