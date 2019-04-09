<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page buffer="8kb" autoFlush="true" %>
<%--
페이지에 어떠한 설정도 없으면
default: buffer = 8kb, autoFlush = true

1. 기본적으로 buffer가 다 차면 자동 flush
2. 페이지에 더 이상 실행할 것이 없으면 자동 flush

--%>
<%

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
      for (int i = 0; i < 10; i++) {
  %>
           출력값: <%=i%><br>
  <%
      }
  %>
</body>
</html>
