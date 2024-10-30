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
    <!--join.css-->
    <link rel="stylesheet" type="text/css" href="../../css/join.css"/>
    <!--join.js-->
    <script src="../js/join.js"></script>
    <!--html include-->
    <script src="../js/includeHTML.js"></script>
    <script src="../js/sidebar.js"></script>
<title>ȸ������</title>
</head>
<body>
	<nav include-html="../html/nav.html"></nav>
    <script>includeHTML();</script>

    <!--����)submit�ϸ� form�� jsp���Ϸ� �Ѱ����� jsp���Ͽ��� join_success.html�� redirect�ϵ��� �����ϱ�-->
    <!--������)post�� �ϸ� visual studio code���� ������ �� �ȵ�. �׳� ũ������ ������ ���� post�� �ص� ������.-->
    <form id="container" action="../html/joinSuccess.html" method="get">
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
        <main id="join_main">
            <div id="join_label">
                <div><label for="id">���̵� <font color="red">*</font></label></div>
                <div><label for="password">��й�ȣ <font color="red">*</font></label></div>
                <div><label for="check_password">��й�ȣ Ȯ�� <font color="red">*</font></label></div>
                <div><label for="name">�̸�</label></div>
                <div><label for="phoneNum">��ȭ��ȣ</label></div>
                <div><label for="email">�̸���</label></div>
                <div><label for="address">�ּ�</label></div>
            </div>
            <div id="join_input">
                <!--����)�������� �����ϱ�-->
                <input type="text" id="id" required>
                <div class="text" id="text_id">�̹� �����ϴ� ���̵��Դϴ�.</div>
                <input type="password" id="password" required>
                <div class="text" id="text_password">Ư������, �ҹ���, ���ڸ� �����ϸ� 8�� �̻��̾�� �մϴ�.</div>
                <input type="password" id="check_password" required>
                <div class="text" id="text_checkPassword">��й�ȣ�� ��ġ���� �ʽ��ϴ�.</div>
                <input type="text" id="name" required>
                <div class="text" id="text_name">�̸��� �ʼ��Է� �׸��Դϴ�.</div>
                <div id="phone">
                    <input type="text" id="phone_part1" maxlength="3" required>
                    <span>-</span>
                    <input type="text" id="phone_part2" maxlength="4" required>
                    <span>-</span>
                    <input type="text" id="phone_part3" maxlength="4" required>
                </div>
                <div class="text" id="text_phone">��ȭ��ȣ�� �ʼ��Է� �׸��Դϴ�.</div>
                <div id="email">
                    <input type="text" id="email_id">
                    <span>@</span>
                    <input type="text" id="email_domain">
                </div>
                <div class="text"><font color="white">����ֽ��ϴ�</font></div>
                <input type="text" id="address">
                <div class="text"><font color="white">����ֽ��ϴ�</font></div>
            </div>
            <div id="join_checkID"><button type="button" class="style_button" id="check_ID" onclick="checkValidId()">�ߺ�Ȯ��</button></div>
        </main>
        <div id="buttons">
            <!--����)��ư ��ũ�� ���߿� js���Ͽ��� �Լ�ȭ�ذ����� �����Ͽ� ������ ���̱�-->
            <!--��ư �±׿� type�� ����ϴ� ����: button�±��� �⺻���� submit�̱� ������-->
            <button type="button" class="style_button" id="before" onclick="history.back();">����</button>
            <input type="submit" class="style_button" id="after" value="����" onclick="check()">
        </div>
    </form>
</body>
</html>