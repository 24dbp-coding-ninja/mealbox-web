<%--
기능: myPage jsp
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
    <title>myPage</title>
	<link rel="stylesheet" href="../css/myPage.css" />
  </head>
  <body>
    <div id="nav">nav</div>
    <div id="container">
    	<div id="title">마이페이지</div>
    	<div id="line">
    		<hr>	
    	</div>
    	<div id="btnContainer">
			<form  action="/mealbox/cart/cartList" method="GET">
				<button type="submit">장바구니 바로가기</button>
			</form>
			<form action="/mealbox/purchase/purchaseList" method="GET">
				<button type="submit">주문목록 바로가기</button>
			</form>
			<form action="/mealbox/user/update" method="GET">
				<button type="submit">내 정보 수정하기</button>
			</form>
    	</div>
    </div>
  </body>
</html>