package com.example.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.Company;
import com.example.beans.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer>{
	
	List<Coupon> findCouponByCompanyId(int companyId);
	
	//Company findCompanyByCoupon(Coupon coupon);
	
	Company findCompanyById(int couponId);
	
	Coupon findCompany_idById(int Id);
}
