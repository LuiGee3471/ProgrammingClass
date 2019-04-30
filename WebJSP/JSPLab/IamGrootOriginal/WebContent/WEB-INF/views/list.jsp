<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>사원 목록</title>
</head>
<body>
  <h1>사원 목록</h1>
  <form action="listSelect.do" method="POST">
    <select name="orderBy" id="orderSelect">
      <option value="empno">사원 번호</option>
      <option value="deptno">부서 번호</option>
    </select> 
    <input type="text" name="no" id="numberSelect" />
    <input type="submit" value="검색하기" />
  </form>
  <table>
    <thead>
      <th>사번</th>
      <th>이름</th>
      <th>직종</th>
      <th>관리자 사번</th>
      <th>입사일자</th>
      <th>연봉</th>
      <th>커미션</th>
      <th>부서번호</th>
    </thead>
    <tbody>
      <c:forEach var="emp" items="${requestScope.list}">
        <tr>
          <td>${emp.empno}</td>
          <td>${emp.ename}</td>
          <td>${emp.job}</td>
          <td>${emp.mgr}</td>
          <td>${emp.hiredate}</td>
          <td>${emp.sal}</td>
          <td>${emp.comm}</td>
          <td>${emp.deptno}</td>
          <td><a href="update.do?empno=${emp.empno}">수정</a></td>
          <td><a href="delete.do?empno=${emp.empno}">삭제</a></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
