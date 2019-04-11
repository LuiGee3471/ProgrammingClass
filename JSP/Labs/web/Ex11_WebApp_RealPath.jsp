<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
StringBuffer url = request.getRequestURL();    // URL : 전체주소 (프로토콜 + IP + 포트 + 상세경로)
 String uri = request.getRequestURI();            // URI : 프로젝트 이하 경로 (CP + SP)
 String cp = request.getContextPath();           // CP : 프로젝트 명
 String sp = request.getServletPath();            // SP : 패키지 + 파일명

 System.out.println("URL : " + url);
 System.out.println("URI  : " + uri);
 System.out.println("CP   : " + cp);
 System.out.println("SP   : " + sp);


-----------------------------------------------------------------

 URL : http://localhost:8080/TestBoard/JSPBoard/created.jsp
 URI  : /TestBoard/JSPBoard/created.jsp
 CP   : /TestBoard
 SP   : /JSPBoard/created.jsp

-----------------------------------------------------------------

1. 웹 브라우저가 가지고 있는 경로 (가상 경로)
http://localhost:8080/TestBoard/JSPBoard/created.jsp

2. Ex11-WebApp_RealPath.jsp 파일의 실제 경로(물리적 경로)

3. 웹(가상 경로) -> 실 경로(물리적 경로) 반환해 주는 객체
request
apllication

활용 : 자료실 (파일 업로드)

/download/note.txt
request.getContextPath() : /WebJSP
contextPath : C:\FrontEndBackEnd\JSP\Labs\out\artifacts\Labs_war_exploded\WebJSP
realPath : C:\FrontEndBackEnd\JSP\Labs\out\artifacts\Labs_war_exploded\download\note.txt
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String resourcePath = "/download/note.txt";
    out.print(resourcePath + "<br>");

    String contextPath = application.getRealPath(request.getContextPath());
    String realPath = application.getRealPath(resourcePath);

    out.print("request.getContextPath() : " + request.getContextPath() + "<hr>");
    out.print("contextPath : " + contextPath + "<hr>");
    out.print("realPath : " + realPath);
%>
</body>
</html>
