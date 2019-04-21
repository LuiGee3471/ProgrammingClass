<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8"
  <title>JSTL 연습하기(제어문)</title>
</head>
<body>
<h3>JSTL for문</h3>
<%--
int sum = 0;
for (int i = 1; i <= 10; i++) {sum+=i;}
--%>
<c:forEach var="i" begin="1" end="10">
  <c:set var="sum" value="${sum + i}"/>
</c:forEach>
sum : ${sum}<br>

<h3>5단 출력하기</h3>
<c:forEach var="i" begin="1" end="9">
  <li>5 * ${i} = ${5 * i}</li>
</c:forEach>

<h3>EL & JSTL 사용해서 (디자인 마음대로) 구구단 출력</h3>
<table style="border:1px solid black;">
  <thead>
  <th colspan="10">구구단</th>
  </thead>
  <c:forEach var="i" begin="2" end="9">
    <tr>
      <td>${i}단</td>
      <c:forEach var="j" begin="1" end="9">
        <c:choose>
          <c:when test="${i * j < 10}">
            <td>&nbsp;${(i * j)}</td>
          </c:when>
          <c:otherwise>
            <td>${i * j}</td>
          </c:otherwise>
        </c:choose>
      </c:forEach>
    </tr>
  </c:forEach>
</table>
<h3>JSTL forEach 객체 출력하기</h3>

<%--  객체 만들거나 주소값 처리는 JAVA로 --%>
<%-- 객체를 출력 --%>
<%
   int[] arr = new int[]{10, 20, 30, 40, 50};
   for (int i : arr) {
       out.print("출력값 : " + i + "<br>");
   }
%>
<h3>***** EL은 Java 객체에 직접 접근 불가능 </h3>
<p>request, session, application에 담거나 JSTL set 변수를 통해서 접근</p>
arr 배열 객체 직접 접근 불가 : ${arr} <br>
<c:set var="intarr" value="<%=arr%>" />
EL이 c:set 접근 가능 : ${intarr}<br>
<hr>
<h3>***********forEach 개선된 for문 형태로 사용 가능 ***********</h3>
<c:forEach var="i" items="${intarr}">
  배열값 : ${i}<br>
</c:forEach>

<h3>***********forEach items 사용을 위해 (c:set)등이 꼭 필요한가 ***********</h3>
<p>c:forEach var="i" items="arr"</p>
<c:forEach var="i" items="<%=arr%>">
  배열값 : ${i}<br>
</c:forEach>
<hr>
<c:forEach var="i" items="<%=new int[]{1,2,3,4,5}%>">
  배열값: ${i}<br>
</c:forEach>
<hr>
<c:forEach var="i" items="1,2,3,456,57,8">
  배열값: ${i}<br>
</c:forEach>

<h3>forEach 활용하기 2탄</h3>
<c:forEach var="i" items="${intarr}" varStatus="status">
  index : ${status.index}&nbsp;&nbsp;&nbsp;
  count : ${status.count}&nbsp;&nbsp;&nbsp;
  value : ${i}<br>
</c:forEach>
</body>
</html>
