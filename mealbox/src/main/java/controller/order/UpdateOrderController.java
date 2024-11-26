package controller.order;

import model.domain.Order;
import model.service.OrderManager;
import model.service.OrderNotFoundException;
import model.service.OrderProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateOrderController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OrderManager orderMan = OrderManager.getInstance();
        OrderProductManager orderProductMan = OrderProductManager.getInstance();

        try {
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                // 기존 주문 정보 조회 및 JSP로 전달 (수정 화면 로드)
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                Order order = orderMan.findOrder(orderId);

                int totalPrice = orderProductMan.calculateTotalPrice(orderId); // 총 금액 계산
                order.setTotalPrice(totalPrice); // 주문 객체에 총 금액 반영
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDeliveryDate = sdf.format(order.getDeliveryDate());

                request.setAttribute("order", order);
                request.setAttribute("formattedDeliveryDate", formattedDeliveryDate);

                return "/purchase/purchaseUpdatePage.jsp";
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                // 수정 요청 처리
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                String userId = request.getParameter("userId");
                String purchaser = request.getParameter("purchaser");
                String purPhone = request.getParameter("purPhone");
                String recipient = request.getParameter("recipient");
                String recPhone = request.getParameter("recPhone");
                String deliveryAddress = request.getParameter("deliveryAddress");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date deliveryDate = sdf.parse(request.getParameter("deliveryDate"));

                validateRequiredField(purchaser, "주문자 이름");
                validateRequiredField(purPhone, "주문자 휴대폰");
                validateRequiredField(recipient, "받는 분 이름");
                validateRequiredField(recPhone, "받는 분 휴대폰");
                validateRequiredField(deliveryAddress, "배송 주소");

                // 총 금액 계산
                int totalPrice = orderProductMan.calculateTotalPrice(orderId);
                
                Order order = new Order(orderId, userId, new Date(), purchaser, purPhone, recipient, recPhone, deliveryAddress, totalPrice, deliveryDate);
                int result = orderMan.update(order);

                if (result > 0) {
                    return "redirect:/purchase/purchaseUpdatePage.jsp";
                } else {
                    request.setAttribute("message", "주문 정보 업데이트 실패.");
                    return "/purchase/purchaseUpdatePage.jsp";
                }
            } else {
                throw new IllegalArgumentException("Invalid request method");
            }
        } catch (IllegalArgumentException e) {
            request.setAttribute("message", "입력 오류: " + e.getMessage());
            return "/purchase/purchaseUpdatePage.jsp";
        } catch (OrderNotFoundException e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            return "/purchase/purchaseUpdatePage.jsp";
        } catch (Exception e) {
            request.setAttribute("message", "An unexpected error occurred: " + e.getMessage());
            return "/purchase/purchaseUpdatePage.jsp";
        }
    }

    private void validateRequiredField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + "은(는) 필수 항목입니다.");
        }
    }
}
