package controller.cartProduct;

import model.domain.CartProduct;
import model.service.CartProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;

public class AddCartProductController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();

        try {
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            CartProduct cartProduct = new CartProduct(userId, productId, quantity, 0);
            int result = cartProductMan.addCartProduct(cartProduct);

         // 결과 출력
            if (result > 0) {
                System.out.println("장바구니 상품 업데이트 성공!");
                System.out.println(cartProduct.toString());
            } else {
                System.out.println("장바구니 상품 업데이트 실패!");
            }
            return "redirect:/cart/view";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "redirect:/product/detail";
        }
    }
}
