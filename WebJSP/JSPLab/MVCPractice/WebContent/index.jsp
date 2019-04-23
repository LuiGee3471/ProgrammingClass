<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:set var="list" value="${requestScope.empList}" />
<c:set var="result" value="${requestScope.result}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 관리</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
  <header>
    <h1>사원 관리 프로그램</h1>
  </header>
  <div id="container">
    <table id="empTable">
      <thead>
        <tr>
          <th id="empno">사번</th>
          <th id="ename">이름</th>
          <th id="job">직종</th>
          <th id="mgr">관리자 사번</th>
          <th id="hiredate">고용일자</th>
          <th id="sal">연봉</th>
          <th id="comm">커미션</th>
          <th id="dname">부서명</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="emp" items="${list}">
          <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td>${emp.mgr}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td>${emp.dname}</td>
          </tr>
        </c:forEach>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="8">${result}</td>
        </tr>
      </tfoot>
    </table>
    <form action="<%=request.getContextPath()%>/EC" method="post">
      <input type="text" id="search" name="search" /> 
      <input type="submit" value="검색하기" />
    </form>
  </div>
  <footer>
    <h3>회사.co.kr</h3>
  </footer>
</body>
</html>