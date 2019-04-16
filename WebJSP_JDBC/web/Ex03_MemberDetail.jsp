<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	회원 상세 페이지
	1. 권한 검사
	2. id 값 받기(where id=hong) (id컬럼 PK) >> request.getParameter("id");
	3. select id, pwd, name, age, gender, email from koreamember where id=?
	4. id primary key (데이터 한 건)
	 */
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
				<table style="width: 400px; height: 100px; margin: 0 auto;">
				<%
					String id = request.getParameter("id");
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					try {
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bituser", "1004");
						String sql = "select * from koreamember where id = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, id);
						rs = pstmt.executeQuery();

						while(rs.next()) {
				%>
					<tr>
						<td style="width: 100px;">아이디</td>
						<td style="width: 100px;"><%=rs.getString(1)%></td>
					</tr>
					<tr>
						<td style="width: 100px;">비밀번호</td>
						<td style="width: 100px;"><%=rs.getString(2)%></td>
					</tr>
					<tr>
						<td style="width: 100px;">이름</td>
						<td style="width: 100px;"><%=rs.getString(3)%></td>
					</tr>
					<tr>
						<td style="width: 100px;">나이</td>
						<td style="width: 100px;"><%=rs.getInt(4)%></td>
					</tr>
					<tr>
						<td style="width: 100px;">성별</td>
						<td style="width: 100px;"><%=rs.getString(5).trim().equals("M") ? "남" : "여"%></td>
					</tr>
					<tr>
						<td style="width: 100px;">이메일</td>
						<td style="width: 100px;"><%=rs.getString(6)%></td>
					</tr>

				<%
				  	}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {

					}
				%>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>