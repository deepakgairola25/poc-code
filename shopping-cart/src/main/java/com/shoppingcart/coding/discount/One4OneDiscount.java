package com.shoppingcart.coding.discount;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.shoppingcart.coding.entity.Item;

/**
 * Buy one get one discount service
 * 
 * @author Deepak Gairola
 *
 */
@Service
public class One4OneDiscount implements DiscountService {

	private static final int minimumItemQuantity = 2;
	public static final String description = "Buy one get one free discount";

	@Override
	public BigDecimal apply(Item item, int quantity) {
		if (item.getDiscountType().equals(DiscountType.ONE4ONE) && quantity >= minimumItemQuantity) {
			final BigDecimal discountPrice = item.getPrice()
					.multiply(new BigDecimal(quantity).divide(new BigDecimal("2")));
			return discountPrice;
		}
		return null;
	}

}
