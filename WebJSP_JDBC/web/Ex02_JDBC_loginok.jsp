<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
  response.setCharacterEncoding("UTF-8");

  /*
    Ex02_JDBC_JoinForm.jsp에서 --> action="Ex02_JDBC_JoinOK.jsp"
    1. 한글처리
    2. 데이터 받기(ID, PWD)
    3. DB 연동(sql)
    4. 업무(로직) 처리

  --판단 조건
  1. ID 존재, PWD(O) > 회원 > Main Page 이동 > session.setAttribute()
  2. ID 존재, PWD(X) > 다시 한 번 로그인 처리
  3. ID 존재X > 회원 가입 페이지로 이동 처리

  1. Ex02_JDBC_Main.jsp
  2. Ex02_JDBC_Login.jsp
  3. Ex02_JDBC_JoinForm.jsp

  > sql : select id, pwd from koreamember where id=?
  > sql : select count from koreamember where id= ?

  >> SELECT
  1. 결과 없는 경우

  2. Single row

  3. Multi Row (회원 데이터)

  요구사항

  기능적 요구사항
  비기능적 요구사항
   */

  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");

  System.out.println(id);

  Class.forName("oracle.jdbc.OracleDriver");
  Connection conn = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  System.out.println(pstmt);

  try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
      String sql = "select id, pwd from koreaMember where id = ?";
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, id);

      rs = pstmt.executeQuery();
      if (rs.next()) {
          do {
            if (pwd.equals(rs.getString(2))) {
                session.setAttribute("userid", id);
                out.write("<script>");
                out.write("alert('성공'); location.href='Ex02_JDBC_Main.jsp';");
                out.write("</script>");
            } else {
                out.write("<script>");
                out.write("alert('비밀번호가 다름'); location.href='Ex02_JDBC_Login.jsp';");
                out.write("</script>");
            }
          } while(rs.next());
      } else {
          out.write("<script>");
          out.write("alert('회원가입이 안됨'); location.href='Ex02_JDBC_JoinForm.jsp';");
          out.write("</script>");
      }
  } catch (Exception e) {
      System.out.println(e.getMessage());
  }
%>