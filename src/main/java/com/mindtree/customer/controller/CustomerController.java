package com.mindtree.customer.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.customer.model.Customer;
import com.mindtree.customer.service.CustomerService;

@RestController
public class CustomerController{
	
	@Autowired
	CustomerService service;
    
    @GetMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/#/customer-controller");
    }
    
	@GetMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return service.viewAllCustomers();
	}
	
	@GetMapping("/customers/{id}")
	 public Optional<Customer> getCustomer( @PathVariable Long id)
	 {
		return service.viewSpecificCustomer(id);
	 }
	
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer)
	{
		return service.insertCustomer(customer);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer( @PathVariable Long id)
	 {
		service.deleteSpecificCustomer(id);
	 }

}
