<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  session.invalidate();
  out.print("<script>location.href='Ex22_Session_login.jsp'</script>");
%>
