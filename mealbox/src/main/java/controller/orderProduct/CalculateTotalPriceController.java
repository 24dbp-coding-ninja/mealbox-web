package controller.orderProduct;

import model.service.OrderProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class CalculateTotalPriceController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // 요청에서 주문 ID 가져오기
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            // 상품 총 금액 계산
            OrderProductManager orderProductManager = OrderProductManager.getInstance();
            int totalPrice = orderProductManager.calculateTotalPrice(orderId);

            // JSP로 전달
            request.setAttribute("totalPrice", totalPrice);

            // 계산된 총 금액을 사용해 주문 페이지로 리디렉션
            return "/order/update?orderId=" + orderId + "&totalPrice=" + totalPrice;
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "총 금액 계산 중 오류 발생: " + e.getMessage());
            return "/errorPage.jsp";
        }
    }
}
