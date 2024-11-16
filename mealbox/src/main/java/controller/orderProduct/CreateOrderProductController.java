package controller.orderProduct;

import model.domain.OrderProduct;
import model.service.OrderProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class CreateOrderProductController implements Controller  {
	OrderProductManager orderProductManager = OrderProductManager.getInstance();
    
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            // 요청으로부터 여러 상품 정보를 받음
            String[] orderIds = request.getParameterValues("orderId");
            String[] lineNos = request.getParameterValues("lineNo");
            String[] productIds = request.getParameterValues("productId");
            String[] quantities = request.getParameterValues("quantity");
            String[] prices = request.getParameterValues("orderItemPrice");

            for (int i = 0; i < productIds.length; i++) {
                int orderId = Integer.parseInt(orderIds[i]);
                int lineNo = Integer.parseInt(lineNos[i]);
                int productId = Integer.parseInt(productIds[i]);
                int quantity = Integer.parseInt(quantities[i]);
                int orderItemPrice = Integer.parseInt(prices[i]);

                // OrderProduct 객체 생성 및 저장
                OrderProduct orderProduct = new OrderProduct(orderId, lineNo, productId, quantity, orderItemPrice);
                orderProductManager.createOrderProduct(orderProduct);
            }

            request.setAttribute("message", "주문 상품이 성공적으로 저장되었습니다.");
            return "/successPage.jsp"; // 성공 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "/errorPage.jsp"; // 오류 페이지로 이동
        }
    }
}
