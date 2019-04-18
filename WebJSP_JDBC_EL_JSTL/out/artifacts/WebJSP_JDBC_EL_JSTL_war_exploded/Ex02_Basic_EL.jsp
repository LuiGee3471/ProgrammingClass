<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // EL: 서버 자원의 출력이 목적
  // EL로 모든 java 코드를 표현하는 스크립틀릿이 생력되는 것은 아니다

  // 예를 드면
  Date today = new Date();
  request.setAttribute("day", today);
  session.setAttribute("day2", today);

%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>EL 목적 : 출력</h3>
<%= request.getAttribute("day") %><br>
EL: ${day} <br>
<%-- 좋은 방식은 아니다 : 습관적으로 출처를 밝힐 것 --%>
습관 : ${requestScope.day}<br>
session EL : ${sessionScope.day2}<br>
</body>
</html>
