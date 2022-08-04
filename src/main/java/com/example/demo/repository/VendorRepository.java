package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long>{

	@Query("select v from Vendor v where LOWER(v.city)=LOWER(?1)")
	List<Vendor> getByCity(String city);

	

}
