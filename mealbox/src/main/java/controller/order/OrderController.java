package controller.order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Order;

public class OrderController implements Controller {
	 @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
		 // 요청에서 주문 정보를 가져옴
	        int orderId = Integer.parseInt(request.getParameter("orderId"));
	        String purchaser = request.getParameter("purchaser");
	        String purPhone = request.getParameter("purPhone");
	        String recipient = request.getParameter("recipient");
	        String recPhone = request.getParameter("recPhone");
	        String deliveryAddress = request.getParameter("deliveryAddress");

	        // Order 객체 생성 및 필드 설정
	        Order order = new Order();
	        order.setOrderId(orderId);
	        order.setPurchaser(purchaser);
	        order.setPurPhone(purPhone);
	        order.setRecipient(recipient);
	        order.setRecPhone(recPhone);
	        order.setDeliveryAddress(deliveryAddress);
	        order.setDefaultDeliveryDate(); // 기본 배송일 설정

	        // 주문 처리 로직 수행 
	        //orderManager.processOrder(order);

	        // 주문 정보를 request에 저장
	        request.setAttribute("order", order);

	        // 성공적으로 주문이 처리되면 주문 목록 페이지로 이동
	        return "/order.jsp";
	    }
}
