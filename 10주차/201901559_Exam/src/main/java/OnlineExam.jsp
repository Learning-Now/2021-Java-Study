<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.*"%>
<%
    request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
</head>

<SCRIPT>
    function Check() {
        document.examform.submit();
    }
    function startTimer() {
        var time = new Date();
        hours = time.getHours();
        mins = time.getMinutes();
        secs = time.getSeconds();
        closeTime = hours * 3600 + mins * 60 + secs;
        closeTime += 90;
        Timer();
    }
    function Timer() {
        var time = new Date();
        hours = time.getHours();
        mins = time.getMinutes();
        secs = time.getSeconds();
        curTime = hours * 3600 + mins * 60 + secs //현재 시간 설정
        if (curTime >= closeTime)
            document.examform.submit();
        else
            timeLeft();
    }
    function timeLeft() {
        count = closeTime - curTime;
        document.getElementById("timeLeft").innerHTML = count;
        window.setTimeout("Timer()", 1000)
    }
</SCRIPT>

<body ONLOAD="startTimer()">
<span id="timeLeft"></span>초
</font>
</b>
<br>
<a href="Exam_Main.jsp"> 메인으로 돌아가기 </a>
<br>
<br>
<%
    String sessionID = (String) session.getAttribute("id");
    if ((session.getAttribute("id") == null)) {
        out.println("<script>");
        out.println("location.href='Exam_Main.jsp'");
        out.println("</script>");
    }
%>
<%!
    String[] STRRandom(String e1, String e2, String e3, String e4) {
        String[] result = new String[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++)
            result[i] = "";
        int count = 0;
        while (true) {
            if (count == 4)
                break;
            int k = random.nextInt(4);
            if (result[k].equals("")) {
                switch (count) {
                    case 0:
                        result[k] = e1;
                        count++;
                        break;
                    case 1:
                        result[k] = e2;
                        count++;
                        break;
                    case 2:
                        result[k] = e3;
                        count++;
                        break;
                    case 3:
                        result[k] = e4;
                        count++;
                        break;
                }
            }
        }
        return result;
    }%>
<%
    String id = null;
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";

    try {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "nyj1559", "pass123");
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM ( SELECT * FROM QUIZ ORDER BY DBMS_RANDOM.RANDOM) where rownum<= 5 ");
    }
    catch (Exception e) {
        e.printStackTrace();
    }
%>

<form name="examform" action="Exam_Result.jsp" method="post">
    <%
        for (int i = 0; rs.next(); i++) {
            int munje_num = rs.getInt("Q_NUM");
            int n = i + 1;
            String munje = rs.getString("Q_QUESTION");
            String munje_type = rs.getString("Q_TYPE");
            String Q_EX1 = rs.getString("Q_EX1");
            String Q_EX2 = rs.getString("Q_EX2");
            String Q_EX3 = rs.getString("Q_EX3");
            String Q_EX4 = rs.getString("Q_EX4");
            String dap = rs.getString("Q_ANSWER");
            String[] show = STRRandom(Q_EX1, Q_EX2, Q_EX3, Q_EX4);
            out.println(n + "번 문제" + "&nbsp;&nbsp;&nbsp;" + munje + "<br/>");
            if (munje_type.equals("IT")) {
                out.println("<br>");
            }
            for (int j = 0; j < 4; j++) {
                if (munje_type.equals("TI")) {
    %>
    <td><input type="radio" name="Q_EX<%=i%>" value="<%=show[j]%>">
        <%=show[j]%></td>
    <%
    } else {
    %>

    <input type="radio" name="Q_EX<%=i%>" value="<%=show[j]%>">
    <%=show[j]%>
    &nbsp;
    <%
            }
        }
    %>
    <input type="hidden" name="Q_ANSWER<%=i%>" value="<%=dap%>"> <br>
    <%
        }
    %>

    <input type="submit" value="제출">
</form>
</body>
</html>