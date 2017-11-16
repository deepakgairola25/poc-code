package com.shoppingcart.coding;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.coding.discount.DiscountServiceFactory;
import com.shoppingcart.coding.entity.Order;

/**
 * 
 * @author Deepak Gairola
 *
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private DiscountServiceFactory discountServiceFactory;

	/**
	 * This method is responsible to checkout the Items and apply any discount if
	 * applicable
	 */
	@Override
	public void checkout(Order order) {
		order.getItems().forEach((item, quantity) -> {
			final BigDecimal discountPrice;
			discountPrice = discountServiceFactory.getDiscountServive(item.getDiscountType()) == null ? null
					: discountServiceFactory.getDiscountServive(item.getDiscountType()).apply(item, quantity);
			if (discountPrice != null) {
				order.computeDiscountedPrice(discountPrice);
			}
		});
	}

	public DiscountServiceFactory getDiscountServiceFactory() {
		return discountServiceFactory;
	}

	public void setDiscountServiceFactory(DiscountServiceFactory discountServiceFactory) {
		this.discountServiceFactory = discountServiceFactory;
	}
}
