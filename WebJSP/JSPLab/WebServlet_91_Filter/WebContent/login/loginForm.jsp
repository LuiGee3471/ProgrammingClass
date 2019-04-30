<%@page import="kr.or.bit.filter.EncodingFilter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
  <form action="loginOK.jsp" method="POST">
     한글명: <input type="text" name="kor" value="한글명"><br>
     영문명: <input type="text" name="eng" value="KOREA"><br>
    <input type="submit" value="한글 전송">
  </form> 
</body>
</html>