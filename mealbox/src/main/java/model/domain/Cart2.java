/*
기능: 장바구니 페이지 model
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package model.domain;

public class Cart2 {
	    private String name;  // 상품명
	    private int quantity;  // 상품수량
	    private int price;   // 가격

	    public Cart2(String name, int quantity, int price) {
	        this.name = name;
	        this.quantity = quantity;
	        this.price = price;
	    }

	    // 총 가격 계산 (수량 * 단가)
	    public int getTotalPrice() {
	        return price * quantity;
	    }
	    
	    public String getName() {
	        return name;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public int getPrice() {
	        return price;
	    }
}
