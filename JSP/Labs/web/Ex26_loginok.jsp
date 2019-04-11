<%@ page import="kr.or.bit.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
  /*
  int empno = Integer.parseInt(request.getParameter("txtempno"));
  String ename = (String) request.getParameter("txtename");

  Emp emp = new Emp();
  emp.setEmpno(empno);
  emp.setEname(ename);

  session.setAttribute("empobj", emp);
  // a.jsp, b.jsp에서도 사용 가능
  */
%>
<%--<jsp:useBean id="emp" class="kr.or.bit.Emp" scope="session">--%>
<%--  <jsp:setProperty name="emp" property="empno" param="txtempno"></jsp:setProperty>--%>
<%--  <jsp:setProperty name="emp" property="ename" param="txtename"></jsp:setProperty>--%>
<%--</jsp:useBean>--%>

<%-- 2단계 실습 코드 --%>
<jsp:useBean id="emp" class="kr.or.bit.Emp" scope="session"></jsp:useBean>
<jsp:setProperty name="emp" property="*" />



<html>
<head>
  <title>Title</title>
</head>
<body>
 사번 : <jsp:getProperty name="emp" property="empno"/> <br>
 이름 : <jsp:getProperty name="emp" property="ename"/>
</body>
</html>
