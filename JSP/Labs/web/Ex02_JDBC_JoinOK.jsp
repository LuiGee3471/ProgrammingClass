<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

  response.setCharacterEncoding("UTF-8");

  String id = request.getParameter("id");
  String pass = request.getParameter("pwd");
  String name = request.getParameter("name");
  int age = Integer.parseInt(request.getParameter("age"));
  String gender = request.getParameter("gender");
  String email = request.getParameter("email");

  out.print(id + "/" + pass + "/" + name + "/" + age + "/" + gender + "/" + email);
%>

