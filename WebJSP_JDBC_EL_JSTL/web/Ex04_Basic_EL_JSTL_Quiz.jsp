<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  String id = request.getParameter("ID");
  if (id.equals("hong")) {
%>
<%=id%><img src="images/1.jpg" alt="이미지" style="width: 100px; height: 100px;"/>
<%
  }
%>
<%--
param: 요청 파라미터의 값을 String으로, request.getParameter()의 결과와 동일
paramValue : 요청 파라미터의 값을 String[]으로, request,getParameterValues()의 결과와 동일
--%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h3>EL과 JSTL</h3>
<c:if test="${param.ID == 'hong'}">
  ${param.ID}<img src="images/1.jpg" alt="이미지" style="width: 100px; height: 100px;"/><br>
</c:if>
<%--
문제 : Client에서 ?age=100 값을 받아서 age값이 20보다 큰 값이면
그 값을 출력하는 EL & JSTL 구문을 작성하세요
--%>
<c:if test="${param.age > 20}" var="result">
  <h2>Age (if age > 20)</h2>${param.age}
</c:if>
<br>
<p>조건 결과 : ${result}</p>
</body>
</html>
