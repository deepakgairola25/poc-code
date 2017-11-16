package com.shoppingcart.coding.discount;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.shoppingcart.coding.entity.Item;

/**
 * Discount service interface
 * 
 * @author Deepak Gairola
 *
 */
@Service
public interface DiscountService {
	public BigDecimal apply(Item item, int quantity);
}
