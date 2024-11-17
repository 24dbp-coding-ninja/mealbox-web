<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--폰트-->
<link rel="preconnect" href="https://rsms.me/" />
<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
<!--join.css: css경로 변경하지 말 것-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminUserPage.css"/>
<title>회원관리페이지</title>
</head>
<body>
	<jsp:include page="../nav.jsp"/>
    <div id = "container">
        <!--adminUserPage header부분-->
        <header>
            <div>회원관리</div>
            <button>선택삭제</button>
        </header>
        <main id = "adminUserPageMain">
            <table>
                <tr>
                    <th><input type="checkbox"/></th>
                    <th>회원번호</th>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>주소</th>
                    <th>이메일</th>
                    <th>주문건수</th>
                    <th>등록리뷰수</th> 
                </tr>
                <tr>
                    <td><input type="checkbox"/></td>
                    <td>1</td>
                    <td>hihihihihi</td>
                    <td>hellohello</td>
                    <td>김솜솜</td>
                    <td>000-0000-0000</td>
                    <td>서울시 땡땡구 땡땡로 99땡길9 999동 999호</td>
                    <td>hihihihi@naver.com</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td><input type="checkbox"/></td>
                    <td>2</td>
                    <td>222</td>
                    <td>비번2</td>
                    <td>신솜솜</td>
                    <td>000-0000-0000</td>
                    <td>15</td>
                    <td>4@5</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td><input type="checkbox"/></td>
                    <td>3</td>
                    <td>333</td>
                    <td>비번3</td>
                    <td>장솜솜</td>
                    <td>000-0000-0000</td>
                    <td>10</td>
                    <td>@3</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td><input type="checkbox"/></td>
                    <td>4</td>
                    <td>444</td>
                    <td>비번4</td>
                    <td>홍솜솜</td>
                    <td>000-0000-0000</td>
                    <td>0</td>
                    <td>@0</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
            </table>
        </main>
    </div>
</body>
</html>