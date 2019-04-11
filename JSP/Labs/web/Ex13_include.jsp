<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2019-04-10
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>일반 컨텐츠(자기소개)</title>
  <style>
    table, tr, td {
      border: 2px solid black;
      border-collapse: collapse;
    }

    table {
      width: 700px;
    }
  </style>
</head>
<body>
<%--원칙 : 레이아웃은 div나 semantic 태그로 만든다--%>
<table>
  <tr>
    <td colspan="2">
      <jsp:include page="commonmodule/Top.jsp"></jsp:include>
    </td>
  </tr>
  <tr>
    <td style="width: 200px;">
      <jsp:include page="commonmodule/Left.jsp"></jsp:include>
    </td>
    <td style="width: 500px;">
      여기 영역은 실제 자기소개 내용
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <jsp:include page="commonmodule/Bottom.jsp"></jsp:include>
    </td>
  </tr>
</table>
</body>
</html>
