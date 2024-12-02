<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>리뷰 등록/수정</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/review/reviewForm.css" />
    </head>
    <body>    
        <jsp:include page="../nav.jsp"/>
        <form id="container" action="/mealbox/review/create" method="POST">
	        <div id="title" align="center" style="font-size: 36px; margin-top: 50px; margin-bottom: 10px;">리뷰 등록/수정</div>
		    <div id="line">
		        <hr />
		    </div>
	        <div id="reviewWrapper">
		        
	            <div id="formWrapper">                
	                <div id="itemList">
	                    <!-- 상품 내역 정보 -->
	                    
	                        <div class="item">
	                            <div id="buyProduct">
	                                <img alt="상품사진" src="${product.thumb}"/>
	                            </div>
	                            <div id="productDescript">
	                            	<div>
	                            		<strong>상품명: </strong>${product.name}
	                            		<br/>
		                    			<strong>상품설명: </strong>${product.description}
		                            </div>
	                            </div>
	                        </div>
	                    
	                </div>
	                <!-- 실제로 넘길 부분 -->
	               	<p align="left" style="margin-top: 20px; margin-left: 25px;"><strong>리뷰 쓰기</strong></p>
	               	<input id="writeReview" name="reviewText" placeholder="구매하신 상품에 대해 리뷰를 남겨주세요.">
					<input style="display: none;" name="productId" value="${product.id}" />
	                <div id="show">
		                <div id="rate">
		                	<p align="left" style="margin-top: 10px; margin-bottom: 10px; margin-left: 30px;"><strong>평점</strong></p> 
	                        <input id="writeRating" name="rating" style="margin-left: 10px; text-align: center;">
		                </div>
	                    <div id="pics">
	                        <p align="left" style="margin-top: 10px; margin-bottom: 10px; margin-left: 30px;"><strong>사진을 첨부해주세요.</strong></p>
	                        <span id="pic">
	                            <button type="button" id="pic1" name="reviewImg">+</button>
	                            <button type="button" id="pic2" name="reviewImg2">+</button>
	                            <button type="button" id="pic3" name="reviewImg3">+</button>
	                        </span>
	                    </div>
	                </div>
	                <!-- 버튼 부분 -->	
	                <div id="btn">
	                    <button type="submit">
	                    	<c:set var="btnName" value="cancel" scope="request"/>
	                    	<strong>취소</strong>
	                    </button>
	                    <button type="submit">
							<c:set var="btnName" value="save" scope="request"/>
							<strong>저장</strong>
						</button>	                    
	                </div>
	            </div>
	        </div>
        </form>
    </body>
</html>