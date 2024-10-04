/*
기능: 장바구니 페이지 manager class
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package model.dao;

import model.domain.Cart;
import java.util.ArrayList;
import java.util.List;

public class CartManager {

    // 싱글턴 인스턴스
    private static CartManager instance = new CartManager();

    // 장바구니에 담긴 상품 리스트
    private List<Cart> products = new ArrayList<>();

    // private 생성자
    private CartManager() {
        // 장바구니에 초기 상품 추가 (테스트용)
        products.add(new Cart("상품명1", 1, 13000));
        products.add(new Cart("상품명2", 1, 13000));
        products.add(new Cart("상품명3", 4, 48000));
        products.add(new Cart("상품명4", 4, 48000));
    }

    // 싱글턴 인스턴스를 반환하는 메서드
    public static CartManager getInstance() {
        return instance;
    }

    // 상품 리스트를 반환하는 메서드
    public List<Cart> getCartItems() {
        return products;
    }

    // 총 결제 금액을 계산하는 메서드
    public int calculateTotalPrice(List<Cart> products) {
        return products.stream().mapToInt(Cart::getTotalPrice).sum();
    }

    // 상품 수량을 업데이트하는 메서드
    public void updateCartItemQuantity(String productName, int newQuantity) {
        for (Cart cart : products) {
            if (cart.getName().equals(productName)) {
                cart.setQuantity(newQuantity);
            }
        }
    }

    // 특정 상품을 장바구니에서 제거하는 메서드
    public void removeCartItem(String productName) {
        // 제품 이름을 기준으로 해당 제품 삭제
        products.removeIf(cart -> cart.getName().equals(productName));
    }
}