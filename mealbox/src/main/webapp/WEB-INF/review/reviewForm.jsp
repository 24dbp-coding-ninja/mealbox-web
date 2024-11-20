<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>리뷰 페이지</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/review/reviewForm.css" />
    </head>
    <body>    
        <jsp:include page="../nav.jsp"/>
        <form id="container" action="/mealbox/review/createReview" method="POST">
	        <h2 align="center">리뷰 작성</h2>
	        <hr/>
	        <div id="reviewWrapper">
	            <div id="formWrapper" align="center">                
	                <div id="itemList" align="center">
	                    <!-- 상품 내역이 동적으로 추가되는 경우 예시 -->
	                    <c:forEach var="item" items="${items}">
	                        <div class="item">
	                            <div id="buyProduct">
	                                <img src="${item.imageUrl}" alt="${item.name}">
	                            </div>
	                            <div id="productDescript">
	                            	<div>
	                            		<p><strong>상품명</strong></p>
	                    				<p>${item.name}</p>
	                            	</div>
	                    			<div>
		                    			<p><strong>상품설명</strong></p>
		                                <p>${item.description}</p>
		                            </div>
	                            </div>
	                        </div>
	                    </c:forEach>
	                </div>
	               	<p align="left" style="margin-left: 25px;"><strong>리뷰 쓰기</strong></p>
	               	<input id="writeReview" name="reviewText" placeholder="구매하신 상품에 대해 리뷰를 남겨주세요.">
	                <div id="show">
		                <div id="rate">
		                	<p align="left" style="margin-left: 25px;"><strong>평점</strong></p> 
	                        <input id="writeRating" name="rating">
		                </div>
	                    <div id="pics">
	                        <p align="left" style="margin-left: 30px;"><strong>사진을 첨부해주세요.</strong></p>
	                        <span id="pic">
	                            <button type="button" id="pic1" name="reviewImg">+</button>
	                            <button type="button" id="pic2" name="reviewImg2">+</button>
	                            <button type="button" id="pic3" name="reviewImg3">+</button>
	                        </span>
	                    </div>
	                </div>
	
	                <div id="btn">
	                    <button type="button"><strong>취소</strong></button>
	                    <button type="submit"><strong>저장</strong></button>
	                </div>
	            </div>
	        </div>
        </form>
    </body>
</html>