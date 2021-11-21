package com.cart;

import java.sql.Date;

public class Employee {
	int id;
	String name;
	String email;
	String password;
	String designation;
	String phone;
	Date joindate;

	public Employee() {
		super();
	}

	public Employee(int id) {
		super();
		this.id = id;
	}

	public Employee(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Employee(int id, String name, String email, String password, String designation, String phone, Date joindate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.designation = designation;
		this.phone = phone;
		this.joindate = joindate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", designation="
				+ designation + ", phone=" + phone + ", joindate=" + joindate + "]";
	}

}
