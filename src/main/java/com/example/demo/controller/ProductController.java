package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Vendor;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.VendorRepository;
@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	@PostMapping("/product/{cid}/{vid}")
	public Product postProduct(@RequestBody Product product,
							@PathVariable("cid") Long cid,
							@PathVariable("vid") Long vid) {
		
		Optional<Category> optionalC = categoryRepository.findById(cid);
		if(!optionalC.isPresent())
			throw new RuntimeException("Invalid Category id");
		Category category = optionalC.get();
		
		Optional<Vendor> optionalV = vendorRepository.findById(vid);
		if(!optionalV.isPresent())
			throw new RuntimeException("Invalid vendor id");
		Vendor vendor = optionalV.get();
		
		product.setCategory(category);
		product.setVendor(vendor);
		
		return productRepository.save(product);
	}
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/product/category/{cid}")
	public List<Product> getProductByCategoryId(@PathVariable("cid") Long cid) {
		Optional<Category> optionalC = categoryRepository.findById(cid);
		if(!optionalC.isPresent())
			throw new RuntimeException("Invalid Category id");
		List<Product> list= productRepository.getProductByCategoryId(cid);
		return list;
	}
	
	@GetMapping("/product/vendor/{vid}")
	public List<Product> getProductByVendorId(@PathVariable("vid") Long vid) {
		Optional<Vendor> optionalV = vendorRepository.findById(vid);
		if(!optionalV.isPresent())
			throw new RuntimeException("Invalid Vendor id");
		List<Product> list= productRepository.getProductByVendorId(vid);
		return list;
	}
	
	@DeleteMapping("/product/category/{cid}")
	public void deleteProductByCategoryId(@PathVariable("cid") Long cid) {
		Optional<Category> optionalC = categoryRepository.findById(cid);
		if(!optionalC.isPresent())
			throw new RuntimeException("Invalid Category id");
		productRepository.deleteProductByCategoryId(cid);
	}
}
