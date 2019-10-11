package com.example.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	Customer findCustomerByEmailAndPassword(String email, String password);

	
}
