<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Application & Session</title>
</head>
<body>
<%--
TODAY's POINT
서버 자원(WAS) : memory

application
[전역객체] 변수 (접속하는 모든 사용자에게 공유)

session
[개인 : 접속한 브라우저 : 고유값] : 접속한 사용자마다 고유하게 부여되는 변수

1. application.setAttribute("count", 0)
- 사이트 전체 접속자 수 등
- application >> count + 1...
- 사이트에 접속하는 모든 사용자는 count 변수에 접근 가능

2. session
- session.setAttribute("userid", "hong");
- 접속한 사용자(브라우저)마다 고유하게 부여되는 변수

A라는 사용자 웹 서버 접속
=> 서버가 session 객체 생성
=> 식별값 부여
=> 접속 브라우저에 (response)

B라는 사용자 웹 서버 접속
=> 서버가 session 객체 생성
=> 식별값 부여 => 접속 브라우저에 response

application 변수는 모든 사용자에게 같은 값
session 변수는 접속하는 사용자마다 다른 값
--%>
<h3>세션 정보</h3>
웹 서버가 부여한 고유 값 : <%=session.getId()%>
<hr>
<%
  String userid = request.getParameter("userid");
  session.setAttribute("id", userid);
  // session 변수의 범위 : 애플리케이션의 모든 페이지
%>
<h3>세션 변수값</h3>
당신의 ID는 <%=session.getAttribute("id")%>
</body>
</html>
