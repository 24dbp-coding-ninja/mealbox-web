<%--
기능: nav jsp
작성자: 신윤지
마지막 수정일: 2024-11-18
추가해야할 기능: search, cart, join, login 주소 연결
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://rsms.me/" />
<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
<link rel="stylesheet" type="text/css" href="/mealbox/css/nav.css" />
<script>
	<!-- 사이드 바 오픈 관련 코드 -->
	window.onload = function() {
		document.getElementById("peopleSelection").style.display = "none";

		document.getElementById("menuOpen").addEventListener("click",
				function() {
					document.getElementById("sidebar").style.display = "block";
				});
		document.getElementById("menuClose").addEventListener("click",
				function() {
					document.getElementById("sidebar").style.display = "none";
				});

		document
				.getElementById("peopleSelectionOpen")
				.addEventListener(
						"click",
						function() {
							var open = document
									.getElementById("peopleSelectionOpen");
							var selection = document
									.getElementById("peopleSelection");

							if (selection.style.display == "none") {
								open.style.backgroundImage = `url(/mealbox/images/close.png)`;
								selection.style.display = "block";
							} else {
								open.style.backgroundImage = `url(/mealbox/images/open.png)`;
								selection.style.display = "none";
							}
						});
	};
	<!-- /* 로그인 */ -->
</script>
</head>
<body>
	<!--검색, 장바구니, join, login-->
	<div id="navContainer">
		<!--메뉴아이콘-->
		<input type="button" id="menuOpen" />
		<div id="navInNav">
		<!--검색-->
		<div id="search">
			<input type="text" id="search_text" placeholder="검색어" />
			<!--검색아이콘-->
			<img id="search_icon" src="/mealbox/images/search.png" align="center" />
		</div>
		<!--장바구니-->
		<div id="basket">
			<img id="basket_icon" src="/mealbox/images/basket.png" align="center" />
			<!--장바구니아이콘-->
		</div>
		<!--join-->
		<div id="join">JOIN</div>
		<!--login-->
		<div id="login">LOGIN</div>
		</div>
	</div>

	<!--사이드 바-->
	<aside id="sidebar">
		<section class="closeSection">
			<img id="menuClose" src="/mealbox/images/sidebar_close.png" />
		</section>
		<section class="selection">한식</section>
		<section class="selection">양식</section>
		<section class="selection">분식</section>
		<section class="selection">중식</section>

		<section class="selection">
			인원별 <input type="button" id="peopleSelectionOpen"
				onClick="onClickPeopleSelection()" />
		</section>
		<section id="peopleSelection">
			<div id="smallerSelection">1~2인분</div>
			<div id="biggerSelection">3~4인분</div>
		</section>
	</aside>
</body>
</html>