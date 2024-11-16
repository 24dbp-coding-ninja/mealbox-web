package controller.orderProduct;

import model.service.OrderProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class RemoveOrderProductController implements Controller   {
	OrderProductManager orderProductManager = OrderProductManager.getInstance();

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int lineNo = Integer.parseInt(request.getParameter("lineNo"));

            int result = orderProductManager.removeOrderProduct(orderId, lineNo);

            if (result > 0) {
                request.setAttribute("message", "주문 상품이 성공적으로 삭제되었습니다.");
                return "";
            } else {
                request.setAttribute("message", "주문 상품 삭제에 실패하였습니다.");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "";
        }
    }
}
