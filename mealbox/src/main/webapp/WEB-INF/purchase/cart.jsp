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
	<jsp:include page="../nav.jsp"/>
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
              <form action="/mealbox/purchase/cart" method="post">
                 <!-- 상품명 및 현재 수량 전달 -->
                 <input type="hidden" name="productName" value="${product.name}">
                 <input type="hidden" name="quantity" value="${product.quantity}">
                 <!-- 수량 변경 버튼들 -->
                 <span>상품수량 </span> 
                 <span class="btnContainer">
	                 <button class="btnQ" type="submit" name="action" value="decrease" ${product.quantity == 1 ? 'disabled' : ''}>-</button>
	                 <span class="btnSpan">${product.quantity}</span>
	                 <button class="btnQ" type="submit" name="action" value="increase">+</button>
                 </span>
              </form>
            </div>
            <div class="itemInfo3" align="right">
              <!-- 삭제 버튼: 해당 상품 ID를 서버에 전달하여 삭제 -->
              <form action="/mealbox/purchase/cart" method="post" style="display:inline;">
                <input type="hidden" name="deleteItemId" value="${product.name}">
                <button type="submit" class="close-btn">X</button>
              </form>
              <p>총가격 ${product.totalPrice}원</p>
            </div>
          </div>
        </c:forEach>
      </div>
      <div id="totalMoney">
        <p>결제예정금액</p>
        <p id="money">${totalPrice}원</p>
      </div>
       <form id="btn" action="/purchase/checkout" method="post">
          <button type="submit">구매하기</button>
        </form>
    </div>
  </body>
</html>