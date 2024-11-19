<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>리뷰 페이지</title>
        <link rel="stylesheet" href="/mealbox/css/review/reviewPage.css">
    </head>
    <body>
        <h2>상품 리뷰</h2>
        <div class="container">
            <div class="sort_options">
                <span class="sort_option" onclick="location.href='?sort=latest'">최신 순 |</span>
                <span class="sort_option" onclick="location.href='?sort=highRate'"> 평점 높은 순 |</span>
                <span class="sort_option" onclick="location.href='?sort=lowRate'">평점 낮은 순</span>
            </div>
            <div id="reviews">
                <c:forEach var="review" items="${reviews}">
                    <div class="review_header">
                        <img src="${review.profile}" alt="프로필 이미지" class="profile">
                        <div>${review.nickname}</div>
                    </div>

                    <span class="rating">
                        <!-- 리뷰 평점 출력 -->
                        <c:set var="fullStars" value="${floor(review.rating.score)}" />
                        <c:set var="hasHalfStar" value="${review.rating.score - fullStars >= 0.5}" />

                        <!-- 완전한 별 출력 -->
                        <c:forEach var="i" begin="1" end="${fullStars}">
                            ⭐️
                        </c:forEach>

                        <!-- 반쪽짜리 별 (빈 별을 사용) 출력 -->
                        <c:if test="${hasHalfStar}">
                            ☆
                        </c:if>

                        <!-- 빈 별 출력 (최대 5개의 별을 채우기 위해) -->
                        <c:forEach var="i" begin="${fullStars + (hasHalfStar ? 1 : 0)}" end="5">
                            ☆
                        </c:forEach>
                    </span>

                    <span>${review.date}</span>

                    <div class="review_text">
                        <p>${review.text}</p>
                        <img src="${review.reviewImg}" alt="상품 이미지" class="product_image">
                    </div>

                    <div class="footer">
                        <p>구매상품: ${review.product}</p>
                    </div>
                    <hr>
                </c:forEach>
            </div>
        </div>
    </body>
</html>