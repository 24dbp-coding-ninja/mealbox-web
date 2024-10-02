/*
기능: 장바구니 페이지 model
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package beans;

public class Cart {
	    private String name;  // 상품명
	    private int quantity;  // 상품수량
	    private int price;   // 가격

	    public Cart(String name, int quantity, int price) {
	        this.name = name;
	        this.quantity = quantity;
	        this.price = price;
	    }

	    // Getter 메서드
	    public String getName() { return name; }
	    public int getQuantity() { return quantity; }
	    public int getPrice() { return price; }
}
