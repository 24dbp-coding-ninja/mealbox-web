package controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Order;
import model.service.ExistingOrderException;
import model.service.OrderManager;

public class CreateOrderController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderManager orderMan = OrderManager.getInstance();
		
		try {
            // 파라미터 추출 및 변환
            int userId = Integer.parseInt(request.getParameter("userId"));
            String purchaser = request.getParameter("purchaser");
            String purPhone = request.getParameter("purPhone");
            String recipient = request.getParameter("recipient");
            String recPhone = request.getParameter("recPhone");
            String deliveryAddress = request.getParameter("deliveryAddress");
            int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date deliveryDate = sdf.parse(request.getParameter("deliveryDate"));

            // Order 객체 생성
            Order order = new Order();
            order.setUserId(userId);
            order.setPurchaser(purchaser);
            order.setPurPhone(purPhone);
            order.setRecipient(recipient);
            order.setRecPhone(recPhone);
            order.setDeliveryAddress(deliveryAddress);
            order.setTotalPrice(totalPrice);
            order.setDeliveryDate(deliveryDate);
            order.setOrderAt(new Date()); // 현재 시간 설정

            // 주문 생성
            int result = orderMan.create(order);

            if (result > 0) {
                response.getWriter().write("Order created successfully. Order ID: " + order.getOrderId());
                return "redirect:/purchase/orderListPage.jsp";
            } else {
                response.getWriter().write("Failed to create order.");
                return "/purchase/purchasePage.jsp";
            }
        } catch (ExistingOrderException e) {
            response.getWriter().write("Error: " + e.getMessage());
            return "/purchase/purchasePage.jsp";
        }
	}
}
