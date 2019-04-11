<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cookie</title>
</head>
<body>
<%--
클라이언트(로컬 PC의 웹 브라우저) : 서버(웹서버, 톰캣, 메모리, 파일, DB)

정보(데이터 : 자료) 어디에 저장하고 보관할 것인가
고민 : 소멸 시점(일시적, 영속적), 보안(정보의 중요성)

Client(Local PC : 웹 브라우저)
1. Cookie (메모리 쿠키, 파일 쿠키(txt: 암호화)) 구별 방법 : 소멸 시간
2. Local Storage (브라우저의 메모리 저장소) : (key : value의 pair 형태)

>> 영속적으로 저장될 필요 없고 보안적으로 문제가 없는 데이터

Server(Web Server : Tomcat)
1. Server Memory : session 객체(접속한 사용자별로 하나씩) -> 임시
2. Server Memory : application 객체(접속한 모든 사용자가 공유하는 객체) -> 임시
3. Server File : 영속적
4. Database Server : 영속적, 보안 (돈)
--%>
<%
  Cookie myCookie = new Cookie("cname", "1007");
  response.addCookie(myCookie);
%>
서버 설정한 쿠키 이름 : <%=myCookie.getName()%> <br>
서버 설정한 값 : <%=myCookie.getValue()%> <br>
서버 설정한 쿠키 소멸정보(-1 : 소멸시간이 없다 => 브라우저는 소멸시간을 돌려주지 않는다) : <%=myCookie.getMaxAge()%> <br>
<hr>
<%--서버가 클라이언트에게 Response한 cookie 객체 얻어오기--%>
<%
  Cookie[] cs = request.getCookies();
  if (cs != null || cs.length > 0) {
      for (Cookie c : cs) {
          out.print(c.getName() + "<br>");
          out.print(c.getValue() + "<br>");
          out.print(c.getMaxAge() + "<br>");
      }
  }
%>
</body>
</html>
