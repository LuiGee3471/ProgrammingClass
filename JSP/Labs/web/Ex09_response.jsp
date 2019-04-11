<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2019-04-10
  Time: 오전 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response 객체 (응답 객체)</title>
</head>
<body>
<%--
Client(웹 브라우저) -> Server
request : 요청

Server -> Client
response : 응답

javax (Tomcat)
: request, response 객체 제공

1. 표현식 (출력이 목적) <%=%>
2. 페이지 이동 처리(sendRedirect)

response.sendRedirect()... (서버쪽 코드)
JavaScript에서 똑같은 원리 : location.href="Ex01_Basic.jsp";
>>> 둘 다 페이지를 서버에게 재요청
--%>
1. 일반적인 사용(=출력) : <%=100 + 200 + 300%><br>
2. sendRedirect() : response 객체의 함수 -> 클라이언트가 서버에게 페이지를 재요청<br>
<%
    response.sendRedirect("Ex01_Basic.jsp");
%>
<%--
response.sendRedirect("Ex01_Basic.jsp"); 코드가 클라이언트 브라우저가 해석할 수 있는 형태로 변환
=> <script>location.href = "Ex01_Basic.jsp"</script>
--%>
</body>
</html>
