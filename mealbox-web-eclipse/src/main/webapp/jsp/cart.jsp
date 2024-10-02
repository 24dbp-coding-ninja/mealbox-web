<%--
기능: 장바구니 페이지 jsp
작성자: 장고은
마지막 수정일: 2024-10-03
추가해야할 기능: 페이지 이동
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cart Page</title>
    <link rel="stylesheet" href="../css/cart.css" />
  </head>
  <body>
    <div id="nav">nav</div>
    <div id="cart">
      <h2 align="center">장바구니</h2>
      <div id="itemList" align="center">
        <p>상품내역</p>
        <hr />

        <!-- 상품 리스트 출력 -->
        <c:forEach var="product" items="${products}">
          <div class="item">
            <div class="itemInfo1">
              <img src="../images/cartItem.png" alt="상품 이미지" />
            </div>
            <div class="itemInfo2">
              <p>${product.name}</p>
              <p>상품수량: ${product.quantity}</p>
            </div>
            <div class="itemInfo3" align="right">
              <button class="close-btn">X</button>
              <p>총가격 ${product.price}원</p>
            </div>
          </div>
        </c:forEach>
        
      </div>
      <div id="totalMoney">
        <p>결제예정금액</p>
        <p id="money">${totalPrice}원</p>
      </div>
      <div id="btn">
        <button type="submit">구매하기</button>
      </div>
    </div>

    <!-- JavaScript 파일 연결 -->
    <script src="../js/cart.js"></script>
  </body>
</html>