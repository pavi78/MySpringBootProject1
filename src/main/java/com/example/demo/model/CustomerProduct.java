package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_product")
public class CustomerProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate dateOfpurchase;
	
	private Boolean couponUsed;
	
	private String couponCode;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Product product;

	public CustomerProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerProduct(Long id, LocalDate dateOfpurchase, Boolean couponUsed, String couponCode, Customer customer,
			Product product) {
		super();
		this.id = id;
		this.dateOfpurchase = dateOfpurchase;
		this.couponUsed = couponUsed;
		this.couponCode = couponCode;
		this.customer = customer;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOfpurchase() {
		return dateOfpurchase;
	}

	public void setDateOfpurchase(LocalDate dateOfpurchase) {
		this.dateOfpurchase = dateOfpurchase;
	}

	public Boolean getCouponUsed() {
		return couponUsed;
	}

	public void setCouponUsed(Boolean couponUsed) {
		this.couponUsed = couponUsed;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "CustomerProduct [id=" + id + ", dateOfpurchase=" + dateOfpurchase + ", couponUsed=" + couponUsed
				+ ", couponCode=" + couponCode + ", customer=" + customer + ", product=" + product + "]";
	}
	
}
