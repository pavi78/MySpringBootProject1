package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public void insertCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
		customerRepository.deleteById(id);
	}
	
	@PutMapping("/customer/{id}")
	public Customer editCustomer(@PathVariable("id") Long id,@RequestBody Customer newCustomer) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("Invalid id given..");
		Customer oldCustomer = optional.get();
		oldCustomer.setName(newCustomer.getName());
		oldCustomer.setCity(newCustomer.getCity());
		oldCustomer.setAge(newCustomer.getAge());
		
		return customerRepository.save(oldCustomer);
	}
}
