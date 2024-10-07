package model.domain;

import java.time.LocalDate;
import java.util.List;

public class Order {
	private int orderId;
	private String purchaser;
	private String purPhone;
	private String recipient;
	private String recPhone;
	private String deliveryAddress;
	private int totalPrice;
	private LocalDate deliveryDate;
	private List<Cart> cart;
	private boolean state; // 주문 상태
	private List<OrderItem> orderItems;  // 주문 완료된 상품을 담는 리스트
	
	// 기본 생성자
	public Order() { }		
		
	// setter
	public void setOrderId(int orderId) {this.orderId = orderId;}
	public void setPurchaser(String purchaser) {this.purchaser = purchaser;}
	public void setRecipient(String recipient) {this.recipient = recipient;}
	public void setRecPhone(String recPhone) {this.recPhone = recPhone;}
	public void setDeliveryAddress(String deliveryAddress) {this.deliveryAddress = deliveryAddress;}
	public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}
	public void setDeliveryDate(LocalDate deliveryDate) {this.deliveryDate = deliveryDate;}
	public void setCart(List<Cart> cart) {this.cart = cart;}
	public void setPurPhone(String purPhone) {this.purPhone = purPhone;}
	public void setState(boolean state) {this.state = state;}
	 public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }
	 
	// getter
	public int getOrderId() {return orderId;}
	public String getPurchaser() {return purchaser;}
	public String getRecipient() {return recipient;}
	public String getRecPhone() {return recPhone;}
	public String getDeliveryAddress() {return deliveryAddress;}
	public int getTotalPrice() {return totalPrice;}
	public LocalDate getDeliveryDate() {return deliveryDate;}
	public List<Cart> getCart() {
		// 장바구니가 null일 경우 빈 리스트를 반환하거나 null 처리
        return cart != null ? cart : List.of();
    }
	public String getPurPhone() {return purPhone;}
	public boolean getState() {return state;}
    public List<OrderItem> getOrderItems() { return orderItems; }
    
	// 기본 배송일을 오늘 날짜로부터 2일 후로 설정하는 메서드
    public void setDefaultDeliveryDate() {
        if (this.deliveryDate == null) {
            this.deliveryDate = LocalDate.now().plusDays(2);
        }
    }

}
