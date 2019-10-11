package com.example.exceptions;

public class CantChangeCompanyNameException extends Exception {

	public CantChangeCompanyNameException() {
		super("Changing the company's name is not allowed!");
	}
	

}
