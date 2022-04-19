package com.mindtree.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.mindtree.customer.model.Customer;


public interface CustomerService {
	
	public List<Customer> viewAllCustomers();
	
	public Optional<Customer> viewSpecificCustomer(Long id);
	
	public ResponseEntity<Object> insertCustomer(Customer customer);
	
	public void deleteSpecificCustomer(Long id);

}
