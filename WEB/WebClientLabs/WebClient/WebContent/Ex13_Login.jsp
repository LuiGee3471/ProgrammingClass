<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    //JAVA 코드 구현
    String userId = request.getParameter("userId");
    String userPwd = request.getParameter("userPwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <img src="images/3.jpg"></img>
  <h3>당신이 입력한 데이터는</h3>
  ID : <%= userId %><br>
  PWD : <%= userPwd %><br>
</body>
</html>