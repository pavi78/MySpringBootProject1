package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("select c from Category c where pref=?1")
	List<Category> getByPref(Integer pref);

}
