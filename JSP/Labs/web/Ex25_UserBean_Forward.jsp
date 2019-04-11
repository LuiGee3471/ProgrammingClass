<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="empbean" class="kr.or.bit.Emp" scope="request"></jsp:useBean>
<html>
<head>
  <title>Title</title>
</head>
<body>
  객체의 주소를 받는다
<%
  out.print(empbean.getEmpno() + "<br>");
  out.print(empbean.getEname() + "<br>");
%>
</body>
</html>
