package com.example.exceptions;

public class CantUpdateCompanyIdException extends Exception {
	public CantUpdateCompanyIdException() {
		super("Changing a coupon's company_id is not allowed!");
	}

}
