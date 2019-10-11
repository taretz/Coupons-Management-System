package com.example.exceptions;

public class CouponTitleAlreadyExistsException extends Exception {
	public CouponTitleAlreadyExistsException() {
		super("There is already a coupon with the same title. 2 coupons with the same title is not allowed");
	}

}
