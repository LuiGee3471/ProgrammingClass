<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2019-04-09
  Time: 오전 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    // 1. request(클라이언트가 입력한 값을 얻어올 수 있다)
    // input > text, password, radio, textarea, select
    // 넘어오는 값이 : 단일값, 다중값
    // input type="text" name="userId" >> ?userId=kglim

    String userId = request.getParameter("userId");
    String userPwd = request.getParameter("pwd");

    // 2. 다중값
    // input > checkbox, (name 동일)
    // select multiple
    String[] hobbies = request.getParameterValues("hobby");

    Enumeration<String> e  = request.getParameterNames();
    String name = "";
    while (e.hasMoreElements()) {
        name += "/" + e.nextElement();
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  출력1> <%= userId%><br>
  출력2> <%= userPwd%><br>
  <%
      for (String str : hobbies) {
  %>
          취미: <%=str%><br>
  <%
      }
  %>
  request.getParameterNames() :  <%=name%>
</body>
</html>
