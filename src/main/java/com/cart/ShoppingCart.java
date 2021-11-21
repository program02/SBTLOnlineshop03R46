package com.cart;

import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCart {
	ArrayList<ProductCart> item;
	double totalAmount;
	int totalNumberOfProduct;
	int totalCategoryOfProduct;
	double payableAmount;
	double discount;
	double taxRate;
	double tax;
	String coupon;

	ShoppingCart() {
		this.item = new ArrayList<ProductCart>();
		this.coupon = "";
		this.totalAmount = 0;
		this.payableAmount = 0;
		this.discount = 0;
		this.tax = 0.0;
	}

	public void addToCart(ProductCart p) {
		String similarFound = "no";
		ListIterator<ProductCart> iterator = item.listIterator();
		while (iterator.hasNext()) {
			ProductCart pInList = iterator.next();
			if (pInList.getName().equals(p.getName())) {
				pInList.setQuantity(pInList.getQuantity() + p.getQuantity());
				similarFound = "yes";
				break;
			}
		}
		if (similarFound.equalsIgnoreCase("no")) {
			this.item.add(p);
		}

	}

	public void removeFromCart(ProductCart p) {
		ListIterator<ProductCart> iterator1 = item.listIterator();
		while (iterator1.hasNext()) {
			ProductCart pInList = iterator1.next();

			if (pInList.getName().equals(p.getName())) {
				pInList.setQuantity(pInList.getQuantity() - 1);
				if (pInList.getQuantity() == 0) {
					this.item.remove(pInList);
				}
				break;
			}

		}

	}

	public void showCart() {
		ListIterator<ProductCart> iterator = item.listIterator();
		while (iterator.hasNext()) {
			ProductCart p = iterator.next();
			System.out.println(p);
		}
	}

	public int getTotalCategoryOfProduct() {
		totalCategoryOfProduct = this.item.size();
		return this.item.size();
	}

	public void setTotalNumberOfProduct(int totalNumberOfProduct) {
		this.totalNumberOfProduct = totalNumberOfProduct;
	}

	public int getTotalNumberOfProduct() {
		ListIterator<ProductCart> iterator2 = item.listIterator();
		this.totalNumberOfProduct = 0;
		while (iterator2.hasNext()) {
			ProductCart p = iterator2.next();
			this.totalNumberOfProduct += p.getQuantity();
		}
		return this.totalNumberOfProduct;
	}

	public double getTotalAmount() {
		ListIterator<ProductCart> iterator2 = item.listIterator();
		this.totalAmount = 0;
		while (iterator2.hasNext()) {
			ProductCart item3 = iterator2.next();
			this.totalAmount = this.totalAmount + (item3.getPrice() * item3.getQuantity());
		}
		return this.totalAmount;
	}

	public void applyCoupon(String coupon) {
		this.coupon = coupon;
		if (coupon.equals("IND10")) {
			this.discount = this.getTotalAmount() * (0.1);
			this.totalAmount = this.totalAmount - this.discount;
		} 
	}

	
	



	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getPayableAmount() {
		this.payableAmount = 0;
		this.tax = this.totalAmount * this.taxRate;
		this.payableAmount = this.totalAmount + this.tax-this.discount;
		return this.payableAmount;
	}

	public void printInvoice() {
		ListIterator<ProductCart> iterator3 = item.listIterator();
		while (iterator3.hasNext()) {
			ProductCart item4 = iterator3.next();
			System.out.print(item4.getName() + "\t");
			System.out.print(item4.getQuantity() + "\t");
			System.out.print(item4.getPrice() + "\t");
			System.out.println(item4.getPrice() * item4.getQuantity());
		}
		System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
		this.applyCoupon(this.coupon);
		System.out.println("\t\t\t" + "Discount : " + this.discount);
		this.getPayableAmount();
		System.out.println("\t\t\t" + "Tax      : " + this.tax);
		System.out.println("\t\t\t" + "Total    : " + this.payableAmount);
	}
}
