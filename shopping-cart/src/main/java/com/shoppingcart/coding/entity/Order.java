package com.shoppingcart.coding.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Order class
 * @author Deepak Gairola
 *
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4822146390001190159L;
	private Map<Item, Integer> items;
	private BigDecimal totalPrice;
	private BigDecimal discountPrice;

	public Order() {
		this.items = new HashMap<Item, Integer>();
		this.totalPrice = new BigDecimal(0.0d);
		this.discountPrice = new BigDecimal(0.0d);
	}

	/**
	 * Add Item to Order
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		if (this.items.containsKey(item)) {
			this.items.compute(item, (p, q) -> Integer.valueOf(q + 1));
		} else {
			items.put(item, 1);
		}
		totalPrice = totalPrice.add(item.getPrice());
	}

	/**
	 * Add Item to Order
	 * 
	 * @param item
	 */
	public void addItem(List<Item> items) {
		items.forEach(item -> {
			if (this.items.containsKey(item)) {
				this.items.compute(item, (p, q) -> Integer.valueOf(q + 1));
			} else {
				this.items.put(item, 1);
			}
			totalPrice = totalPrice.add(item.getPrice());
		});
	}

	/**
	 * remove Item from order
	 * 
	 * @param item
	 */
	public void removeItem(Item item) {
		if (this.items.containsKey(item)) {
			this.items.compute(item, (p, q) -> Integer.valueOf(q - 1));
		} else {
			items.remove(item);
		}
		totalPrice = totalPrice.subtract(item.getPrice());
	}

	/**
	 * Overall discount Price
	 * 
	 * @param val
	 */
	public void computeDiscountedPrice(BigDecimal discountPrice) {
		this.discountPrice = this.discountPrice.add(discountPrice);
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * Get order total price
	 * 
	 * @return
	 */
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public Map<Item, Integer> getItems() {
		return Collections.unmodifiableMap(items);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		this.items.forEach((item, quantity) -> stringBuilder.append(item.getName()).append(", quantity=")
				.append(quantity).append(" , total Price= £").append(item.getPrice().multiply(new BigDecimal(quantity)))
				.append("\n"));
		stringBuilder.append("Total £ ").append(totalPrice).append("\n").append("Discount of £ ").append(discountPrice)
				.append("\n").append("Total after discount: £").append(totalPrice.subtract(discountPrice));
		// TODO Auto-generated method stub
		return stringBuilder.toString();
	}

}
