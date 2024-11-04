
<%--
기능: orderListPage jsp
작성자: 장고은
마지막 수정일: 2024-11-04
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>orderListPage</title>
    <link rel="stylesheet" href="../css/orderListPage.css" />
  </head>
  <body>
    <div id="nav">nav</div>
    <div id="container">
    	<div id="title">주문목록</div>
    	<div id="line">
    		<hr>	
    	</div>
    	<div id="listContainer">
    		<p>구매상품내역</p>
    		<hr>
    		<div class="item">
    			<div class="itemInfo1">
	             	<img src="../images/cartItem.png" alt="상품 이미지" />
	            </div>
	            <div class="itemInfo2">
	              <p>상품명</p>
	              <p>상품수량</p>
	              <p>총가격 13,000원</p>
	            </div>
	            <div class="itemInfo3">
	            	<button type="button">리뷰작성</button>
	            	<button type="button">장바구니</button>
	            </div>
    		</div>
    		<div class="item">
    			<div class="itemInfo1">
	             	<img src="../images/cartItem.png" alt="상품 이미지" />
	            </div>
	            <div class="itemInfo2">
	              <p>상품명</p>
	              <p>상품수량</p>
	              <p>총가격 13,000원</p>
	            </div>
	            <div class="itemInfo3">
	            	<button type="button">리뷰작성</button>
	            	<button type="button">장바구니</button>
	            </div>
    		</div>
    		<div class="item">
    			<div class="itemInfo1">
	             	<img src="../images/cartItem.png" alt="상품 이미지" />
	            </div>
	            <div class="itemInfo2">
	              <p>상품명</p>
	              <p>상품수량</p>
	              <p>총가격 13,000원</p>
	            </div>
	            <div class="itemInfo3">
	            	<button type="button">리뷰작성</button>
	            	<button type="button">장바구니</button>
	            </div>
    		</div>
    	</div>
    	
    </div>
  </body>
</html>