<%--
기능: purchasePage jsp
작성자: 장고은
마지막 수정일: 2024-11-05
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
    			<div id="form1">
    				<h3>주문자</h3>
    				<hr>
    				<form>
    					<table>
	    					<tr>
	    						<td>이름</td>
	    						<td><input type="text" placeholder="이름을 입력해 주세요."></td>
	    					</tr>
	    					<tr>
	    						<td>휴대폰</td>
	    						<td><input type="text" placeholder="휴대폰 번호를 입력해 주세요."></td>
	    					</tr>
    					</table>
    				</form>
    			</div>
    			<div id="form2">
    				<h3>배송지 정보</h3>
    				<hr>
    				<form>
    					<table>
	    					<tr>
	    						<td>받는 분</td>
	    						<td><input type="text" placeholder="이름을 입력해 주세요."></td>
	    					</tr>
	    					<tr>
	    						<td>휴대폰</td>
	    						<td><input type="text" placeholder="휴대폰 번호를 입력해 주세요."></td>
	    					</tr>
	    					<tr>
	    						<td>주소</td>
	    						<td><input type="text" placeholder="주소를 입력해 주세요."></td>
	    					</tr>
	    					<tr>
	    						<td>배송희망일</td>
	    						<td><input type="date"></td>
	    					</tr>
    					</table>
    				</form>
    			</div>
    		</div>
    		<div id="cartContainer">
				<div id="listContainer">
		    		<p>주문상품</p>
		    		<hr>
		    		<div class="item">
			   			<div class="itemInfo1">
			             	<img src="../images/cartItem.png" alt="상품 이미지" />
			            </div>
			            <div class="itemInfo2">
			              <p>상품명</p>
			              <p>상품수량</p>
			            </div>
			            <div class="itemInfo3">
			              <p>총가격 13,000원</p>
			            </div>
		    		</div>
		    		<!-- 임시 예시들  -->
		    		<div class="item">
			   			<div class="itemInfo1">
			             	<img src="../images/cartItem.png" alt="상품 이미지" />
			            </div>
			            <div class="itemInfo2">
			              <p>상품명</p>
			              <p>상품수량</p>
			            </div>
			            <div class="itemInfo3">
			              <p>총가격 13,000원</p>
			            </div>
		    		</div>
		    		<div class="item">
			   			<div class="itemInfo1">
			             	<img src="../images/cartItem.png" alt="상품 이미지" />
			            </div>
			            <div class="itemInfo2">
			              <p>상품명</p>
			              <p>상품수량</p>
			            </div>
			            <div class="itemInfo3">
			              <p>총가격 13,000원</p>
			            </div>
		    		</div>
		    	</div>
		    	<div id="totalMoney">
			        <p>결제예정금액</p>
			        <p id="money">13,000원</p>
		        </div>
		        <div id="btn">
			       <form action="/mealbox/purchase/purchaseList" method="GET">
						<button type="submit">구매하기</button>
					</form>
			    </div>
	    	</div>
    	</div>
    </div>
  </body>
</html>