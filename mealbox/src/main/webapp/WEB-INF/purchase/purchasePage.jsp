<%--
기능: purchasePage jsp
작성자: 장고은
마지막 수정일: 2024-11-16
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>purchasePage</title>
	<link rel="stylesheet" href="../css/purchasePage.css" />
  </head>
  <body>
    <div id="nav">nav</div>
    <div id="container">
    	<div id="title">구매하기</div>
    	<div id="line">
    		<hr>	
    	</div>
    	<div id="contentContainer">
    		<div id="formContainer">
		        <form action="/order/create" method="POST">
		            <input type="hidden" name="userId" value="${userId}">
		            <div id="form1">
		                <h3>주문자</h3>
		                <hr>
		                <table>
		                    <tr>
		                        <td>이름</td>
		                        <td>
		                            <input type="text" name="purchaser" placeholder="이름을 입력해 주세요." required>
		                        </td>
		                    </tr>
		                    <tr>
		                        <td>휴대폰</td>
		                        <td>
		                            <input type="text" name="purPhone" placeholder="휴대폰 번호를 입력해 주세요." required>
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
		                            <input type="text" name="recipient" placeholder="이름을 입력해 주세요." required>
		                        </td>
		                    </tr>
		                    <tr>
		                        <td>휴대폰</td>
		                        <td>
		                            <input type="text" name="recPhone" placeholder="휴대폰 번호를 입력해 주세요." required>
		                        </td>
		                    </tr>
		                    <tr>
		                        <td>주소</td>
		                        <td>
		                            <input type="text" name="deliveryAddress" placeholder="주소를 입력해 주세요." required>
		                        </td>
		                    </tr>
		                    <tr>
		                        <td>배송희망일</td>
		                        <td>
		                            <input type="date" name="deliveryDate" required>
		                        </td>
		                    </tr>
		                </table>
		            </div>
		            <div>
		            	<br>
		            	<br>
		                <button type="submit">배송 정보 저장하기</button>
		            </div>
		        </form>
		    </div>
    		<div id="cartContainer">
			    <form action="/orderProduct/create" method="POST">
			        <div id="listContainer">
			            <p>주문상품</p>
			            <hr>
			            <!-- 상품 리스트 반복 -->
			            <c:forEach var="item" items="${cartItems}">
			                <div class="item">
			                    <input type="hidden" name="orderId" value="${orderId}" />
			                    <input type="hidden" name="lineNo" value="${item.lineNo}" />
			                    <input type="hidden" name="productId" value="${item.productId}" />
			                    <input type="hidden" name="quantity" value="${item.quantity}" />
			                    <input type="hidden" name="orderItemPrice" value="${item.price}" />
			                    
			                    <div class="itemInfo1">
			                        <img src="${item.imageUrl}" alt="상품 이미지" />
			                    </div>
			                    <div class="itemInfo2">
			                        <p>상품명: ${item.productName}</p>
			                        <p>수량: ${item.quantity}</p>
			                    </div>
			                    <div class="itemInfo3">
			                        <p>가격: ${item.price}원</p>
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
			    </form>
			</div>
    	</div>
    </div>
  </body>
</html>