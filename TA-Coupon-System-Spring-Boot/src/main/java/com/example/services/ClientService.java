package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.db.CompanyDBDAO;
import com.example.db.CouponDBDAO;
import com.example.db.CustomerDBDAO;

@Service
public abstract class ClientService {
	@Autowired
	protected CustomerDBDAO customerDB;
	@Autowired
	protected CompanyDBDAO companyDB;
	@Autowired
	protected CouponDBDAO couponDB;

	public abstract boolean login(String email, String password);

	@Override
	public String toString() {
		return "ClientService [customerDB=" + customerDB + ", companyDB=" + companyDB + ", couponDB=" + couponDB + "]";
	}
	
	
	
	
	

}
