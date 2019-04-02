<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    //JAVA 코드 구현
    String userId = request.getParameter("txtuserid");
    String userPwd = request.getParameter("txtpwd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>당신이 입력한 데이터는</h3>
  ID : <%= userId %><br>
  PWD : <%= userPwd %><br>
</body>
</html>