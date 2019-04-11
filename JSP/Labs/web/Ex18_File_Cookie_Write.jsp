<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>쿠키값 쓰기</title>
</head>
<body>
<%--
1. 메모리 쿠키 (브라우저 쿠키)
: 클라이언트가 강제로 지우지 않는 한 또는
  브라우저를 닫기 전까지는 쿠키 값을 유지

2. 파일 쿠키 (소멸 시간)
: 클라이언트가 강제로 지우지 않는 한 정해진 시간까지 유지
setMaxAge(60) => 60초
30일 => (30 * 24 * 60 * 60) 일 * 시 * 분 * 초

--%>

<%
  Cookie co = new Cookie("bit", "kim");
  co.setMaxAge(30 * 24 * 60 * 60); // 30일
  response.addCookie(co);
%>
</body>
</html>
