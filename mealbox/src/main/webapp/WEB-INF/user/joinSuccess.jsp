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
<!--joinSuccess.css-->
<link rel="stylesheet" type="text/css" href="../../css/joinSuccess.css"/>
<!--html include-->
<script src="../js/includeHTML.js"></script>
<script src="../js/sidebar.js"></script>
<title>ȸ������ �Ϸ�</title>
</head>
<body>
    <nav include-html="../html/nav.html"></nav>
    <script>includeHTML();</script>

    <div id="container">
        <!--ȸ������ ��� �κ�-->
        <header>
            <h1 id="join_title" align="center">ȸ������</h1>
            <div id="progress">
                <hr>
                <span id="progress_inputInfo">�����Է�</span> 
                <div id="progress_sign">
                    <img src="../images/arrow.png">
                </div>
                <span id="progress_complete">���ԿϷ�</span>
                <hr>
            </div>
        </header>

        <!--ȸ������ ���� �κ�-->
        <main id="joinSuccess_main">
           <div>ȸ������ �Ϸ�</div>
           <div>ȫ�浿����<br>
            ȸ�������� �Ϸ�Ǿ����ϴ�.</div>
        </main>
        <div id="joinSuccess_buttons">
            <!--����)��ư ��ũ�� ���߿� js���Ͽ��� �Լ�ȭ�ذ����� �����Ͽ� ������ ���̱�-->
            <button class="style_button" onclick="location.href='../html/login.html'">�α���</button>
            <button class="style_button" onclick="location.href='../html/main.html'">��������</button>
        </div>
    </div>
</body>
</html>