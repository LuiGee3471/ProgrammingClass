<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ex = request.getParameter("Ex01");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (ex.equals("1")) {
        response.sendRedirect("Ex01_Basic.jsp");
    } else {
        response.sendRedirect("Ex02_Register.html");
    }
%>
</body>
</html>
