<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><html><head>  <title>JSTL 함수</title></head><body><c:set var="str" value="oracle" />변수값 출력: ${str}<br>대문자: ${fn:toUpperCase(str)}<br>문자열 길이: ${fn:length(str)}<br>치환: ${fn:replace(str, "a", "AAA")}<br></body></html>