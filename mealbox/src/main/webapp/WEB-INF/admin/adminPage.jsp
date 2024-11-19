<%--
기능: adminPage jsp 
작성자: 신윤지
마지막 수정일: 2024-11-05
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="preconnect" href="https://rsms.me/" />
<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
<link rel="stylesheet" type="text/css" href="css/admin.css" />
<script>
	function submitForm(action) {
    const form = document.getElementById('productForm');
    
    // context path가 있을 경우를 대비해 기본 경로 설정
    const contextPath = '${pageContext.request.contextPath}';
    const checkedBoxes = document.querySelectorAll('.product_checkbox:checked');
    
    console.log(checkedBoxes);
    
    // 상품 등록
    if(action === 'create') {
    	form.action = contextPath + '/admin/create';bn
    	form.submit();
    	return;
    }
    
    // 선택된 체크박스가 없는 경우
    if(checkedBoxes.length === 0) {
    	alert("수정 혹은 삭제될 상품이 선택되지 않았습니다.");
    	return;
    }
    
    switch(action) {
    	// 상품 수정
    	case 'update':
        	form.action = contextPath + '/admin/update';
    	    form.submit();
    		break;
    	
    	// 상품 삭제
    	case 'delete':
    		break;
    }
	}
	

	function toggleAllCheckboxes(source) {
	    const checkboxes = document.querySelectorAll('.product-checkbox');
	    checkboxes.forEach(checkbox => {
	        checkbox.checked = source.checked;
	    });
	}
</script>
<title>상품 관리 어드민 페이지</title>
</head>
<body>
	<%@ include file="../nav.jsp"%>
	<div id="adminContainer">
		<h1>상품 관리</h1>
		<form id="productForm" method="POST" enctype="multipart/form-data">
			<div id="selectedActionContainer">
				<input type="button" onclick="submitForm('create')" name="action" value="상품 추가" />
				<input type="button" onclick="submitForm('update')" name="action" value="선택 수정" />
				<input type="button" onclick="submitForm('delete')" name="action" value="선택 삭제" />
			</div>
			<div id="hr"></div>
			<div id="formContainer">
				<div id="labelContainer">
					<span> <input type="checkbox" name="selected" onclick="toggleAllCheckboxes(this)" />
					</span> <span>상품코드</span> <span>이미지</span> <span>설명</span> <span>상품명</span>
					<span>판매가격</span> <span>재고</span> <span>리뷰수</span> <span>평점</span>
					<span>인원</span> <span>음식 종류</span>
				</div>
				<div id="formWrapper">
					<div>추가</div>
					<div>&nbsp;</div>
					<div>
						<input type="file" id="newThumb" name="newThumb" />
					</div>
					<div>
						<textarea id="newDescription" name="newDescription" rows="3"></textarea>
					</div>
					<div>
						<input type="text" id="newName" name="newName" />
					</div>
					<div>
						<input type="text" id="newPrice" name="newPrice" />
					</div>
					<div>
						<input type="text" id="newStock" name="newStock" />
					</div>
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

				<c:forEach var="product" items="${productList}">
					<div id="formWrapper">
						<div>
							<input type="checkbox" class="product_checkbox" name="checked_${product.id}" value="${product.id}"/>
						</div>
						<div>
							<input type="text" id="id" name="id_${product.id}" value="${product.id}" readonly />
						</div>
						<div>
							<input type="file" id="thumb" name="thumb_${product.id}" value="${product.thumb}" />
						</div>
						<div>
							<textarea id="description" name="description_${product.id}" rows="3">${product.description}</textarea>
						</div>
						<div>
							<input type="text" id="name" name="name_${product.id}" value="${product.name}" />
						</div>
						<div>
							<input type="text" id="price" name="price_${product.id}" value="${product.price}원" />
						</div>
						<div>
							<input type="text" id="stock" name="stock_${product.id}" value="${product.stock}" />
						</div>
						<div>${product.totalReview}</div>
						<div>${product.averageReview}</div>
						<div>
							<select name="foodTypeCategory_${product.id}">
								<option value="1"
									<c:if test="${product.categoryType eq 1}">selected</c:if>>양식</option>
								<option value="2"
									<c:if test="${product.categoryType eq 2}">selected</c:if>>중식</option>
								<option value="3"
									<c:if test="${product.categoryType eq 3}">selected</c:if>>분식</option>
								<option value="4"
									<c:if test="${product.categoryType eq 4}">selected</c:if>>뭔식</option>
							</select>
						</div>
						<div>
							<select name="peopleCategory_${product.id}">
								<option value="1"
									<c:if test="${product.categoryPerson eq 1}">selected</c:if>>1~2인용</option>
								<option value="2"
									<c:if test="${product.categoryPerson eq 2}">selected</c:if>>3~4인용</option>
							</select>
						</div>
					</div>
				</c:forEach>
			</div>
		</form>
	</div>
</body>
</html>
