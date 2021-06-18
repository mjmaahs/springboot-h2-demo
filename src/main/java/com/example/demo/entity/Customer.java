package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "customer_type")
	private int customerType;
	@Column(name = "customer_since")
	private Date customerSince;

	public Customer() {
		super();
	}

	public Customer(String username, int customerType, Date customerSince) {
		this.username = username;
		this.customerType = customerType;
		this.customerSince = customerSince;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getCustomerType() {
		return customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public Date getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", customerType=" + customerType + ", customerSince="
				+ customerSince + "]";
	}

}
