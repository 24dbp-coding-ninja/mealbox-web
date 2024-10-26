package model.domain;

public class CartItem {
	private int cartItemId;
	private Product cartItem;
	private int quantity;
	
	// 기본 생성자
	public CartItem() { }		
	
	// setter
	public void setCartItemId(int cartItemId) {this.cartItemId = cartItemId;}
	public void setCartItem(Product cartItem) {this.cartItem = cartItem;} 
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	// getter
	public int getCartItemId() {return cartItemId;}
	public Product getCartItem() {return cartItem;}
	public int getQuantity() {return quantity;}
	
	// 상품 가격 * 수량의 값을 구하는 메서드
    public int getTotalPrice() {
        return cartItem.getPrice() * quantity;
    }
}
