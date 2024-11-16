<%--
기능: nav jsp
작성자: 신윤지
마지막 수정일: 2024-10-30
추가해야할 기능: nav바 함수 구현 및 확인 / category 받아와서 forEach 내에 링크, 내용 구현 / search, cart, join, login 주소 연결
 --%>
 <!--nav.jsp 들어가는 부분(다른 jsp파일에 잘 들어갔는지 확인하기 위해 텍스트 추가함)-->
 <%-- 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
 <html lang="ko">
   <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="styles/nav.css" />
    	<!-- /* 로그인 */ -->
  </head>
  <body>
    <!--메뉴아이콘-->
    <input type="button" id="menuOpen" />
    <!--검색, 장바구니, join, login-->
    <div id="navInNav">
      <!--검색-->
      <div id="search">
        <input type="text" id="search_text" placeholder="검색어" />
        <!--검색아이콘-->
        <img id="search_icon" src="images/search.png" align="center" />
      </div>
      <!--장바구니-->
      <div id="basket"><img id="basket_icon" src="images/basket.png" align="center" /><!--장바구니아이콘--></div>
      <!--join-->
      <div id="join">JOIN</div>
      <!--login-->
      <div id="login">LOGIN</div>
    </div>

    <!--사이드 바-->
    <aside id="sidebar">
      <section class="closeSection">
        <img id="menuClose" src="./images/sidebar_close.png" />
      </section>
      <section class="selection">한식</section>
      <section class="selection">양식</section>
      <section class="selection">분식</section>
      <section class="selection">중식</section>
      <!-- 
      <c:forEach var="foodTypeCategory" items=${foodTypeCategories}>
      	<section class="selection">${foodTypeCategory}</section>
      </c:forEach>
       -->
      
     
      <section class="selection">
        인원별
        <input type="button" id="peopleSelectionOpen" onClick="onClickPeopleSelection()" />
      </section>
      <section id="peopleSelection">
        <div id="smallerSelection">1~2인분</div>
        <div id="biggerSelection">3~4인분</div>
      </section>
      <!-- 
      <c:forEach var="peopleCategory" items=${peopleCategories}>
        <div id="smallerSelection">${peopleCategory}</div>
      </c:forEach>
       -->
      
    </aside>
  </body>
 </html>
 --%>