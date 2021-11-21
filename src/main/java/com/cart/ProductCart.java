package com.cart;

import java.sql.Date;

public class ProductCart {
	int id;
	String name;
	String brand;
	double price;
	Date edate;
	int stock;
	String category;
	String imgurl1;
	//addtocart purpose
	int quantity;



	public ProductCart(String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = 1;
	}

	public ProductCart(String name, int quantity, double price) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public ProductCart() {
		super();
	}

	public ProductCart(int id) {
		super();
		this.id = id;
	}

	public ProductCart(int id, String name, String brand, double price, Date edate, int stock, String category,
			String imgurl1) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.edate = edate;
		this.stock = stock;
		this.category = category;
		this.imgurl1 = imgurl1;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getEdate() {
		return edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgurl1() {
		return imgurl1;
	}

	public void setImgurl1(String imgurl1) {
		this.imgurl1 = imgurl1;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
		String s = this.name + ": "  + this.quantity + "\n";
		return s;
	}


}
