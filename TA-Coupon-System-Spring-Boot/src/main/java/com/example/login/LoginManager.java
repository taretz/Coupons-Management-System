package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import com.example.exceptions.LoginFailedException;
import com.example.services.AdminService;
import com.example.services.ClientService;

@Component
public class LoginManager {
	@Autowired
	private ConfigurableApplicationContext ctx;
	
	public ClientService login(String email,String password, ClientType type) throws LoginFailedException {
		switch (type) {
		case Admin:
			AdminService adminService = ctx.getBean(AdminService.class);
			if(adminService.login(email, password))
				return adminService;
			else
				throw new LoginFailedException();
		case Company:
			
			//TODO
			
		case Customer:
			
			//TODO

		default:
			return null;
	
		}
		
	}
	

}
