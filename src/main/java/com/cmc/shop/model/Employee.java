package com.cmc.shop.model;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@javax.persistence.Entity
public class Employee {
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Id
	   private String user_id;
	   private String user_name;
	   private float user_slary;
	   @JsonFormat
	   (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	   @DateTimeFormat(pattern = "dd/MM/yyyy")
	   private Date user_join;
	   private String user_phone;
	   private String user_address;
      
	   public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String user_id, String user_name, float user_slary, Date user_join, String user_phone,
			String user_address) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_slary = user_slary;
		this.user_join = user_join;
		this.user_phone = user_phone;
		this.user_address = user_address;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public float getUser_slary() {
		return user_slary;
	}

	public void setUser_slary(float user_slary) {
		this.user_slary = user_slary;
	}

	public Date getUser_join() {
		return user_join;
	}

	public void setUser_join(Date user_join) {
		this.user_join = user_join;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	
	

}
