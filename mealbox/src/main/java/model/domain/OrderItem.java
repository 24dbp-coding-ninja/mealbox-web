package model.domain;

// 주문이 완료된 상품 

public class OrderItem {
	private int orderItemId;
	private Product orderItem;
	private int quantity;
	private int price;
	
	// 기본 생성자
	public OrderItem() { }		
			
	// setter
	public void setOrderItemId(int orderItemId) {this.orderItemId = orderItemId;}
	public void setOrderItem(Product orderItem) { 
        this.orderItem = orderItem; 
        // 상품을 설정할 때 자동으로 가격도 계산하여 저장
        calculatePrice();
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        // 수량이 변경될 때도 가격을 재계산
        calculatePrice();
    }
	public void setPrice(int price) {this.price = price;}
	
	// getter
	public int getOrderItemId() {return orderItemId;}
	public Product getOrderItem() {return orderItem;}
	public int getQuantity() {return quantity;}
	public int getPrice() {return price;}
	
	// 수량 * 상품 가격(단가)로 총 금액 계산
    private void calculatePrice() {
        if (this.orderItem != null && this.quantity > 0) {
            this.price = this.orderItem.getPrice() * this.quantity;
        }
    }
}