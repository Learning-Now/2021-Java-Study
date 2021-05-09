<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%
    request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
    <title>회원관리 시스템 로그인 페이지</title>
</head>

<script language=javascript>
    function valid_check() {
        if (document.joinform.id.value == "") {
            alert("학번을 입력하여 주시기 바랍니다.");
            document.joinform.id.focus();
            return false;
        }
        for (var i = 0; i < document.joinform.age.value.length; i++) {
            if (document.joinform.age.value.charAt(i) < "0"
                || document.joinform.age.value.charAt(i) > "9")
            {
                alert("학번은 숫자만 가능합니다. ");
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
        <tr><td>학번</td><td><input type="text" name="id" readonly /></td>
            <input TYPE=button VALUE="학번 검사" onclick="check_id()"
                   onmouseover="this.style.cursor='hand';">
        </tr><tr><td>이름</td>
        <td><input type="text" name="name" /></td>
    </tr><tr>
        <td colspan="2" align=center><input type="submit" value="로그인"></td></tr><tr>
        <td colspan = 2 align=center><a href = "Exam_TotalResult.jsp">점수 보기</a>
        </td></tr></table></center></form></body></html>