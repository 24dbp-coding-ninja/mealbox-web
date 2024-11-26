package controller.cartProduct;

import model.domain.CartProduct;
import model.service.CartProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class AddCartProductController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();

        try {
            String userId = request.getParameter("userId");
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int cartItemPrice = Integer.parseInt(request.getParameter("cartItemPrice"));

            CartProduct cartProduct = new CartProduct(userId, productId, quantity, cartItemPrice);
            int result = cartProductMan.addCartProduct(cartProduct);

            if (result > 0) {
                request.setAttribute("message", "장바구니에 상품이 추가되었습니다.");
                return "";
            } else {
                request.setAttribute("message", "장바구니 추가 실패.");
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "";
        }
    }
}
