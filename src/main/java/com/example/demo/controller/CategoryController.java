package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/hello")
	public String helloAPI() {
		return "Hello Spring Rest API!!";
	}
	@PostMapping("/category")
	public void insertCategory(@RequestBody Category category) {
		categoryRepository.save(category);
	}
	@GetMapping("/category")
	public List<Category> getAllCategory() {
		List<Category> list = categoryRepository.findAll();
		return list;
	}
	@GetMapping("/category/one/{id}")
	public Category getCategoryById(@PathVariable ("id") Long id) {
		Optional<Category> optional=categoryRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("Invalid Id given..");
		Category c = optional.get();
		return c;
	}
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		categoryRepository.deleteById(id);
	}
	@PutMapping("/category/{id}")
	public Category editCategory(@PathVariable("id") Long id,@RequestBody Category newCategory) {
		Optional<Category> optional = categoryRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("Invalid id given..");
		Category oldCategory = optional.get();
		oldCategory.setName(newCategory.getName());
		oldCategory.setPref(newCategory.getPref());
		
		return categoryRepository.save(oldCategory);
	}
	@GetMapping("/category/pref/{pref}")
	public List<Category> getCategoryByPref(@PathVariable("pref") Integer pref) {
		List<Category> list = categoryRepository.getByPref(pref);
		return list;
		
	}
}
