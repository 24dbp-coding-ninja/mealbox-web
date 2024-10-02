/*
기능: 장바구니 페이지 manager class
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package manager;

import beans.Cart;
import java.util.ArrayList;
import java.util.List;

public class CartManager {

    // 상품 리스트를 반환하는 메서드
    public List<Cart> getCartItems() {
        List<Cart> products = new ArrayList<>();
        products.add(new Cart("상품명1", 1, 13000));
        products.add(new Cart("상품명2", 1, 13000));
        return products;
    }

    // 총 결제 금액을 계산하는 메서드
    public int calculateTotalPrice(List<Cart> products) {
        return products.stream().mapToInt(Cart::getPrice).sum();
    }
}