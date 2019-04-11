<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>쿠키값 읽기</title>
</head>
<body>
<%
  Cookie[] cs = request.getCookies();
  if (cs != null || cs.length > 0) {
      for (Cookie c : cs) {
          out.print(c.getName() + "<br>");
          out.print(c.getValue() + "<br>");
          out.print(c.getMaxAge() + "<br>");
      }
  }
%>
</body>
</html>
