package com.cart;

public class ShoppingcartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductCart i1 = new ProductCart("Olive Oil 1l", 100.0);
		ProductCart i2 = new ProductCart("Cheese Slices",  50.0);
		ProductCart i3 = new ProductCart("Bread", 75.0);
		ProductCart i4 = new ProductCart("Eggs",  10.0);
		ProductCart i5 = new ProductCart("Chicken Salami",8, 100.0);
		ProductCart i6 = new ProductCart("Olive Oil 12", 100.0);
	    ShoppingCart cart = new ShoppingCart();
	    
	    cart.addToCart(i1);
	    cart.addToCart(i2);
	    cart.addToCart(i3);
	    cart.addToCart(i4);
	    cart.addToCart(i5);
	    cart.addToCart(i1);
	    cart.addToCart(i1);cart.addToCart(i1);cart.addToCart(i1);
	    cart.addToCart(i6);
	    
	    //cart.showCart();
	    
	    /* remove the item sent as argument from the cart */
	    cart.removeFromCart(i1);  
	    System.out.println(cart.getTotalNumberOfProduct());
	    //cart.totalNumberOfProduct();

	    
	    /*
	     * shows the list of items in the cart with quantity
	     * Expected Output to the console:
	     * Olive Oil 1l: 3
	     * Cheese Slices: 2
	     * Eggs: 50
	     * Chicken Salami: 2
	     */
	    //cart.showCart();

	    /*
	     * gets the total amount for the items in the cart
	     * Expected Output:
	     * 1100
	     */
	    cart.setTaxRate(0.15);
	    cart.setDiscount(0);
	    double totalAmount = cart.getTotalAmount();
	    System.out.println(totalAmount);
	    System.out.println(cart.discount);
	    System.out.println(cart.taxRate);


	    /*
	     * Gets the payable amount,
	     * it deduct discount and add tax to the total amount of items in cart
	     * Expected Output:
	     * 1254
	     */
	    double payableAmount = cart.getPayableAmount();
	    System.out.println(payableAmount);    

	    /* apply a coupon code */
	    //cart.applyCoupon("IND50");
	    
	    /* 
	     * print the items with the quanity, unit price, total amount
	     * apply coupon if valid 
	     * add tax to the total amount after discount
	     * Expected Output to the console:
	     * Olive Oil 1l      3    100.00    300.00 
	     * Cheese Slices     2     50.00    100.00
	     * Eggs             50     10.00    500.00
	     * Chicken Salami    2    100.00    200.00
	     *                          Total: 1100.00
	     *                          Disc%:    0.00
	     *                          Tax:    154.00
	     *                          Total: 1254.00
	     *
	     */
	   cart.printInvoice();

	    //cart.applyCoupon("IND10");

	    /* 
	     * print the items with the quanity, unit price, total amount
	     * apply coupon if valid 
	     * add tax to the total amount after discount
	     * Expected Output to the console:
	     * Olive Oil 1l      3    100.00    300.00 
	     * Cheese Slices     2     50.00    100.00
	     * Eggs             50     10.00    500.00
	     * Chicken Salami    2    100.00    200.00
	     *                          Total: 1100.00
	     *                          Disc%:  110.00
	     *                          Tax:    154.00
	     *                          Total: 1128.60
	     *
	     */
	    //cart.printInvoice();

	    //cart.addToCart(new Product("Milk", 5, 30.00));
	    /* 
	     * print the items with the quanity, unit price, total amount
	     * apply coupon if valid 
	     * add tax to the total amount after discount
	     * Expected Output to the console:
	     * Olive Oil 1l      3    100.00    300.00 
	     * Cheese Slices     2     50.00    100.00
	     * Eggs             50     10.00    500.00
	     * Chicken Salami    2    100.00    200.00
	     * Milk              5     30.00    150.00
	     *                          Total: 1250.00
	     *                          Disc%:  125.00
	     *                          Tax:    157.50
	     *                          Total: 1282.50
	     *
	     */
	    //cart.printInvoice();
	    
	}

}
