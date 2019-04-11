<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%--
UID, PWD, Chk 여부
1. ID, PWD 같다면 로그인 성공
chk 체크 되었다면 쿠키 생성 ID 값을 쿠키에 담아서 유효시간은 24시간

2. chk 체크가 되어있지 않다면
   만들었던 쿠키 삭제 : setMaxAge(0);
   Cookie delco = new Cookie("UID", "");
   delco.setMaxAge(0);
   response.addCookie(delco);

3. ID, PWD 같지 않다면
response.sendRedirect(Ex19_Login.jsp);
--%>
<%
  String id = request.getParameter("UID");
  String pwd = request.getParameter("PWD");
  String chk = request.getParameter("chk");
  if (chk == null) {
    chk = "off";
  }

  if (!id.equals(pwd)) {
      response.sendRedirect("Ex19_Login.jsp");
  }

  out.print("로그인 성공!");

  if (chk.equals("on")) {
      Cookie cookie = new Cookie("saveId", id);
      cookie.setMaxAge(24 * 60 * 60);
      response.addCookie(cookie);
  } else {
      Cookie cookie = new Cookie("saveId", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
  }
%>


</body>
</html>
