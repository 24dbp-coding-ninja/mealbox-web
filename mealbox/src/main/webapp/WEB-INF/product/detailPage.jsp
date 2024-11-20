<%--
기능: 상품 디테일 페이지 jsp
작성자: 신윤지
마지막 수정일: 2024-11-19
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="preconnect" href="https://rsms.me/" />
	<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
	<link rel="stylesheet" type="text/css" href="/mealbox/css/detailPage.css">
	<script>
		function increaseQuantity() {
			var price = Number((document.getElementById("how_much").innerHTML).slice(0, -1));
			
			document.getElementById("quantity").value = Number(document.getElementById("quantity").value)+1;
			document.getElementById("total_price").innerHTML = price * Number(document.getElementById("quantity").value) + "원";
		}
		
		function decreaseQuantity() {
			var price = Number((document.getElementById("how_much").innerHTML).slice(0, -1));
			
			if(document.getElementById("quantity").value==="1") {
				alert("1 이하의 수량은 주문하실 수 없습니다.");
				return;
			}
			document.getElementById("quantity").value = Number(document.getElementById("quantity").value)-1;
			document.getElementById("total_price").innerHTML = price * Number(document.getElementById("quantity").value) + "원";
		}
	</script>
	<title>상품 상세 페이지</title>
</head>
<body>
 	<%@ include file="../nav.jsp" %>
	<div class="container meal">
		<div class="meal_img">
			<img id="product_image" src="../<c:out value='${product.thumb}'/>"
				alt="<c:out value='${product.name}'/>">
		</div>
		<div class="details_container">
			<h3 id="product_name">
				<c:out value="${product.name}" />
			</h3>
			<div class="rating">
				<span> 
					<c:forEach var="rate" begin="1" end="${product.averageReview}">
						★
					</c:forEach> 
					<c:forEach var="rate" begin="${product.averageReview + 1}" end="5">
						 ☆
					</c:forEach>
				</span> <span id="product_rating_score">&nbsp;｜&nbsp;${product.averageReview}</span>
			</div>
			<p class="price" id="product_price">${product.price}원</p>
			<div class="quantity">
				<div id="product_description">
					<c:out value="${product.description}" />
				</div>
				<hr>
				<div class="check_quantity">
					<div class="plusOrMinus">
						<button class="decrease" onClick="decreaseQuantity()">-</button>
						<input type="number" id="quantity" value="1" min="1" readonly>
						<button class="increase" onClick="increaseQuantity()">+</button>
					</div>
					<span id="how_much">${product.price}원</span>
				</div>
			</div>
			<p class="total_price">
				<sup class="maybe_price">구매 예정 금액</sup>
				<span id="total_price">${product.price}원</span>
			</p>
			<div class="buy_yet">
				<button class="add_cart">장바구니</button>
				<button class="buy_now">바로구매</button>
			</div>
		</div>
	</div>
	<hr>
	<c:import url="./reviewPage.jsp" charEncoding="UTF-8">
		<%-- <c:param> 태그를 사용하여 필요한 거 보내기! --%>
	</c:import>
</body>
</html>
