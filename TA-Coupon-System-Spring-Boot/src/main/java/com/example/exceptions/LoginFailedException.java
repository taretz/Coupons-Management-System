package com.example.exceptions;

public class LoginFailedException extends Exception {
	public LoginFailedException() {
		super("Wrong email or password!");
	}

}
