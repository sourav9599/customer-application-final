package com.mindtree.customer.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mindtree.customer.dao.CustomerDao;
import com.mindtree.customer.exceptions.UserNotFoundException;
import com.mindtree.customer.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao repository;
	@Override
	public List<Customer> viewAllCustomers() {
		
		return repository.findAll();
	}

	@Override
	public Optional<Customer> viewSpecificCustomer(Long id) {
		
		Optional<Customer> customer = repository.findById(id);
		if(!customer.isPresent())
			throw new UserNotFoundException("id :" + id);
		return customer;
	}

	@Override
	public ResponseEntity<Object> insertCustomer(Customer customer) {
		Customer createdUser = repository.save(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public void deleteSpecificCustomer(Long id) {
		
		repository.deleteById(id);
	}

}
