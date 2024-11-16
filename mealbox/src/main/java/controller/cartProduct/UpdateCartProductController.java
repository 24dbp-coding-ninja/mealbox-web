package controller.cartProduct;

import model.domain.CartProduct;
import model.service.CartProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class UpdateCartProductController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();

        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int cartItemPrice = Integer.parseInt(request.getParameter("cartItemPrice"));

            CartProduct cartProduct = new CartProduct(userId, productId, quantity, cartItemPrice);
            int result = cartProductMan.updateCartProduct(cartProduct);

            if (result > 0) {
                request.setAttribute("message", "장바구니 상품이 수정되었습니다.");
                return "redirect:/cart/view";
            } else {
                request.setAttribute("message", "장바구니 수정 실패.");
                return "/errorPage.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "/errorPage.jsp";
        }
    }
}