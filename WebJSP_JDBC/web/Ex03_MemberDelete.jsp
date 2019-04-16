<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
1. 권한검사
2. id값 parameter 받기
3. 삭제
4. 정상 삭제
--%>
<%
  if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
    // 강제로 다른 페이지로 이동
    out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
  }

  String id = request.getParameter("id");
  Connection conn = null;
  PreparedStatement pstmt = null;
  try {
    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
    String sql = "delete from koreamember where id = ?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);

    int row = pstmt.executeUpdate();

    if (row > 0) {
        response.sendRedirect("Ex03_Memberlist.jsp");
    }
  } catch (Exception e) {
    e.printStackTrace();
  } finally {

  }
%>

 
 
 