package controller.cartProduct;

import model.service.CartProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class RemoveCartProductController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();

        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int productId = Integer.parseInt(request.getParameter("productId"));

            int result = cartProductMan.removeCartProduct(userId, productId);

            if (result > 0) {
                request.setAttribute("message", "장바구니 상품이 삭제되었습니다.");
                return "/cart/cartPage.jsp";
            } else {
                request.setAttribute("message", "장바구니 삭제 실패.");
                return "redirect:/cart/view";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "redirect:/cart/view";
        }
    }
}
