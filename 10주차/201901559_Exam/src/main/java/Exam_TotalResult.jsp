<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
</head>
<body>
<table border = 1>
    <center>
        <tr>
            <td colspan="4">Score List</td>
        </tr>
        <tr>
            <td>�й�</td>
            <td>�̸�</td>
            <td>����</td>
            <td>������ �ð�</td>
        </tr>
        <%
            String id = null;
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            String driver = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "nyj1559", "pass123");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM score");
            while (rs.next()) {
                String hakbun = rs.getString("S_Hakbun");
                String name = rs.getString("S_Name");
                String grade = rs.getString("S_GRADE");
                String date = rs.getString("Q_INDATE");

                if(hakbun.equals("admin"))
                {
                    continue;
                }
        %>

        <tr>
            <td><%=hakbun%></td>
            <td><%=name%></td>
            <td><%=grade%></td>
            <td><%=date%></td>
        </tr>
        <%
            };
        %>
    </center>
</table>
</body>
</html>