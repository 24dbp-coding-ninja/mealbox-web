/*
기능: 장바구니 페이지 controller class
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
*/

package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cart;
import manager.CartManager;
import javax.servlet.RequestDispatcher;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // CartManager를 사용해 비즈니스 로직을 처리
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // CartManager 인스턴스 생성
        CartManager cartManager = new CartManager();

        // 상품 리스트 가져오기
        List<Cart> products = cartManager.getCartItems();

        // 총 결제 금액 계산
        int totalPrice = cartManager.calculateTotalPrice(products);

        // JSP로 데이터 전달
        request.setAttribute("products", products);
        request.setAttribute("totalPrice", totalPrice);

        // JSP로 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }
}
