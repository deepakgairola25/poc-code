package com.shoppingcart.coding.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shoppingcart.coding.discount.DiscountType;

/**
 * class representing Items
 * 
 * @author Deepak Gairola
 *
 */
public final class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -89326185583136768L;
	private final String name;
	private final BigDecimal price;
	private final DiscountType discountType;

	@JsonCreator
	public Item(@JsonProperty("name") String name, @JsonProperty("price") BigDecimal price,
			@JsonProperty("discountType") DiscountType discountType) {
		this.name = name;
		this.price = price;
		this.discountType = discountType;

	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discountType == null) ? 0 : discountType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (discountType != other.discountType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", discountType=" + discountType + ", price= £" + price + "] ";
	}

}
