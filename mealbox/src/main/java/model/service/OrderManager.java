package model.service;

import model.domain.Cart;
import model.domain.Order;

public class OrderManager {
    // 주문 정보 유효성 검사
    public boolean isValidOrder(Order order) {
        // 주문자 이름이 비어 있으면 안 됨
        if (order.getPurchaser() == null || order.getPurchaser().trim().isEmpty()) {return false;}

        // 주문자 전화번호가 비어 있으면 안 됨
        if (order.getPurPhone() == null || order.getPurPhone().trim().isEmpty()) {return false;}

        // 수령인 이름이 비어 있으면 안 됨
        if (order.getRecipient() == null || order.getRecipient().trim().isEmpty()) {return false;}

        // 수령인 전화번호가 비어 있으면 안 됨
        if (order.getRecPhone() == null || order.getRecPhone().trim().isEmpty()) {return false;}

        // 배송 주소가 비어 있으면 안 됨
        if (order.getDeliveryAddress() == null || order.getDeliveryAddress().trim().isEmpty()) {return false;}

        return true;
    }

    // 장바구니 안에 담긴 모든 상품의 총 금액 계산(결제예정금액)
    public int getPurchaseTotalPrice(Order order) {
        int total = 0;

        for (Cart cart : order.getCart()) {
            total += cart.getTotalPrice();
        }

        return total;
    }

    // 주문 생성 로직 처리
	/*
	 // 주문 생성 및 처리
    public void processOrder(Order order) {
        if (isValidOrder(order)) {
            // 총 구매 금액 계산
            int totalPrice = getPurchaseTotalPrice(order);
            order.setTotalPrice(totalPrice);  // 주문에 총 금액 설정

            // 주문이 완료되었으므로 주문 상태를 true로 설정
            order.setState(true);

            // 주문된 상품을 OrderItem 리스트에 추가 (예시로 상품 데이터를 추가)
            List<OrderItem> orderItems = new ArrayList<>();
            Product product1 = new Product();
            product1.setProductId(1);
            product1.setName("상품 A");
            product1.setPrice(10000);

            OrderItem item1 = new OrderItem();
            item1.setOrderItemId(1);
            item1.setOrderItem(product1);
            item1.setQuantity(2);  // 예: 수량 2
			item1.setPrice();
            orderItems.add(item1);

            // 주문 항목 리스트를 Order에 추가
            order.setOrderItems(orderItems);

            System.out.println("주문이 성공적으로 처리되었습니다. 총 금액: " + totalPrice);
        } else {
            System.out.println("유효하지 않은 주문입니다.");
        }
    }
	 */
}
