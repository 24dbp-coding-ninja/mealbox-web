package controller.order;

import model.domain.Order;
import model.service.OrderManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import java.util.List;

public class FindOrdersInUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OrderManager orderMan = OrderManager.getInstance();

        try {
            // 사용자 ID 추출
            int userId = Integer.parseInt(request.getParameter("userId"));

            // 사용자의 주문 목록 조회
            List<Order> orderList = orderMan.findOrdersInUser(userId);

            // 결과를 요청 속성에 저장
            request.setAttribute("orderList", orderList);
            return "/purchase/userOrderListPage.jsp"; // 결과를 표시할 JSP 페이지
        } catch (Exception e) {
            request.setAttribute("message", "An unexpected error occurred: " + e.getMessage());
            return "/purchase/purchasePage.jsp"; // 오류 발생 시 이동할 페이지
        }
    }
}

