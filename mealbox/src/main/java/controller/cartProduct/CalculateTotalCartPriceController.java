package controller.cartProduct;

import model.service.CartProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class CalculateTotalCartPriceController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();

        try {
            int userId = Integer.parseInt(request.getParameter("userId")); // 사용자 ID 가져오기
            int totalPrice = cartProductMan.calculateTotalCartPrice(userId); // 총 금액 계산

            request.setAttribute("totalPrice", totalPrice); // JSP로 총 금액 전달
            return "/cart/cartViewPage.jsp"; // 장바구니 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "/errorPage.jsp"; // 오류 페이지로 이동
        }
    }
}
