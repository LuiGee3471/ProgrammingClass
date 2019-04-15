<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%

  /*
  Ex02_JDBC_JoinForm.jsp에서
  1. 한글 처리
  2. parameter 받기, 확인하기
  3. 로직 처리 : 회원 가입 처리 >> 데이터 받고 >> DB에 연결 >> Insert >> 성공 유무에 따라 결과 전달
  4. 회원가입 성공 : 페이지 이동 > 로그인 페이지로 이동 (Ex02_JDBC_Login.jsp)
     이동 : response.sendRedirect(url), JS : location.href
     >> 클라이언트가 페이지를 재요청

     회원가입 실패 : 경고창(가입 실패 원인) > 회원가입 이동
     서버 코드 작성 : <script> alert .... ; location.href = ""</script>

     클라이언트의 정보를 request 객체로 받음
     id, pwd, name, age, gender, email, ip(request.getRemoteAddr())
   */

  request.setCharacterEncoding("UTF-8");

  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");
  String name = request.getParameter("mname");
  int age = Integer.parseInt(request.getParameter("age"));
  String gender = request.getParameter("gender");
  String email = request.getParameter("email");

  out.print(id + pwd + name + age + gender + email);

  Class.forName("oracle.jdbc.OracleDriver");
  Connection conn = null;
  PreparedStatement pstmt = null;

  try {
      conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
      String sql = "insert into koreamember(id, pwd, name, age, gender, email, ip) values (?, ?, ?, ?, ?, ?, ?)";
      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, id);
      pstmt.setString(2, pwd);
      pstmt.setString(3, name);
      pstmt.setInt(4, age);
      pstmt.setString(5, gender);
      pstmt.setString(6, email);
      pstmt.setString(7, request.getRemoteAddr());

      int result = pstmt.executeUpdate();
      System.out.println(result);
      if (result != 0) {
          out.print("<script>");
          out.print("location.href='Ex02_JDBC_Login.jsp';");
          out.print("</script>");
      } else {
        out.print("<script>");
        out.print("alert('중복'); location.href='Ex02_JDBC_JoinForm.jsp';");
        out.print("</script>");
      }
  } catch (Exception e) {
      System.out.println(e.getMessage());
    out.print("<script>");
    out.print("alert('중복'); location.href='Ex02_JDBC_JoinForm.jsp';");
    out.print("</script>");
  } finally {
      System.out.println("Finally");
      if (pstmt != null) {
          try {
              pstmt.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }

      if (conn != null) {
          try {
              conn.close();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }


%>