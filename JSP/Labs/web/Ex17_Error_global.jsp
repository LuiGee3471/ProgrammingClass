<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Error_global</title>
</head>
<body>
<%--
  404 : File not Found
  500 : 서버쪽 코드 문제(Exception)

  500번 예외가 발생하면
--%>
<%
  String data = request.getParameter("name").toLowerCase();
%>
전달받은 내용 : <%=data%>
</body>
</html>
