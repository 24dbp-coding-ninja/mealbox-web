<%--
기능: adminPage jsp 
작성자: 신윤지
마지막 수정일: 2024-11-05
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="preconnect" href="https://rsms.me/" />
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
    <link rel="stylesheet" type="text/css" href="css/admin.css" />
    <script src="scripts/includeHTML.js"></script>
    <script src="./scripts/sidebar.js"></script> -->
    <title>상품 관리 어드민 페이지</title>
  </head>
  <body>
    <!-- <nav include-html="nav.html"></nav>
    <script>
      includeHTML();
    </script> -->

    <div id="adminContainer">
      <h1>상품 관리</h1>
      <div id="selectedActionContainer">
        <input type="button" value="상품 추가" />
        <input type="button" value="선택 수정" />
        <input type="button" value="선택 삭제" />
      </div>
      <div id="hr"></div>
      <div id="formContainer">
        <div id="labelContainer">
          <span>
            <input type="checkbox" />
          </span>
          <span>상품코드</span>
          <span>이미지</span>
          <span>상품명</span>
          <span>판매가격</span>
          <span>재고</span>
          <span>리뷰수</span>
          <span>평점</span>
          <span>인원</span>
          <span>음식 종류</span>
        </div>
        <form action="">
          <div id="formWrapper">
            <div>추가</div>
            <div>&nbsp;</div>
            <div>
              <input type="file" id="newThumb" />
            </div>
            <div><input type="text" id="newName" /></div>
            <div><input type="text" id="newPrice" /></div>
            <div><input type="text" id="newStock" /></div>
            <div>0</div>
            <div>0</div>
            <div>
              <select name="newFoodTypeCategory">
                <option value="1">양식</option>
                <option value="2">중식</option>
                <option value="3">분식</option>
                <option value="4">뭔식</option>
              </select>
            </div>
            <div>
              <select name="newPeopleCategory">
                <option value="1">1~2인용</option>
                <option value="2">3~4인용</option>
              </select>
            </div>
          </div>

		<c:forEach var="product" items="${productList}" >
          <div id="formWrapper">
            <div>
              <input type="checkbox" id="checked" />
            </div>
            <div>
	           	<input type="text" id="id" value="${product.id}" readonly />
            </div>
            <div>
              <input type="file" id="thumb" />
            </div>
            <div><input type="text" id="name" value="${product.name}" /></div>
            <div><input type="text" id="price" value="${product.price}원" /></div>
            <div><input type="text" id="stock" value="${product.stock}" /></div>
            <div>${product.totalReview}</div>
            <div>${product.averageReview}</div>
            <div>
              <select name="foodTypeCategory">
                <option value="1" <c:if test="${product.categoryType eq '양식'}">selected</c:if>>양식</option>
                <option value="2" <c:if test="${product.categoryType eq '중식'}">selected</c:if>>중식</option>
                <option value="3" <c:if test="${product.categoryType eq '분식'}">selected</c:if>>분식</option>
                <option value="4" <c:if test="${product.categoryType eq '뭔식'}">selected</c:if>>뭔식</option>
              </select>
            </div>
            <div>
              <select name="peopleCategory">
                <option value="1" <c:if test="${product.categoryPerson eq 1}">selected</c:if>>1~2인용</option>
                <option value="2"  <c:if test="${product.categoryPerson eq 2}">selected</c:if>>3~4인용</option>
              </select>
            </div>
          </div>
          </c:forEach>
          
        </form>
      </div>
    </div>
  </body>
</html>
