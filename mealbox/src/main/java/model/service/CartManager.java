package model.service;

import java.util.Iterator;

import model.domain.Cart;
import model.domain.CartItem;

public class CartManager {
	// 장바구니의 총 금액을 계산하는 메서드
    public static int calculateTotalPrice(Cart cart) {
        return cart.getCartTotalPrice();  // Cart의 총 가격을 계산
    }
    
    // 수량 업데이트 메서드
    public static void updateCartItemQuantity(Cart cart, String productName, int newQuantity) {
        for (CartItem item : cart.getCartItems()) {
            //if (item.getProduct().getName().equals(productName)) {
                item.setQuantity(newQuantity);  // 수량 업데이트
                break;
           // }
        }
    }

    // 장바구니 항목 삭제 메서드
    public static void removeCartItem(Cart cart, String productName) {
        Iterator<CartItem> iterator = cart.getCartItems().iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            //if (item.getProduct().getName().equals(productName)) {
                iterator.remove();  // 해당 항목 삭제
                break;
            //}
        }
    }
}
