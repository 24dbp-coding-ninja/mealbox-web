<!-- login.jsp 경로까지 모두 완료 -->
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
	<!--login.css-->
	<link rel="stylesheet" type="text/css" href="../../css/login.css"/>
	<script>
	function login() {
		if (form.userId.value == "") {
			form.userId.focus();
			return false;
		} 
		if (form.password.value == "") {
			form.password.focus();
			return false;
		}		
		form.submit();
	}

	function userCreate(targetUri) {
		var form = document.forms[0];  // 첫 번째 폼을 참조
		form.action = targetUri;
		form.method="GET";		// register form 요청
		form.submit();
	}
	</script>
	<title>로그인</title>
</head>
<body>
    <jsp:include page="../nav.jsp"/>

    <form id="container" method="POST"action="/mealbox/user/login" >
        <!--로그인 헤더 부분-->
        <header>
            <h1 id="login_title" align="center">로그인</h1>
            <hr>
        </header>
        <!--로그인 메인 부분-->
        <main>
            <input type="text" id="id" name="userid" placeholder="아이디를 입력해주세요">
            <input type="password" id="password" name="password" placeholder="비밀번호를 입력해주세요">
        </main>
        <div id="login_buttons">
            <!--할일)버튼 링크는 나중에 js파일에서 함수화해가지고 연결하여 가독성 높이기-->
            <!--버튼 태그에 type을 명시하는 이유: button태그의 기본값이 submit이기 때문에-->
            <input type="submit" id="button_login" value="로그인" onClick="login()">
            <button type="button" id="button_join" onClick="userCreate('/mealbox/user/join/form')">회원가입</button>
        </div>
    </form>
</body>
</html>