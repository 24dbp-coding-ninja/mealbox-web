package controller.orderProduct;

import model.domain.OrderProduct;
import model.service.OrderProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import java.util.List;

public class FindOrderProductsInOrderController implements Controller   {
	OrderProductManager orderProductManager = OrderProductManager.getInstance();

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));

            List<OrderProduct> orderProductList = orderProductManager.findOrderProductsInOrder(orderId);

            if (orderProductList != null && !orderProductList.isEmpty()) {
                request.setAttribute("orderProductList", orderProductList);
                return "";
            } else {
                request.setAttribute("message", "해당 주문의 상품이 없습니다.");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "";
        }
    }
}
