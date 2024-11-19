package controller.orderProduct;

import model.domain.OrderProduct;
import model.service.OrderProductManager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class UpdateOrderProductController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OrderProductManager orderProductManager = OrderProductManager.getInstance();

        try {
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                // 기존 상품 정보 조회 및 JSP로 전달
                int orderId = Integer.parseInt(request.getParameter("orderId"));
                List<OrderProduct> orderProducts = orderProductManager.findOrderProductsInOrder(orderId);

                request.setAttribute("orderProducts", orderProducts);

                return "/purchase/purchaseUpdatePage.jsp"; // JSP로 이동
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                // 여러 상품 정보 수정 처리
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

                    // OrderProduct 객체 생성 및 수정
                    OrderProduct orderProduct = new OrderProduct(orderId, lineNo, productId, quantity, orderItemPrice);
                    orderProductManager.updateOrderProduct(orderProduct);
                }

                request.setAttribute("message", "주문 상품이 성공적으로 수정되었습니다.");
                return "redirect:/purchase/orderListPage.jsp"; // 성공 시 목록 페이지로 이동
            } else {
                throw new IllegalArgumentException("Invalid request method");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "/purchase/purchaseUpdatePage.jsp"; // 오류 시 다시 수정 페이지로 이동
        }
    }
}
