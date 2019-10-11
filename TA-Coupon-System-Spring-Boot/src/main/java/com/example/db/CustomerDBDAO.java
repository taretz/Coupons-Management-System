package com.example.db;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.beans.Customer;

@Repository
public class CustomerDBDAO {
	@Autowired
	private CustomerRepository repo;
	
	public Customer isCustomerExists(String email, String password) {
		return repo.findCustomerByEmailAndPassword(email, password);
	}
	
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	//can be used for methods 'addCouponPurchase' and 'deleteCouponPurchase'- NEED TO CHECK
	public Customer updateCustomer(Customer customer) {
		if(repo.existsById(customer.getId()))
			return repo.save(customer);
		else
			return null;			
	}
	
	public void deleteCustomer(Customer customer) {
		repo.delete(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return repo.findAll();
	}
	
	public Customer getCustomerById(int id) {
		Optional<Customer> opt= repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

	
}
