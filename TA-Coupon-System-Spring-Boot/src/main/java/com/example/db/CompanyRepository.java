package com.example.db;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.beans.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	Company findCompanyByEmailAndPassword(String email, String password);
	
	

}
