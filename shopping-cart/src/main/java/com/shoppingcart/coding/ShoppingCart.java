package com.shoppingcart.coding;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.shoppingcart.AppConfig;
import com.shoppingcart.coding.entity.Order;

/**
 * This is the main class representing shopping cart
 * 
 * @author Deepak Gairola
 *
 */
public class ShoppingCart {

	public static void main(String[] args) {
		// Initializing the spring application context
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CheckoutService checkoutService = context.getBean(CheckoutServiceImpl.class);
		// Reading Items from Json file
		String filePath = "src/main/resources/multiple.json";
		Order myOrder = new Order();
		myOrder.addItem(new ListReader().read(filePath));
		// Checkout service
		checkoutService.checkout(myOrder);
		System.out.println(myOrder);
		if (context != null) {
			context.close();
			context = null;
		}
	}
}
