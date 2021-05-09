<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
    request.setCharacterEncoding("euc-kr");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    Connection conn = null;
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    Class.forName(driver);
    conn = DriverManager.getConnection(url, "nyj1559", "pass123");
    Statement stmt = conn.createStatement();
    String SQL = "select S_Hakbun from SCORE where S_Hakbun = '" + id + "'";
    ResultSet rs = stmt.executeQuery(SQL);
    if(id.equals("admin"))
    {
        out.println("<script>");
        out.println("location.href='Admin.jsp'");
        out.println("</script>");
    }
    rs.next();
    if (rs != null)
    {
        try {
            String S_Hakbun = id;
            String S_Name = name;

            String SQL1 = "insert into SCORE(S_Hakbun, S_Name) values (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(SQL1);
            session.setAttribute("id", id);
            session.setAttribute("name", name);

            pstmt.setString(1, id);
            pstmt.setString(2, name);

            pstmt.executeUpdate();
            pstmt.close();
            stmt.close();
            conn.close();
            out.println("<script>");
            out.println("location.href='OnlineExam.jsp'");
            out.println("</script>");
        }
        catch (Exception e) {
            out.println("<script>");
            out.println("alert('학번 중복')");
            out.println("location.href='Exam_Main.jsp'");
            out.println("</script>");
        }
    }
    out.println("<script>");
    out.println("location.href='Exam_Main.jsp'");
    out.println("</script>");
%>