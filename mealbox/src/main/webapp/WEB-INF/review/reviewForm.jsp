<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>리뷰 페이지</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/reviewForm.css" />
    </head>
    <body>
        <div id="nav">nav</div>
        <div id="reviewWrapper">
            <div id="formWrapper">
                <h2 align="center">리뷰 작성</h2>
                <div id="itemList" align="center">
                    <p><strong>상품내역</strong></p>
                    <!-- 상품 내역이 동적으로 추가되는 경우 예시 -->
                    <c:forEach var="item" items="${items}">
                        <div class="item">
                            <div id="buyProduct">
                                <img src="${item.imageUrl}" alt="${item.name}" width="100" height="100">
                            </div>
                            <div id="productDescript">
                                <p>${item.description}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <hr />
                <p><strong>리뷰 쓰기</strong></p>
                <input id="writeReview" placeholder="구매하신 상품에 대해 리뷰를 남겨주세요.">
                
                <div id="show">
                    <span>
                        <p><strong>평점</strong></p>
                        <input id="writeRating">
                    </span>
                    <span>
                        <p><strong>사진을 첨부해주세요.</strong></p>
                        <span id="pic">
                            <button type="button" id="pic1">+</button>
                            <button type="button" id="pic2">+</button>
                            <button type="button" id="pic3">+</button>
                        </span>
                    </span>
                </div>

                <div id="btn">
                    <button type="button">취소</button>
                    <button type="button">저장</button>
                </div>
            </div>
        </div>
    </body>
</html>