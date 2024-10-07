<!-- ����) js�� include-html ��� ����-->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--��Ʈ-->
	<link rel="preconnect" href="https://rsms.me/" />
	<link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
	<!--login.css-->
	<link rel="stylesheet" type="text/css" href="../../css/login.css"/>
	<!--login.js-->
	<script src="../js/login.js"></script>
	<!--html include-->
	<script src="../js/includeHTML.js"></script>
	<script src="../js/sidebar.js"></script>
	<!-- ����) User3 loginForm �����Ͽ� script �ֱ� -->
	<title>�α���</title>
</head>
<body>
	<nav include-html="../html/nav.html"></nav>
    <script>includeHTML();</script>

    <!--����)submit�ϸ� form�� jsp���Ϸ� �Ѱ����� jsp���Ͽ��� join_success.html�� redirect�ϵ��� �����ϱ�-->
    <!--������)post�� �ϸ� visual studio code���� ������ �� �ȵ�. �׳� ũ������ ������ ���� post�� �ص� ������.-->
    <form id="container" action="../html/main.html" method="get">
        <!--�α��� ��� �κ�-->
        <header>
            <h1 id="login_title" align="center">�α���</h1>
            <hr>
        </header>
        <!--�α��� ���� �κ�-->
        <main>
            <input type="text" id="id" placeholder="���̵� �Է����ּ���"/>
            <input type="password" id="password" placeholder="��й�ȣ�� �Է����ּ���"/>
        </main>
        <div id="login_buttons">
            <!--����)��ư ��ũ�� ���߿� js���Ͽ��� �Լ�ȭ�ذ����� �����Ͽ� ������ ���̱�-->
            <!--��ư �±׿� type�� ����ϴ� ����: button�±��� �⺻���� submit�̱� ������-->
            <input type="submit" id="button_login" value="�α���" onclick="login()">
            <button type="button" id="button_join" onclick="userCreate('<c:url value='/user/register'/>')">ȸ������</button>
        </div>
    </form>
</body>
</html>