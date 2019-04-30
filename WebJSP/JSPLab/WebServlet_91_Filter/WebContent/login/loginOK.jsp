<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");
  // 한글 처리
  // 데이터 받기 전에
  // 한글 처리가 필요한 모든 페이지 상단에 위 코드 필요
  
  // 관심사(주 관심 / 보조 관심(공통 관심))
  // 주 관심: 데이터 받아서 클라이언트에게 다시 보여주기
  // 보조 관심: 공통 사항(한글 처리 등)
  
  // 분리 (보조 관심: 공통 사항) >> Filter 객체
  String kor = request.getParameter("kor");
  String eng = request.getParameter("eng");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login OK</title>
</head>
<body>
  한글명: <%=kor %><br>
  영문명: <%=eng %>
</body>
</html>