/*
기능: 장바구니 페이지 controller class
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package controller.purchase;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Cart;
import model.dao.CartManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // CartManager 인스턴스 생성
        CartManager cartManager = CartManager.getInstance();

        // 수량 업데이트 요청 처리
        String productName = request.getParameter("productName");
        String action = request.getParameter("action");

        if (productName != null && action != null) {
            int currentQuantity = Integer.parseInt(request.getParameter("quantity"));

            if ("increase".equals(action)) {
                // 수량 증가
                cartManager.updateCartItemQuantity(productName, currentQuantity + 1);
            } else if ("decrease".equals(action)) {
                // 수량 감소 (수량이 1 이하로는 내려가지 않도록 처리)
                if (currentQuantity > 1) {
                    cartManager.updateCartItemQuantity(productName, currentQuantity - 1);
                }
            }
        }

        // 삭제 요청 처리
        String deleteItemId = request.getParameter("deleteItemId"); // 삭제할 상품의 ID 또는 이름
        if (deleteItemId != null) {
            cartManager.removeCartItem(deleteItemId); // CartManager에서 해당 상품 삭제
        }

        // 상품 리스트 및 총 금액 계산 후 JSP로 전달
        List<Cart> products = cartManager.getCartItems();
        int totalPrice = cartManager.calculateTotalPrice(products);

        // JSP로 데이터 전달
        request.setAttribute("products", products);
        request.setAttribute("totalPrice", totalPrice);

        // JSP로 포워딩할 경로 리턴
        return "/purchase/cart.jsp";
    }
}