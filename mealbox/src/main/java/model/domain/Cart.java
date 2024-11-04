/*
기능: Cart
작성자: 장고은
마지막 수정일: 2024-10-09
추가해야할 기능: 페이지 이동
*/

package model.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private int cartId;
	private User userId;
	private List<CartItem> cartItems;
	private int totalPrice;
	
	// 기본 생성자
	public Cart() {
		this.cartItems = new ArrayList<>();
	}		
		
	// setter
	public void setCartId(int cartId) {this.cartId = cartId;}
	public void setUserId(User userId) {this.userId = userId;}
	public void setCartItems(List<CartItem> cartItems) {this.cartItems = cartItems;}
	public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}

	// getter
	public int getCartId() {return cartId;}
	public User getUserId() {return userId;}
	public List<CartItem> getCartItems() {return cartItems;}
	public int getTotalPrice() {return totalPrice;}
	
	// 장바구니에 담긴 모든 상품의 총 가격을 구하는 메서드
    public int getCartTotalPrice() {
        int totalPrice = 0;
        for (CartItem item : cartItems) {
        	totalPrice += item.getTotalPrice();  // 각 CartItem의 총 가격을 더함
        }
        return totalPrice;
    }
}
