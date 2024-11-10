/*
기능: CartProduct
작성자: 장고은
마지막 수정일: 2024-11-10
*/
package model.domain;

public class CartProduct {
	private int userId;
	private int productId;
	private int quantity;
	private int cartItemPrice;
	
	public CartProduct() {}
	
	public CartProduct(int userId, int productId, int quantity, int cartItemPrice) {
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.cartItemPrice = cartItemPrice;
	}
	
	public CartProduct(int productId, int quantity, int cartItemPrice) {
		this.productId = productId;
		this.quantity = quantity;
		this.cartItemPrice = cartItemPrice;
	}
	
	// setter & getter
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCartItemPrice() {
		return cartItemPrice;
	}

	public void setCartItemPrice(int cartItemPrice) {
		this.cartItemPrice = cartItemPrice;
	}

	@Override
	public String toString() {
		return "CartProduct [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity
				+ ", cartItemPrice=" + cartItemPrice + "]";
	}
}