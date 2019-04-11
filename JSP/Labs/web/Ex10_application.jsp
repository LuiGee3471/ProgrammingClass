<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int sum = 0; // 유효범위 : 페이지(Ex10_application.jsp)
    /*
    WAS (컨테이너) : 여러 개의 웹 애플리케이션을 서비스할 수 있다
    우리 WAS : WebJSP 웹 애플리케이션을 가지고 있다
    WebJSP(가상 디렉토리) -> 실제 경로 : WebContent 폴더(default 폴더)
    >> context root -> WebContent

    WebContent 안에 있는 모든 페이지가 공유할 수 있는 자원은 없을까
    웹 애플리케이션은 하나의 설정 파일을 가지고 있다(웹 사이트 설정 정보)
    web.xml (웹 애플리케이션 전반에 관련된 환경 설정 파일)
    >> 사이트를 실행하면 >> web.xml 가장 먼저 실행
    WebContent >> WEB-INF >> web.xml
    ** WEB-INF : 보안 폴더 >> 클라이언트가 접속할 수 없는 경로
    ** 찾아가도 404 Error
    ** 실제 프로젝트 >> WEB-INF >> views >> member >> JSP 관리
    */
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String param = application.getInitParameter("email");
    out.print("<h3>" + param + "</h3>");

    String param2 = application.getInitParameter("Filepath");
    out.print("<h3>" + param2 + "</h3>");
%>
</body>
</html>
