<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<jsp:include page="common/Head.jsp" />
<title>Main</title>
    <style>
		#page-content-wrapper {
			background-image: url("https://images.unsplash.com/photo-1519681393784-d120267933ba?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80");
			background-size : 100% 100%;
		}
		</style>
  </head>
  <body>
    <div class="d-flex" id="wrapper">
      <div class="bg-light border-right" id="sidebar-wrapper">
        <jsp:include page="common/Left.jsp" />
      </div>
      <div id="page-content-wrapper">
        <jsp:include page="common/Top.jsp" />

        <div class="container">
				&nbsp;
        </div>
      </div>
    </div>
<jsp:include page="common/Bottom.jsp" />
