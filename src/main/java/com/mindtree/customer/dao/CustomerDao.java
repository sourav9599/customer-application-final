package com.mindtree.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.customer.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

}
