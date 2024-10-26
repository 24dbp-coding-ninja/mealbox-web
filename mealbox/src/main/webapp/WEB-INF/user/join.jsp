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
    <!--join.css-->
    <link rel="stylesheet" type="text/css" href="../css/join.css"/>
    <!--join.js-->
    <script src="../js/join.js"></script>
    <!--html include-->
    <script src="../js/includeHTML.js"></script>
    <script src="../js/sidebar.js"></script>
<title>회원가입</title>
</head>
<body>
	<nav include-html="../html/nav.html"></nav>
    <script>includeHTML();</script>

    <!--할일)submit하면 form은 jsp파일로 넘겨지고 jsp파일에서 join_success.html로 redirect하도록 구현하기-->
    <!--문제점)post로 하면 visual studio code에서 실행이 잘 안됨. 그냥 크롬으로 열었을 때는 post로 해도 동작함.-->
    <form id="container" action="../html/joinSuccess.html" method="get">
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
        <main id="join_main">
            <div id="join_label">
                <div><label for="id">아이디 <font color="red">*</font></label></div>
                <div><label for="password">비밀번호 <font color="red">*</font></label></div>
                <div><label for="check_password">비밀번호 확인 <font color="red">*</font></label></div>
                <div><label for="name">이름</label></div>
                <div><label for="phoneNum">전화번호</label></div>
                <div><label for="email">이메일</label></div>
                <div><label for="address">주소</label></div>
            </div>
            <div id="join_input">
                <!--할일)제한조건 구현하기-->
                <input type="text" id="id" required>
                <div class="text" id="text_id">이미 존재하는 아이디입니다.</div>
                <input type="password" id="password" required>
                <div class="text" id="text_password">특수문자, 소문자, 숫자를 포함하며 8자 이상이어야 합니다.</div>
                <input type="password" id="check_password" required>
                <div class="text" id="text_checkPassword">비밀번호가 일치하지 않습니다.</div>
                <input type="text" id="name" required>
                <div class="text" id="text_name">이름은 필수입력 항목입니다.</div>
                <div id="phone">
                    <input type="text" id="phone_part1" maxlength="3" required>
                    <span>-</span>
                    <input type="text" id="phone_part2" maxlength="4" required>
                    <span>-</span>
                    <input type="text" id="phone_part3" maxlength="4" required>
                </div>
                <div class="text" id="text_phone">전화번호는 필수입력 항목입니다.</div>
                <div id="email">
                    <input type="text" id="email_id">
                    <span>@</span>
                    <input type="text" id="email_domain">
                </div>
                <div class="text"><font color="white">비어있습니다</font></div>
                <input type="text" id="address">
                <div class="text"><font color="white">비어있습니다</font></div>
            </div>
            <div id="join_checkID"><button type="button" class="style_button" id="check_ID" onclick="checkValidId()">중복확인</button></div>
        </main>
        <div id="buttons">
            <!--할일)버튼 링크는 나중에 js파일에서 함수화해가지고 연결하여 가독성 높이기-->
            <!--버튼 태그에 type을 명시하는 이유: button태그의 기본값이 submit이기 때문에-->
            <button type="button" class="style_button" id="before" onclick="history.back();">이전</button>
            <input type="submit" class="style_button" id="after" value="다음" onclick="check()">
        </div>
    </form>
</body>
</html>