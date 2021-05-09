<%@ page language="java" import="java.util.*" import="java.sql.*"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<%
    String id = request.getParameter("id");

    boolean fnd = false;
    if (id == null)
        id = "";
    else {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        Connection conn = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "nyj1559", "pass123");
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        String strSQL = "SELECT S_Hakbun FROM SCORE WHERE S_Hakbun='" + id + "'";

        rs = stmt.executeQuery(strSQL);
        if (rs.next())
            fnd = true;

        stmt.close();
        conn.close();
    }
%>
<HTML>
<script language="JavaScript">
    function id_search()
    {
        var cnt = 0;

        for (var i = 0; i < document.form_id_check.id.value.length; i++) {
            if (document.form_id_check.id.value.charAt(i) < "0" || document.form_id_check.id.value.charAt(i) > "9")
            {
                cnt++;
            }
        }

        if(document.form_id_check.id.value=="admin")
        {
            document.form_id_check.submit();
        }

        else if(cnt)
        {
            alert("학번은 숫자만 가능합니다. ");
            document.form_id_check.id.focus();
        }

        else if(document.form_id_check.id.value=="")
        {
            alert("학번을 입력해 주세요.");
            document.form_id_check.id.focus();
        }

        else
        {
            document.form_id_check.submit();
        }
    }
    function id_ok(a)
    {
        opener.document.loginform.id.value=a;
        self.close();
    }

</script>
<BODY>
<BR>
<P align="center">사용할 학번을 입력 후 검색 버튼을 누르세요</P>
<FORM NAME="form_id_check" ACTION="Id_Check.jsp" METHOD="POST">
    <TABLE WIDTH="200">
        <TR>
            <TD WIDTH="150">ID</TD>
            <TD WIDTH="100"><INPUT TYPE="text" NAME="id" size="20"
                                   VALUE=<%=id%>></TD>

            <TD WIDTH="40"><INPUT TYPE="button" VALUE="검색"
                                  onClick="javascript:id_search()"></TD>
        </TR>
    </TABLE>
</FORM>
<%
    if (id != "" && fnd == false) {
%>
사용 가능한 학번입니다
<P>
    확인을 누르시면 돌아갑니다. <a href="javascript:id_ok('<%=id%>')"> 확인 </a>
        <%

		}

		else if(id.equals("admin"))
		{
			%>
    ADMIN입니다.
<P>
    확인을 누르시면 돌아갑니다. <a href="javascript:id_ok('<%=id%>')"> 확인 </a>
        <%
		}

		else if (id != "" && fnd == true) {
		%>
    이미 사용 중인 학번입니다.
        <%
			}
		%>

</BODY>
</HTML>