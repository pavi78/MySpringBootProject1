package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerProduct;
import com.example.demo.model.Product;

public interface CustomerProductRepository extends JpaRepository<CustomerProduct, Long> {

	@Query("select cp.customer from CustomerProduct cp where cp.product.id=?1")
	List<Customer> getCustomerByProduct(Long pid);

	@Query("select cp.product from CustomerProduct cp where cp.customer.id=?1")
	List<Product> getProductByCustomer(Long cid);

	@Query("select cp.customer from CustomerProduct cp where cp.product.vendor.id=?1")
	List<Customer> getCustomerByVendor(Long vid);

	@Query("select cp.customer from CustomerProduct cp where cp.product.category.id=?1")
	List<Customer> getCustomerByCategory(Long cid);

}
