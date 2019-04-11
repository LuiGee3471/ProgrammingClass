<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
out 객체 : 서버쪽 구현이 편하다
단점 : 클라이언트 코드 구현이 어렵다
--%>
<html>
<head>
    <title>Tomcat(WAS) 내장 객체(out)</title>
</head>
<body>
<%
    boolean b = true;
    if (10 > 5) {
%>
        IF(true): <span style="color: red; "><%=b%></span>
<%
    } else {
        b = false;
%>
        IF(false) : <span style="color: blue;"><%=b%></span>
<%
    }
%>
<h3>out 객체 (서버 코드 작업이 편하다)</h3>
<%
    boolean b2 = true;
    if (10 < 5) {
        out.print("IF(true): <span style='color: red;'>" + b2 + "</span>");
    } else {
        out.print("IF(false) : <span style='color: blue;'>" + b2 + "</span>");
    }
%>
</body>
</html>
