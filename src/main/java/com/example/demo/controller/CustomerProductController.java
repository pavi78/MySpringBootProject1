package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerProduct;
import com.example.demo.model.Product;
import com.example.demo.repository.CustomerProductRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;

@RestController
public class CustomerProductController {
	
	@Autowired
	private CustomerProductRepository customerProductRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/customer/purchase/product/{cid}/{pid}")
	public CustomerProduct purchaseAPI(@RequestBody CustomerProduct customerProduct,
							@PathVariable("cid") Long cid,
							@PathVariable("pid") Long pid) {
		
		Optional<Customer> optionalC = customerRepository.findById(cid);
		if(!optionalC.isPresent())
			throw new RuntimeException("Invalid customer id");
		Customer customer = optionalC.get();
		
		Optional<Product> optionalP = productRepository.findById(pid);
		if(!optionalP.isPresent())
			throw new RuntimeException("Invalid product id");
		Product product = optionalP.get();
		
		customerProduct.setProduct(product);
		customerProduct.setCustomer(customer);
		customerProduct.setDateOfpurchase(LocalDate.now());
		
		return customerProductRepository.save(customerProduct);
		
	}
	@GetMapping("/customer/product/{pid}")
	public List<Customer> getCustomerByProduct(@PathVariable("pid") Long pid) {
		List<Customer> list = customerProductRepository.getCustomerByProduct(pid);
		return list;
	}
	
	@GetMapping("/product/customer/{cid}")
	public List<Product> getProductByCustomer(@PathVariable("cid") Long cid) {
		List<Product> list = customerProductRepository.getProductByCustomer(cid);
		return list;
	}
	
	@GetMapping("/customer/vendor/{vid}")
	public List<Customer> getCustomerByVendor(@PathVariable("vid") Long vid) {
		List<Customer> list = customerProductRepository.getCustomerByVendor(vid);
		return list;
	}
	
	@GetMapping("/customer/category/{cid}")
	public List<Customer> getCustomerByCategory(@PathVariable("cid") Long cid) {
		List<Customer> list = customerProductRepository.getCustomerByCategory(cid);
		return list;
	}
}
