<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Session 객체</title>
</head>
<body>
<%--
session : 웹 브라우저(접속한 사용자, client)마다 부여되는 고유한 객체

session 값 : 웹 서버가 접속한 클라이언트(브라우저)에 부여하는 고유한 식별값
A라는 사용자가 웹 서버에 접속(session 객체 생성) > id 값을 생성 > Client에 response
고유한 식별값을 통해 클라이언트와 서버가 동기화(연결)

서버에서 생성한 session id : 72308370AD05021F0D6F7249B2B4D628
브라우저에 있는 session id : 72308370AD05021F0D6F7249B2B4D628

session 객체
- 처음 접속한 시간
- 마지막 접속한 시간
--%>
<%
  Date time = new Date();
  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<h3>세션 정보</h3>
<%=session.getId()%>
<hr>
<%
  time.setTime(session.getCreationTime());
%>
session 생성 시간 : <%=formatter.format(time)%>
<hr>
<%
  time.setTime(session.getLastAccessedTime());
%>
session 마지막 접속 시간 : <%=formatter.format(time)%>
</body>
</html>
