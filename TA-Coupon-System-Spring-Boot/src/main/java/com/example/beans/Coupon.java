package com.example.beans;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Coupons")
@Component
@Scope("prototype")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column
	private int amount;
	@ManyToOne(optional = false)
	@JoinColumn(name = "company_id")
	private Company company;
	@NotEmpty
	@Column
	private String title, description;
	@Column
	private String image;
	@NotEmpty
	@Column
	private Category category;
	@NotEmpty
	@Column
	private Date startDate, endDate;
	@NotEmpty
	@Column
	private double price;

	// CONSTRUCTORS
	public Coupon() {
		super();
	}

	public Coupon(int id, int amount, Company company, String title, String description, Category category,
			Date startDate, Date endDate, double price) {
		super();
		this.id = id;
		this.amount = amount;
		this.company = company;
		this.title = title;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public Coupon(int id, int amount, Company company, String title, String description, String image,
			Category category, Date startDate, Date endDate, double price) {
		super();
		this.id = id;
		this.amount = amount;
		this.company = company;
		this.title = title;
		this.description = description;
		this.image = image;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public Coupon(int amount, Company company, String title, String description, Category category, Date startDate,
			Date endDate, double price) {
		super();
		this.amount = amount;
		this.company = company;
		this.title = title;
		this.description = description;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	// GETTERS/SETTERS
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public Company getCompany() {
		return company;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", companyId=" + company.getId() + ", amount=" + amount + ", title=" + title
				+ ", description=" + description + ", image=" + image + ", category=" + category + ", startDate="
				+ startDate + ", endDate=" + endDate + ", price=" + price + "]";
	}

}
