<%--
기능: cartPage jsp
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
    <title>cartPage</title>
	<link rel="stylesheet" href="../css/cartPage.css" />
  </head>
  <body>
	<jsp:include page="../nav.jsp"/>
    <div id="container">
    	<div id="title">장바구니 </div>
    	<div id="line">
    		<hr>	
    	</div>
    	<div id="listContainer">
    		<p>상품내역</p>
    		<hr>
    		<div class="item">
	   			<div class="itemInfo1">
	             	<img src="../images/cartItem.png" alt="상품 이미지" />
	            </div>
	            <div class="itemInfo2">
	              <p>상품명</p>
	              <form>
	                  <span>상품수량 </span> 
	                  <span class="btnContainer">
		                 <button class="btnQ" type="button" name="action" value="decrease">-</button>
		                 <span class="btnSpan">1</span>
		                 <button class="btnQ" type="button" name="action" value="increase">+</button>
	                  </span>
	             	  </form>
	            </div>
	            <div class="itemInfo3">
	           	  <!-- 삭제 버튼: 해당 상품 ID를 서버에 전달하여 삭제 -->
	              <form>
	                <button type="button" class="close-btn">X</button>
	              </form>
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
	              <form>
	                  <span>상품수량 </span> 
	                  <span class="btnContainer">
		                 <button class="btnQ" type="button" name="action" value="decrease">-</button>
		                 <span class="btnSpan">1</span>
		                 <button class="btnQ" type="button" name="action" value="increase">+</button>
	                  </span>
	             	  </form>
	            </div>
	            <div class="itemInfo3">
	           	  <!-- 삭제 버튼: 해당 상품 ID를 서버에 전달하여 삭제 -->
	              <form>
	                <button type="button" class="close-btn">X</button>
	              </form>
	              <p>총가격 13,000원</p>
	            </div>
    		</div>
    		<div class="item">
	   			<div class="itemInfo1">
	             	<img src="../images/cartItem.png" alt="상품 이미지" />
	            </div>
	            <div class="itemInfo2">
	              <p>상품명</p>
	              <form>
	                  <span>상품수량 </span> 
	                  <span class="btnContainer">
		                 <button class="btnQ" type="button" name="action" value="decrease">-</button>
		                 <span class="btnSpan">1</span>
		                 <button class="btnQ" type="button" name="action" value="increase">+</button>
	                  </span>
	             	  </form>
	            </div>
	            <div class="itemInfo3">
	           	  <!-- 삭제 버튼: 해당 상품 ID를 서버에 전달하여 삭제 -->
	              <form>
	                <button type="button" class="close-btn">X</button>
	              </form>
	              <p>총가격 13,000원</p>
	            </div>
    		</div>
    	</div>
    	<div id="totalMoney">
	        <p>결제예정금액</p>
	        <p id="money">13,000원</p>
        </div>
        <div id="btn">
	       <form>
	          <button type="button">구매하기</button>
	        </form>
	    </div>
    </div>
  </body>
</html>
