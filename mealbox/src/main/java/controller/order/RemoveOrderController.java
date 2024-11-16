package controller.order;

import model.service.OrderManager;
import model.service.OrderNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

// 주문 삭제 기능은 이번 프로젝트에서는 적용 x
public class RemoveOrderController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OrderManager orderMan = OrderManager.getInstance();

        try {
            // 주문 ID 추출
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            // 주문 삭제
            int result = orderMan.remove(orderId);

            if (result > 0) {
                request.setAttribute("message", "Order removed successfully.");
                return "redirect:/purchase/orderListPage.jsp";
            } else {
                request.setAttribute("message", "Failed to remove order.");
                return "/purchase/purchasePage.jsp";
            }
        } catch (OrderNotFoundException e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            return "/purchase/purchasePage.jsp";
        } catch (Exception e) {
            request.setAttribute("message", "An unexpected error occurred: " + e.getMessage());
            return "/purchase/purchasePage.jsp";
        }
    }
}
