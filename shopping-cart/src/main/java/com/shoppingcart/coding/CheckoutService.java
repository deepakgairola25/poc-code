package com.shoppingcart.coding;

import org.springframework.stereotype.Service;

import com.shoppingcart.coding.entity.Order;

/**
 * This is a checkout service interface
 * 
 * @author Deepak Gairola
 *
 */
@Service
public interface CheckoutService {
	public void checkout(Order order);

}
