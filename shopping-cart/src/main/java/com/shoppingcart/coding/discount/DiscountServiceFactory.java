package com.shoppingcart.coding.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Discount service factory
 * 
 * @author Deepak Gairola
 *
 */
@Component
public class DiscountServiceFactory {

	@Autowired
	private One4OneDiscount one4OneDiscount;

	@Autowired
	private PromotionalPriceDiscount promotionalPriceDiscount;

	/**
	 * Based on the discount type of the item this method return the discount
	 * service.
	 * 
	 * @param discountType
	 * @return
	 */
	public DiscountService getDiscountServive(DiscountType discountType) {
		switch (discountType) {
		case ONE4ONE:
			return one4OneDiscount;
		case PROMOTIONAL:
			return promotionalPriceDiscount;
		case NONE:
		default:
			return null;
		}
	}

	public One4OneDiscount getOne4OneDiscount() {
		return one4OneDiscount;
	}

	public void setOne4OneDiscount(One4OneDiscount one4OneDiscount) {
		this.one4OneDiscount = one4OneDiscount;
	}

	public PromotionalPriceDiscount getPromotionalPriceDiscount() {
		return promotionalPriceDiscount;
	}

	public void setPromotionalPriceDiscount(PromotionalPriceDiscount promotionalPriceDiscount) {
		this.promotionalPriceDiscount = promotionalPriceDiscount;
	}

}
