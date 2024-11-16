package controller.cartProduct;

import model.domain.CartProduct;
import model.service.CartProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import java.util.List;

public class ViewCartController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();

        try {
            int userId = Integer.parseInt(request.getParameter("userId"));

            List<CartProduct> cartProducts = cartProductMan.getCartProducts(userId);
            request.setAttribute("cartProducts", cartProducts);

            return "/cart/cartViewPage.jsp"; // 장바구니 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "/errorPage.jsp";
        }
    }
}
