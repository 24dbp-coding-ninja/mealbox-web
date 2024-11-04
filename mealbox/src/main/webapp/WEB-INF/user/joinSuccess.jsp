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
<!--joinSuccess.css-->
<link rel="stylesheet" type="text/css" href="../../css/joinSuccess.css"/>
<!--html include-->
<script src="../js/includeHTML.js"></script>
<script src="../js/sidebar.js"></script>
<title>회원가입 완료</title>
</head>
<body>
    <nav include-html="../html/nav.html"></nav>
    <script>includeHTML();</script>

    <div id="container">
        <!--회원가입 헤더 부분-->
        <header>
            <h1 id="join_title" align="center">회원가입</h1>
            <div id="progress">
                <hr>
                <span id="progress_inputInfo">정보입력</span> 
                <div id="progress_sign">
                    <img src="../images/arrow.png">
                </div>
                <span id="progress_complete">가입완료</span>
                <hr>
            </div>
        </header>

        <!--회원가입 메인 부분-->
        <main id="joinSuccess_main">
           <div>회원가입 완료</div>
           <div>홍길동님의<br>
            회원가입이 완료되었습니다.</div>
        </main>
        <div id="joinSuccess_buttons">
            <!--할일)버튼 링크는 나중에 js파일에서 함수화해가지고 연결하여 가독성 높이기-->
            <button class="style_button" onclick="location.href='../html/login.html'">로그인</button>
            <button class="style_button" onclick="location.href='../html/main.html'">메인으로</button>
        </div>
    </div>
</body>
</html>