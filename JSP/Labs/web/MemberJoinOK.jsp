<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String userId = request.getParameter("userId");
    String userName = request.getParameter("userName");
    String userPass = request.getParameter("userPass");
    String userPassCheck = request.getParameter("userPassCheck");
    String gender = request.getParameter("gender").equals("male") ? "남자" : "여자";
    String userEmail = request.getParameter("userEmail");
    String userSsn1 = request.getParameter("userSsn1");
    String userSsn2 = request.getParameter("userSsn2");
    String userZipCode = request.getParameter("userZipCode");
    String userAddr1 = request.getParameter("userAddr1");
    String userAddr2 = request.getParameter("userAddr2");
    String userPhone = request.getParameter("userPhone");
    String[] hobbies = request.getParameterValues("hobby");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  이름 : <%=userName%><br>
  아이디 : <%=userId%><br>
  비밀번호 : <%=userPass%><br>
  성별 : <%=gender%><br>
  이메일 : <%=userEmail%><br>
  주민번호 : <%=userSsn1%>-<%=userSsn2%><br>
  주소 : <%=userZipCode%> <%=userAddr1%> <%=userAddr2%><br>
  전화번호 : <%=userPhone%><br>
  생년월일 : <%=year%>년 <%=month%>월 <%=day%>일<br>
  취미:<br>
<%
    for (String str : hobbies) {
%>
    &nbsp;&nbsp;<%=str%><br>
<%
    }
%>
</body>
</html>
