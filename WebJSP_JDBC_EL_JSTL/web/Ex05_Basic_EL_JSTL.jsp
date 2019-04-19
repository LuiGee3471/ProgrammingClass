<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
JSTL 사용
<c:set> : 변수 생성, 값을 저장
<c:remove> : 변수 삭제
<c:if test="조건식"> : 조건문
<c:choose> : 여러 가지 조건에 따라 처리 가능(if보다 활용도가 높음)
<c:forEach> : 반복문(개선된 for문과 유사)
<c:forTokens> : 토큰값(split, for문과 결합)
<c:out> : JSTL의 출력 구문(이거보다 EL의 활용도가 더 높음)
<c:catch> : 예외 처리
--%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>EL parameter 받기</h3>
${param.id} - ${param.pwd}<br>

<h3>EL & JSTL 혼합(의도 : scope 강제</h3>
<c:set var="userid" value="${param.id}" />
<c:set var="userpwd" value="${param.pwd}" />

<h3>변수 사용</h3>
id: ${userid}<br>
pwd : ${userpwd}<br>

<%--JSTL IF 문--%>
<c:if test="${empty userpwd}">
  <h3>empty userpwd</h3>
</c:if>

<hr>
<c:if test="${!empty userpwd}">
  <h3>not empty userpwd</h3>
  <c:if test="${userpwd == '1004'}">
    <h3>Welcome Admin page</h3>
  </c:if>
</c:if>
</body>
</html>
