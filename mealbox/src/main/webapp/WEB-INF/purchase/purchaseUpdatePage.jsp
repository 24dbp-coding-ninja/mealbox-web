<%--
기능: purchaseUpdatePage jsp
작성자: 장고은
마지막 수정일: 2024-11-16
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>purchaseUpdatePage</title>
	<link rel="stylesheet" href="../css/purchasePage.css" />
  </head>
  <body>
    <div id="nav">nav</div>
    <div id="container">
    	<div id="title">구매 내역 수정하기</div>
    	<div id="line">
    		<hr>	
    	</div>
    	<div id="contentContainer">
            <!-- 주문 정보 수정 -->
            <div id="formContainer">
                <form action="/order/update" method="POST">
                    <input type="hidden" name="orderId" value="${order.orderId}" />
                    <input type="hidden" name="userId" value="${order.userId}" />
                    <div id="form1">
                        <h3>주문자 정보</h3>
                        <hr>
                        <table>
                            <tr>
                                <td>이름</td>
                                <td>
                                    <input type="text" name="purchaser" value="${order.purchaser}" required>
                                </td>
                            </tr>
                            <tr>
                                <td>휴대폰</td>
                                <td>
                                    <input type="text" name="purPhone" value="${order.purPhone}" required>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div id="form2">
                        <h3>배송지 정보</h3>
                        <hr>
                        <table>
                            <tr>
                                <td>받는 분</td>
                                <td>
                                    <input type="text" name="recipient" value="${order.recipient}" required>
                                </td>
                            </tr>
                            <tr>
                                <td>휴대폰</td>
                                <td>
                                    <input type="text" name="recPhone" value="${order.recPhone}" required>
                                </td>
                            </tr>
                            <tr>
                                <td>주소</td>
                                <td>
                                    <input type="text" name="deliveryAddress" value="${order.deliveryAddress}" required>
                                </td>
                            </tr>
                            <tr>
                                <td>배송희망일</td>
                                <td>
                                    <input type="date" name="deliveryDate" value="${formattedDeliveryDate}" required>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div>
                    	<br><br>
                        <button type="submit">주문 정보 수정하기</button>
                    </div>
                </form>
            </div>
    		 <!-- 상품 정보 수정 -->
            <div id="cartContainer">
                <form action="/orderProduct/update" method="POST">
                    <div id="listContainer">
                        <p>주문 상품 수정</p>
                        <hr>
                        <!-- 상품 리스트 반복 -->
                        <c:forEach var="item" items="${orderProducts}">
                            <div class="item">
                                <input type="hidden" name="orderId" value="${item.orderId}" />
                                <input type="hidden" name="lineNo" value="${item.lineNo}" />

                                <div class="itemInfo1">
                                    <img src="${item.imageUrl}" alt="상품 이미지" />
                                </div>
                                <div class="itemInfo2">
                                    <p>상품명: ${item.productName}</p>
                                    <p>수량:
                                        <input type="number" name="quantity" value="${item.quantity}" min="1" required>
                                    </p>
                                    <p>가격:
                                        <input type="number" name="orderItemPrice" value="${item.orderItemPrice}" required> 원
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- 총 금액 표시 -->
				      <div id="totalMoney">
				        <p>총 금액:</p>
				        <p id="money">${order.totalPrice} 원</p>
				      </div>
                    <div id="btn">
                        <button type="submit">상품 정보 수정하기</button>
                    </div>
                </form>
            </div>
    	</div>
    </div>
  </body>
</html>