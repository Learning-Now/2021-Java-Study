<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
    <title>ȸ������ �ý��� �α��� ������</title>
</head>

<script language=javascript>
    function valid_check() {
        if (document.joinform.id.value == "") {
            alert("�й��� �Է��Ͽ� �ֽñ� �ٶ��ϴ�.");
            document.joinform.id.focus();
            return false;
        }
        for (var i = 0; i < document.joinform.age.value.length; i++) {
            if (document.joinform.age.value.charAt(i) < "0"
                || document.joinform.age.value.charAt(i) > "9")
            {
                alert("�й��� ���ڸ� �����մϴ�. ");
                document.joinform.age.focus();
                return;
            }
        }
        document.joinform.submit();
    }
    function check_id() {
        var JSPName = "Id_Check.jsp";
        browsing_window = window.open(JSPName, "_idcheck",
            "height=220,width=420");
        browsing_window.focus();

    }
</script>

<body>
<form name="loginform" action="Exam_Process.jsp" method="post">
    <center><table border=1>
        <tr><td>�й�</td><td><input type="text" name="id" readonly /></td>
            <input TYPE=button VALUE="�й� �˻�" onclick="check_id()"
                   onmouseover="this.style.cursor='hand';">
        </tr><tr><td>�̸�</td>
        <td><input type="text" name="name" /></td>
    </tr><tr>
        <td colspan="2" align=center><input type="submit" value="�α���"></td></tr><tr>
        <td colspan = 2 align=center><a href = "Exam_TotalResult.jsp">���� ����</a>
        </td></tr></table></center></form></body></html>