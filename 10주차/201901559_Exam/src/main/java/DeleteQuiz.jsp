<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html><body>
<%
    String del_num = request.getParameter("num");

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    Connection conn = null;
    Class.forName(driver);
    conn = DriverManager.getConnection(url, "nyj1559", "pass123");
    ResultSet rs = null;
    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM QUIZ where Q_NUM = ?");
    pstmt.setString(1, del_num);

    pstmt.executeUpdate();
    pstmt.close();
    conn.close();
%>

<a href = "Admin.jsp">퀴즈가 삭제되었습니다.</a></body></html>