<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String memberid = (String) session.getAttribute("memberid");
  boolean loginstate = (memberid == null) ? false : true;
%>
<html>
<head>
  <title>회원 전용 페이지</title>
</head>
<body>
<%
  if (loginstate) {
      out.print(memberid + "님 로그인 상태입니다<br>");
      out.print("당신은 이 페이지를 볼 수 있습니다<br>");
      out.print("<a href='Ex22_Session_logout.jsp'>로그아웃</a>");
  } else {
      out.print("<script>alert('넌 누구냐')</script>");
      out.print("<script>location.href='Ex22_Session_login.jsp'</script>");
  }
%>
</body>
</html>
