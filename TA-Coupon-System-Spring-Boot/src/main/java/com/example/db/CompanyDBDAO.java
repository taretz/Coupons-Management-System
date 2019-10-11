package com.example.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.beans.Company;
import com.example.beans.Coupon;

@Repository
public class CompanyDBDAO {
	@Autowired
	private CompanyRepository repo;

	public Company isCompanyExists(String email, String password) {
		return repo.findCompanyByEmailAndPassword(email, password);
	}

	public Company addCompany(Company company) {
		return repo.save(company);
	}

	public Company updateCompany(Company company) {
		if(repo.existsById(company.getId()))
			return repo.save(company);
		else
			return null;
	}

	public void deleteCompany(Company company) {
		repo.delete(company);
	}

	public Company getCompanyById(int id) {
		Optional<Company> opt = repo.findById(id);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

	public List<Company> getAllCompanies() {
		return repo.findAll();
	}


}
