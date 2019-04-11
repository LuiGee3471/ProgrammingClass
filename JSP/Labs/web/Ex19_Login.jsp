<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%
    /*
    쿠키값이 존재하면 UID input 태크 value 속성에 그 값을 출력
    쿠키값을 read해서 쿠키 변수명이 UID라면 ... 그 값을 UID에
    */

    String id = "";
    String cookieName = "saveId";
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        if (c.getName().equals(cookieName)) {
            id = c.getValue();
        }
    }
  %>
</head>
<body>
  <form action="Ex19_loginok.jsp" method="get">
    ID: <input type="text" name="UID" id="UID"><br>
    PWD: <input type="text" name="PWD"><br>
    <hr>
    ID값 유지하기<input type="checkbox" name="chk">
    <hr>
    <input type="submit" value="로그인">
    <input type="reset" value="취소">
  </form>
  <script>
    window.onload = function() {
      var data = "<%=id%>"
      console.log(data);
      document.getElementById("UID").value = data;
    }
  </script>
</body>
</html>
