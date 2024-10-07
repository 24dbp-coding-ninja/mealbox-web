/*
기능: 장바구니 페이지 controller class
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package controller.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Cart;
import model.service.CartManager;

public class CartController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 임시로 장바구니 객체 생성 (실제 상황에서는 세션에서 가져오는 것이 일반적)
        Cart cart = new Cart();
        
        // 수량 업데이트 요청 처리
        String productName = request.getParameter("productName");
        String action = request.getParameter("action");

        if (productName != null && action != null) {
            int currentQuantity = Integer.parseInt(request.getParameter("quantity"));

            if ("increase".equals(action)) {
                // 수량 증가
                CartManager.updateCartItemQuantity(cart, productName, currentQuantity + 1);
            } else if ("decrease".equals(action)) {
                // 수량 감소 (수량이 1 이하로는 내려가지 않도록 처리)
                if (currentQuantity > 1) {
                	CartManager.updateCartItemQuantity(cart, productName, currentQuantity - 1);
                }
            }
        }

        // 삭제 요청 처리
        String deleteItemId = request.getParameter("deleteItemId"); // 삭제할 상품의 이름
        if (deleteItemId != null) {
            CartManager.removeCartItem(cart, deleteItemId);  // 장바구니에서 해당 상품 삭제
        }

        // 장바구니의 총 금액 계산
        int totalPrice = CartManager.calculateTotalPrice(cart);

        // 결과를 request에 저장
        request.setAttribute("products", cart.getCartItems());
        request.setAttribute("totalPrice", totalPrice);

     // JSP로 포워딩할 경로 리턴
        return "/purchase/cart.jsp";
    }
}