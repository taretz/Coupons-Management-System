package com.example.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.beans.Company;
import com.example.beans.Coupon;

@Repository
public class CouponDBDAO {
	@Autowired
	private CouponRepository repo;
	
	public Coupon addCoupon(Coupon coupon) {
		return repo.save(coupon);
	}
	
	public Coupon updateCoupon(Coupon coupon) {
		if(repo.existsById(coupon.getId()))
			return repo.save(coupon);
		else
			return null;			
	}
	
	public int deleteCoupon(Coupon coupon) {
		long countBefore = repo.count();
		repo.delete(coupon);
		long countAfter = repo.count();
		return (int) ((int)countBefore-countAfter);
	}
	
	public int deleteCoupon(int couponId) {
		long countBefore = repo.count();
		System.out.println(countBefore);
		repo.deleteById(couponId);
		long countAfter = repo.count();
		System.out.println(countAfter);
		return (int) ((int)countBefore-countAfter);
	}
	
	public List<Coupon> getAllCoupons(){
		return repo.findAll();
	}
	
	public Coupon getCouponById(int id) {
		Optional<Coupon> opt= repo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}

	public List<Coupon> getCouponByCompanyId(int companyId){
		return repo.findCouponByCompanyId(companyId);
}

//	public Company getCompanyByCoupon(Coupon coupon) {
//		return repo.findCompanyByCoupon(coupon);
//	}
	
//	public int getCompanyByCouponId(int couponId) {
//		return repo.findCompany_idById(couponId);
//	}
	
	public int countRows() {
		return (int) repo.count();
	}

}
