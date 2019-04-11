<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error/commonError.jsp" %>
<!doctype html>
<html>
<head>
  <title>에러 처리</title>
</head>
<body>
<%--
1. 특정 페이지만 지정 : <%@ page errorPage=""%> => 모든 페이지 상단에 기입 필요
--%>
<%
  String data = request.getParameter("name").toLowerCase();
%>
전달받은 내용 : <%=data%>
</body>
</html>
