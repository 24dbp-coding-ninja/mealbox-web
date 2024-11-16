package controller.order;

import model.domain.Order;
import model.service.OrderManager;
import model.service.OrderNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class FindOrderController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OrderManager orderMan = OrderManager.getInstance();

        try {
            // 주문 ID 추출
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            // 주문 조회
            Order order = orderMan.findOrder(orderId);

            request.setAttribute("order", order);
            return "/purchase/orderDetailPage.jsp";
        } catch (OrderNotFoundException e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            return "/purchase/purchasePage.jsp";
        } catch (Exception e) {
            request.setAttribute("message", "An unexpected error occurred: " + e.getMessage());
            return "/purchase/purchasePage.jsp";
        }
    }
}
