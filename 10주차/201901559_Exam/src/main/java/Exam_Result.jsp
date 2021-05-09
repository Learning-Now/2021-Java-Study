<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import=" java.util.Date"%>
<%
    request.setCharacterEncoding("euc-kr");
    Connection conn = null;
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    Class.forName(driver);
    conn = DriverManager.getConnection(url, "nyj1559", "pass123");
    Statement stmt = conn.createStatement();
    String SQL = "SELECT * FROM ( SELECT * FROM QUIZ ORDER BY DBMS_RANDOM.RANDOM) where rownum<= 5 ";
    ResultSet rs = stmt.executeQuery(SQL);
    String sessionID = (String) session.getAttribute("id");
    String sessionName = (String) session.getAttribute("name");
    if ((session.getAttribute("id") == null)) {
        out.println("<script>");
        out.println("location.href='Exam_Main.jsp'");
        out.println("</script>");
    }
    else {
        int score = 0;
        for (int i = 0; rs.next(); i++) {
            String bogi = request.getParameter(("Q_EX" + String.valueOf(i)));
            String dap = request.getParameter("Q_ANSWER" + String.valueOf(i));
            if (bogi == null) {
                continue;
            }
            if (dap.equals(bogi))
                score++;
        }
        String SQL1 = "update SCORE set S_GRADE = ? where S_Hakbun = ?";
        PreparedStatement pstmt = conn.prepareStatement(SQL1);
        pstmt.setString(1, Integer.toString(score));
        pstmt.setString(2, (String) session.getAttribute("id"));
        pstmt.executeUpdate();
        pstmt.close();
        stmt.close();
        conn.close();
%>

<table>
    <center>
        <tr>
            <td>학번</td>
            <td>
                <%
                    out.println(sessionID);
                %>
            </td>
        </tr>
        <tr>
            <td>이름</td>
            <td>
                <%
                    out.println(sessionName);
                %>
            </td>
        </tr>
        <tr>
            <td>점수</td>
            <td><%=score%></td>
        </tr>
        <tr>
            <td colspan="2"><a href="Exam_TotalResult.jsp">점수 리스트 보기</a></td>
        </tr>
    </center>
</table>
<%
        session.invalidate();
    }
%>