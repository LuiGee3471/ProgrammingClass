<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");

  String name = request.getParameter("name");
  int age = Integer.parseInt(request.getParameter("age"));
  String gender = request.getParameter("gender");
  String email = request.getParameter("email");
  String id = request.getParameter("id");
  Connection conn = null;
  PreparedStatement pstmt = null;

  try {
    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
    String sql = "update koreamember set name=?, age=?, gender=?, email=? where id=?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, name);
    pstmt.setInt(2, age);
    pstmt.setString(3, gender);
    pstmt.setString(4, email);
    pstmt.setString(5, id);

    int row = pstmt.executeUpdate();
    if (row > 0) {
        response.sendRedirect("Ex03_Memberlist.jsp");
    } else {
        response.sendRedirect("Ex03_Memberlist.jsp");
    }
  } catch (Exception e) {
      System.out.println(e.getMessage());
  }
%>

 