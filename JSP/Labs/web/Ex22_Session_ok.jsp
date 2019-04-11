<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
  String uid = request.getParameter("uid");
  String pwd = request.getParameter("pwd");

//  System.out.println(uid + pwd);
  // 로직 처리
  // DB 연결 >> select >> 회원 테이블 >> ID, PWD 존재...
  boolean success = (uid.equals(pwd)) ? true : false;
  // 로그인 성공
  // session 변수에 id 값 담기
  // session 변수는 모든 JSP 페이지에서 공유 가능
  if (success) {
    session.setAttribute("memberid", uid);
  }

%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  if (success) {
      out.print("<strong>로그인 성공</strong><br>");
      String user = (String) session.getAttribute("memberid");
      out.print(user + "님 로그인되어 있습니다<br>");
      out.print("<a href='Ex22_Session_member.jsp'>회원 전용</a>");
  } else {
    out.print("<script>\n" +
            "  alert(\"다시 로그인해주세요\");\n" +
            "  window.history.go(-1);\n" +
            "</script>");
  }
%>
</body>
</html>
