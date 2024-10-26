<!-- 할일) js와 include-html 경로 수정-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--폰트-->
	<link rel="preconnect" href="https://rsms.me/" />
	<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
	<!--login.css-->
	<link rel="stylesheet" type="text/css" href="../../css/login.css"/>
	<!--login.js-->
	<script src="../js/login.js"></script>
	<!--html include-->
	<script src="../js/includeHTML.js"></script>
	<script src="../js/sidebar.js"></script>
	<!-- 할일) User3 loginForm 참고하여 script 넣기 -->
	<title>로그인</title>
</head>
<body>
	<nav include-html="../html/nav.html"></nav>
    <script>includeHTML();</script>

    <!--할일)submit하면 form은 jsp파일로 넘겨지고 jsp파일에서 join_success.html로 redirect하도록 구현하기-->
    <!--문제점)post로 하면 visual studio code에서 실행이 잘 안됨. 그냥 크롬으로 열었을 때는 post로 해도 동작함.-->
    <form id="container" action="../html/main.html" method="get">
        <!--로그인 헤더 부분-->
        <header>
            <h1 id="login_title" align="center">로그인</h1>
            <hr>
        </header>
        <!--로그인 메인 부분-->
        <main>
            <input type="text" id="id" placeholder="아이디를 입력해주세요"/>
            <input type="password" id="password" placeholder="비밀번호를 입력해주세요"/>
        </main>
        <div id="login_buttons">
            <!--할일)버튼 링크는 나중에 js파일에서 함수화해가지고 연결하여 가독성 높이기-->
            <!--버튼 태그에 type을 명시하는 이유: button태그의 기본값이 submit이기 때문에-->
            <input type="submit" id="button_login" value="로그인" onclick="login()">
            <button type="button" id="button_join" onclick="userCreate('<c:url value='/user/register'/>')">회원가입</button>
        </div>
    </form>
</body>
</html>