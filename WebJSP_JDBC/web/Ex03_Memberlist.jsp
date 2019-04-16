<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	이 페이지는 admin만 접근 가능...
	1. 회원 목록 출력
	2. 관리자만 접근 가능(userid == admin)
	3. 로그인한 일반 사용자가 주소값을 외워서 접근 불가하게 >> 로그인 페이지 이동
	4. 고려사항 (권한처리 코드가 여러 페이지에 사용된다면 별도의 페이지로 구성)
	 */

	// 권한 처리
	if (session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin")) {
		// 강제로 다른 페이지로 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<%--
				회원 목록 출력하기
				관리자인 경우(회원 데이터 볼 수 있다)
				목록 출력 >> 상세 정보 별도로 구성
				목록 : select id, ip from koreamember;

				회원 데이터를 HTML과 결합해서 출력 생성
				--%>
				<%
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					try {
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
						String sql = "select id, ip from koreamember";
						pstmt = conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
				%>
					  <table style="width: 400px; height: 100px; margin: 0 auto;">
							<tr>
								<th colspan="4">회원 리스트</th>
							</tr>
							<%
								while (rs.next()) {
							%>
							    <tr>
										<td width="150px">
											<a href="Ex03_MemberDetail.jsp?id=<%=rs.getString("id")%>">
											  <%=rs.getString("id")%>
											</a>
										</td>
										<td width="150px"><%=rs.getString("ip")%></td>
										<td>
											<a href="Ex03_MemberDelete.jsp?id=<%=rs.getString("id")%>">삭제</a>
										</td>
										<td>
											<a href="Ex03_MemberEdit.jsp?id=<%=rs.getString("id")%>">수정</a>
										</td>
									</tr>
							<%
								}
							%>
						</table>
          <hr>
          <form action="Ex03_MemberSearch.jsp" method="post">
            회원명 : <input type="text" name="search">
            <input type="submit" value="이름 검색하기">
          </form>
				<%
					} catch (Exception e) {

					} finally {

					}
				%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>