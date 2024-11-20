<%-- 기능: orderListPage jsp 작성자: 장고은 마지막 수정일: 2024-11-04 --%>
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
    <jsp:include page="../nav.jsp" />
    <div id="container">
      <div id="title">주문목록</div>
      <div id="line">
        <hr />
      </div>
      <div id="listContainer">
        <p>구매상품내역</p>
        <hr />
        <c:forEach var="orderProduct" items="${orderList}">
          <div class="item">
            <form action="/orders/${orderProduct.orderId}/products/${orderProduct.lineNo}" method="post">
              <div class="itemInfo1">
                <img src="${orderProduct.imageUrl}" alt="상품 이미지" />
              </div>
              <div class="itemInfo2">
                <p>상품명: ${orderProduct.productName}</p>
                <p>상품수량: ${orderProduct.quantity}</p>
                <p>총가격: ${orderProduct.orderItemPrice}원</p>
              </div>
              <div class="itemInfo3">
                <!-- 리뷰작성 버튼 -->
                <button type="submit" formaction="/reviews/write">리뷰작성</button>
                <!-- 장바구니 추가 버튼 -->
                <button type="submit" formaction="/cart/add">장바구니</button>
              </div>
            </form>
          </div>
        </c:forEach>
      </div>
    </div>
  </body>
</html>
