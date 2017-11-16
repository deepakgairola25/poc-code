package com.shoppingcart.coding;

/**
 * 
 * @author Deepak Gairola
 *
 */
public class MalformedListException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4524674041558423075L;

	public MalformedListException(Exception e) {
		super(e);
	}
}
