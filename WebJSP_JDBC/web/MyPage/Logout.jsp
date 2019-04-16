<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="common/head.jsp" />
<%
	session.invalidate(); //session 객체 삭제
	out.print("<script>location.href='Login.jsp'</script>");
%>
</head>
<body>
<jsp:include page="common/header.jsp" />
<div class="center-area">
  <jsp:include page="common/aside.jsp" />
  <main>
    <%--여기에 내용을 넣으세요--%>
  </main>
</div>
<jsp:include page="common/footer.jsp" />

