package com.cart;

public class Customer {
	int id;
	String firstname;
	String lastname;
	String address1;
	String division;
	String city;
	String area;
	String country;
	String phone;
	String email;
	String password;
	public Customer() {
		super();
	}
	public Customer(int id) {
		super();
		this.id = id;
	}
	public Customer(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	public Customer(int id, String firstname, String lastname, String address1, String division, String city,
			String area, String country, String phone, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.division = division;
		this.city = city;
		this.area = area;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address1=" + address1
				+ ", division=" + division + ", city=" + city + ", area=" + area + ", country=" + country + ", phone="
				+ phone + ", email=" + email + ", password=" + password + "]";
	}

	
	
	
}
