<%--
기능: 메인 페이지 jsp
작성자: 신윤지
마지막 수정일: 2024-11-05
추가해야할 기능: 
 --%>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
 <html>
 	<head>
 		<meta charset="UTF-8" />
 		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="preconnect" href="https://rsms.me/" />
		<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
 		<link rel="stylesheet" type="text/css" href="css/main.css" />
 		<title>Mealbox</title>
 	</head>
 	<body>
 	<%@ include file="../nav.jsp" %>
    <div id="mainContainer">
    <!-- 상품 정렬 방식 -->
      <ul id="orderContainer">
        <li>최신등록순</li>
        <li>낮은가격순</li>
        <li>높은가격순</li>
        <li>평점높은순</li>
      </ul>
      <!-- 상품 리스트 -->
      <div id="cardContainer">
 		<c:forEach var="product" items="${productList}">
 			<div id="card">
        		<img id="cardImg" src="${product.thumb}" />
        		<div id="cardText">
					<div id="cardName">${product.name}</div>
          			<div id="cardPrice">${product.price}원</div>
          			<div id="cardDesc">${product.description}</div>
        		</div>
      		</div>
 		</c:forEach>
	 	</div>
 	</div>
 		
 	</body>
 </html>