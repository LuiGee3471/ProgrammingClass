<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/ok.do" method="POST">
    ID: <input type="text" name="id" placeholder="ID 입력"><br>
    PWD: <input type="text" name="pwd" placeholder="비밀번호 입력"><br>
    EMAIL: <input type="text" name="email" placeholder="이메일 입력"><br>
    <input type="submit" value="회원가입">
  </form>
</body>
</html>