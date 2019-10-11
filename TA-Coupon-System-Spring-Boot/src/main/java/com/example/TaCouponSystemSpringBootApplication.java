package com.example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.beans.Category;
import com.example.beans.Company;
import com.example.beans.Coupon;
import com.example.db.CompanyDBDAO;
import com.example.db.CouponDBDAO;
import com.example.services.AdminService;
import com.example.services.CompanyService;

@SpringBootApplication
public class TaCouponSystemSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TaCouponSystemSpringBootApplication.class, args);
		CompanyDBDAO companyDB = ctx.getBean(CompanyDBDAO.class);
		CouponDBDAO couponDB = ctx.getBean(CouponDBDAO.class);
		AdminService adminS = ctx.getBean(AdminService.class);
		CompanyService compSrv = ctx.getBean(CompanyService.class);
		System.out.println(compSrv.deleteCoupon(3));
		//System.out.println(companyDB.addCompany(new Company("HTC", "htc@htc.com", "123")));
		//System.out.println(companyDB.getCompanyById(1).toString());
		//System.out.println(comp.toString());
		//List<Coupon> coupons =new ArrayList<Coupon>();
		//Coupon coupon = new Coupon(100,comp, "Holiday Gift", "Various gifts for rosh hashana", Category.Food, Date.valueOf("2019-9-25"), Date.valueOf("2019-10-10"), 50);
		//couponDB.addCoupon(coupon);
		

		
	}

}
