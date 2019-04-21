<%@ page import="kr.or.bit.Emp" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  Emp e = new Emp();
  e.setEmpno(2000);
  e.setEname("홍길동");

  Map<String, String> hp = new HashMap<>();
  hp.put("data", "1004");
%>
<html>
<head>
  <title>Title</title>
</head>
<body>
기존 방식 : <%= e %><br>
기존 방식 : <%= e.getEmpno()%><br>
기존 방식 : <%= e.getEname()%><br>

<h3>EL(출력)</h3>
Java 객체 출력하기 (EL은 객체에 직접 접근 불가능): ${e}<br>
Java 객체의 속성 또한 출력 불가능: ${e.getEmpno()}<br>

1. JSTL(core) 변수 생성, 제어문<br>
<c:set var="m" value="<%=e%>" />
JSTL 변수 m을 만들고 서버쪽 객체 주소값을 설정: ${m}
<hr>
EL 출력: JSTL 변수값을 출력: ${m}<br>
EL 출력: JSTL 변수(실제로는 이렇게 안씀) : ${m.getEmpno()}<br>
EL 출력: 변수를 통해서 getter 함수 호출 : ${m.empno}<br>
EL 출력: 변수를 통해서 getter 함수 호출 : ${m.ename}<br>

<h3>EL & JSTL 사용하기</h3>
****** EL 통해서 객체에 직접 접근 불가 ********<br>
****** e 객체를 : request, session을 담으면 EL 접근 가능 ******<br>

JSTL 변수의 (value) 값으로 EL 표현식을 사용할 수 있다<br>
<c:set var="username" value="${m.ename}" />
변수가 담긴 값을 출력: ${username}<br>

<hr>
<h3>JSTL 변수 만들고 Scope 정의하기</h3>
<c:set var="job" value="농구선수" scope="request" />
당신의 직업은 : ${job}<br>
[include] or [forward] 된 페이지에서 JSTL 변수값을 공유할 수 있다<br>

변수 삭제하기<br>
<c:set var="job2" value="야구선수" scope="request" />
${job2}<br>
<c:remove var="jobs" />
job2 변수 삭제: ${job2}<br />

<c:set var="vhp" value="<%=hp%>" />
hp객체 : ${vhp}<br>
hp객체 : ${vhp.data}<br>
<%--
hp.put("color", "red");
--%>
<c:set target="${vhp}" property="color" value="red" />
hp객체: ${vhp}<br>
</body>
</html>
