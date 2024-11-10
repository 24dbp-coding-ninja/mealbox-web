<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>상품 상세 페이지</title>
        <link rel="stylesheet" href="../../css/review/productDetailPage.css">
        <link rel="preconnect" href="https://rsms.me/" />
        <link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
        <script src="../js/productDetailPage.js"></script>
    </head>
    <body>
        <div>
            <nav include-html="../../mealbox-web/html/nav.html"></nav>
            <script>
              includeHTML();
            </script>
        </div>

        <div class="container meal">
            <div class="meal_img">
                <img id="product_image" src="<c:out value='${product.thumb}'/>" alt="<c:out value='${product.name}'/>">
            </div>
            <div class="details_container">
                <h3 id="product_name"><c:out value="${product.name}"/></h3>
                <div class="rating">
                    <span id="display_rating_stars">${averageScore}점</span> |
                    <span id="product_rating_score">${product.getTotalReview()} 리뷰</span>
                </div>
                <p class="price" id="product_price">${product.price}원</p>
                <div class="quantity">
                    <div id="product_description"><c:out value="${product.description}"/></div>
                    <hr>
                    <div class="check_quantity">
                        <div class="plusOrMinus">
                            <button class="decrease">-</button>
                            <input type="number" id="quantity" value="1" min="1" readonly>
                            <button class="increase">+</button>
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
        <iframe src="<%= request.getContextPath() %>/reviewPage.jsp" class="review-frame" title="리뷰"></iframe>
    </body>
</html>
