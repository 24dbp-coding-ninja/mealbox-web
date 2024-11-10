package model.domain;

import java.util.List;
import java.util.ArrayList;

public class User2 {
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String address;
	//private List<Order> orderHistory = new ArrayList<>(); //주문 목록
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	/*기능*/
	//사용자 정보
	public void printUserInfo() {
		String str="";
		str += "아이디: " + getId() + "\n";
		str += "비밀번호: " + getPassword() + "\n";
		str += "이름: " + getName() + "\n";
		str += "휴대폰: " + getPhone() + "\n";
		str += "이메일: " + getEmail() + "\n";
		str += "주소: " + getAddress() + "\n";
		//str += "주문내역" + "\n" + printOrderHistory() + "\n";
		System.out.print(str);
		
	}
	
	public boolean matchPassword(String password) {
		if(password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	
//	public boolean isSameUser(User user) {
//		return id.equals(user.id);
//	}
	
	/*여기서부터 코드 미완 --> Order class를 봐야할 듯*/
	//public void addOrder(Order order) {
		//orderHistory.add(order);/*private인데 접근 가능한지 잘 모르겠음*/
	//}
	//public void cancelOrder(Order order) {
		//orderHistory.remove(order);
	//}

	/*주문내역 출럭 --> 주문번호, 금액, 취소여부, 환불여부 등 Order class를 봐야할 듯*/
	/*public String printOrderHistory(Order order) {
		String rslt ="";
		rslt += "회원id:" + getId() + "\n";
		rslt += "주문번호: " + "\n";
		rslt += "금액: " + "\n";
		rslt += "취소여부: " + "\n";
		rslt += "환불여부: " + "\n";
		return rslt;
	}*/
}
