<%@ page import="kr.or.bit.Emp" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2019-04-11
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  Emp e = (Emp) session.getAttribute("empobj");
  // String who = (String) request.getAttribute("who"); 불가능
%>
<%=e.toString()%>
</body>
</html>
