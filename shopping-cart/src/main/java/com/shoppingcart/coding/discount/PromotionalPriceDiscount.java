package com.shoppingcart.coding.discount;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.shoppingcart.coding.entity.Item;

/**
 * Buy 3 identical items and receive a promotional price discount service
 * 
 * @author Deepak Gairola
 *
 */
@Service
public class PromotionalPriceDiscount implements DiscountService {

	public static final String description = "Buy 3 identical items and receive a promotional price";
	private static final int minimumItemQuantity = 3;
	private static final int promotionalItemQuantity = 2;

	@Override
	public BigDecimal apply(Item item, int quantity) {
		if (item.getDiscountType().equals(DiscountType.PROMOTIONAL) && quantity >= minimumItemQuantity) {
			final BigDecimal discountPrice = item.getPrice()
					.multiply(new BigDecimal(quantity).subtract((new BigDecimal(quantity / minimumItemQuantity)
							.multiply(new BigDecimal(promotionalItemQuantity))
							.add(new BigDecimal(quantity % minimumItemQuantity)))));
			return discountPrice;
		}
		return null;

	}

}
