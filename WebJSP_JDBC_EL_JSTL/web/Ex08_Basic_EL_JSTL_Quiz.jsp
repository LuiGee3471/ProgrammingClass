<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html><head>  <title>Title</title></head><body><%--EL & JSTL을 사용해서 값을 받아서 받은 값을 출력하세요받은 값이 없는 경우에는 Empty라는 문자열을 출력하세요chekcbox는 다중 선택이 가능hint) request.getParamterValues("subject"); >> 표현을 EL로EL:param 객체 (단일 값)paramvalues 객체 (다중 값)--%><c:choose>  <c:when test="${!empty paramValues.subject}">    당신의 선택은?    <ul>      <c:forEach var="subject" items="${paramValues.subject}" varStatus="status">        <li>${status.index} - ${subject} - ${status.count}</li>      </c:forEach>    </ul>  </c:when>  <c:otherwise>    선택을 하세요(Empty)<br>  </c:otherwise></c:choose><%  int year = Integer.parseInt(request.getParameter("year"));%>연도 : <input type="text" value="<%=year%>"><br><h3>select Tag</h3><select id="newYear" name="newYear" title="연도 선택">  <option>연도 선택</option>  <option value="2015" <c:if test="${param.year == 2015}">selected</c:if>>2015</option>  <option value="2016" <c:if test="${param.year == 2016}">selected</c:if>>2016</option>  <option value="2017" <c:if test="${param.year == 2017}">selected</c:if>>2017</option>  <option value="2018" <c:if test="${param.year == 2018}">selected</c:if>>2018</option>  <option value="2019" <c:if test="${param.year == 2019}">selected</c:if>>2019</option></select><h3>forEach?</h3><select id="newYear" name="newYear" title="연도 선택">  <option>연도 선택</option>  <c:forEach var="i" begin="0" end="4">    <option value="${2015 + i}" <c:if test="${param.year == 2015 + i}">selected</c:if>>${2015 + i}</option>  </c:forEach></select><hr><input type="checkbox" name="check" value="java" <c:if test="${param.choiceyn == 'y'}">checked</c:if>></body></html>