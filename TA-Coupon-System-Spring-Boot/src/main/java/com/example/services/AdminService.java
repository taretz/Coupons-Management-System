package com.example.services;

import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.beans.Company;
import com.example.beans.Coupon;
import com.example.beans.Customer;
import com.example.exceptions.CantChangeCompanyNameException;

@Service
public class AdminService extends ClientService {

	public boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;
		else
			return false;
	}

	/**
	 * A method to add a new company. <br/>
	 * Restrictions: <br/>
	 * 1. Company's name must be unique. <br/>
	 * 2. Company's email must be unique.
	 * @param company
	 * @return Company object if the add operation was successful.
	 */
	public Company addCompany(Company company) {
		return companyDB.addCompany(company);
	}

	/**
	 * A method to update an existing company. <br/>
	 * Restrictions:<br/> 
	 * 1. Company's name can not be changed!<br/>
	 * 2. Company's id can not be changed - enforced by sql server.
	 * @param company
	 * @return Company object if the update operation was successful.
	 * @throws CantChangeCompanyNameException
	 */
	public Company updateCompany(Company company) throws CantChangeCompanyNameException {
		if(!company.getName().equals(getOneCompany(company.getId()).getName())) {
			throw new CantChangeCompanyNameException();
		}
		return companyDB.updateCompany(company);
	}

	/**
	 * A method to delete an existing company.
	 * @param company
	 */
	public void deleteCompany(Company company) {
		companyDB.deleteCompany(company);
	}

	/**
	 * A method to retrieve all of the existing companies.
	 * @return List of Company object.
	 */
	public List<Company> getAllCompanies(){
		return companyDB.getAllCompanies();
	}
	
	/**
	 * A method to retrieve one company.
	 * @param companyID - the company's id.
	 * @return Company object.
	 */
	public Company getOneCompany(int companyID) {
		return companyDB.getCompanyById(companyID);
	}

	/**
	 * A method to add a new customer. 
	 * Restrictions:<br/>
	 * 1. Customer's email must be unique.
	 * @param customer - the customer to add.
	 * @return Customer object if the add operation was successful.
	 */
	public Customer addCustomer(Customer customer) {
		return customerDB.addCustomer(customer);
	}

	/**
	 * A method to update an existing customer. <br/>
	 * Restrictions:<br/>
	 * 1. Customer's id can not be changed!
	 * If one tries to change the customer's id, an SQL Exception will be thrown because id is primary key
	 * @param customer - the customer to update.
	 *
	 * @return Customer object after update has been executed.
	 */
	public Customer updateCustomer(Customer customer) {
		return customerDB.updateCustomer(customer);
	}

	/**
	 * A method to delete an existing customer. <br/>
	 * 
	 * @param customer
	 */
	public void deleteCustomer(Customer customer) {
		List<Coupon> couponsToRemove = customer.getCoupons();
		customer.getCoupons().removeAll(couponsToRemove);
		customerDB.updateCustomer(customer);
		customerDB.deleteCustomer(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return customerDB.getAllCustomers();
	}
	
	public Customer getCustomerById(int id) {
		return customerDB.getCustomerById(id);
	}
}



