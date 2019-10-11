package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.beans.Company;
import com.example.beans.Coupon;
import com.example.exceptions.CantUpdateCompanyIdException;
import com.example.exceptions.CouponTitleAlreadyExistsException;

@Service
public class CompanyService extends ClientService {
	private int companyId;

	@Override
	public boolean login(String email, String password) {
		if (companyDB.isCompanyExists(email, password) != null)
			return true;
		else
			return false;
	}

	/**
	 * A method to add a new coupon to the db. <br/>
	 * Restrictions:<br/>
	 * 1. All company's coupons must have unique titles.<br/>
	 * 
	 * @param coupon - The coupon to add.
	 * @return - true if the coupon added successfully.
	 * @throws CouponTitleAlreadyExistsException
	 */
	public boolean addCoupon(Coupon coupon) throws CouponTitleAlreadyExistsException {
		List<Coupon> allCompanyCoupons = couponDB.getCouponByCompanyId(coupon.getCompany().getId());
		for (Coupon coupon2 : allCompanyCoupons) {
			if (coupon.getTitle().equals(coupon2.getTitle()))
				throw new CouponTitleAlreadyExistsException();
		}
		couponDB.addCoupon(coupon);
		return true;
	}

	/**
	 * A method to update an existing coupon in the db. <br/>
	 * Restrictions:<br/>
	 * 1. Changing the coupon's id is forbidden. <br/>
	 * 2. Changing the coupon's company_id is forbidden.
	 * 
	 * @param coupon
	 * @return - true if the coupon updated successfully.
	 * @throws CantUpdateCompanyIdException
	 */
	public boolean updateCoupon(Coupon coupon) throws CantUpdateCompanyIdException {
		Coupon tempCoupon = couponDB.getCouponById(coupon.getId());
		if (tempCoupon.getCompany().getId() != coupon.getCompany().getId())
			throw new CantUpdateCompanyIdException();
		else {
			couponDB.updateCoupon(coupon);
			return true;
		}
	}

	/**
	 * A method to delete a coupon.
	 * @param couponId - the id of the coupon to delete.
	 * @return number of rows affected
	 */
	public int deleteCoupon(int couponId) {
		Coupon couponToDelete = couponDB.getCouponById(couponId);
		Company owningCompany = companyDB.getCompanyById(couponToDelete.getCompany().getId());
		owningCompany.removeCoupon(couponToDelete.getId());
		int countBefore = couponDB.countRows();
		companyDB.updateCompany(owningCompany);
		int countAfter = couponDB.countRows();
		return countBefore - countAfter;
	}

	/**
	 * A method to delete a coupon.
	 * @param coupon - the coupon object to delete.
	 * @return number of rows affected
	 */
	public int deleteCoupon(Coupon coupon) {
		Company owningCompany = coupon.getCompany();
		owningCompany.removeCoupon(coupon.getId());//remove the coupon from the Company's list of coupons.
		int countBefore = couponDB.countRows();
		companyDB.updateCompany(owningCompany);
		int countAfter = couponDB.countRows();
		return countBefore - countAfter;
	}


}
