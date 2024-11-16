package controller.orderProduct;

import model.domain.OrderProduct;
import model.service.OrderProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class FindOrderProductController implements Controller   {
	OrderProductManager orderProductManager = OrderProductManager.getInstance();
	

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int lineNo = Integer.parseInt(request.getParameter("lineNo"));

            OrderProduct orderProduct = orderProductManager.findOrderProduct(orderId, lineNo);

            if (orderProduct != null) {
                request.setAttribute("orderProduct", orderProduct);
                return "";
            } else {
                request.setAttribute("message", "해당 주문 상품을 찾을 수 없습니다.");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "";
        }
    }
}
