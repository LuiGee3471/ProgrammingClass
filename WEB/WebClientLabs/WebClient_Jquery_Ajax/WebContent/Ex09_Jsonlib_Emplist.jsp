<%@page import="kr.or.bit.Emp"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  Class.forName("oracle.jdbc.OracleDriver");
  Connection conn = null;
  Statement stmt = null;
  ResultSet rs = null;
  
  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bituser", "1004");
  
  stmt = conn.createStatement();
  String sql = "select empno, ename, sal, job from emp";
  
  rs = stmt.executeQuery(sql);
  // 여러 건의 데이터를 객체로 담고 싶다 (collection)
  // DTO 클래스 emp
  // Emp emp = new Emp(); 데이터 한 건
  List<Emp> list = new ArrayList<Emp>();
  
  while (rs.next()) {
	  Emp emp = new Emp();
	  emp.setEmpno(rs.getInt("empno"));
	  emp.setEname(rs.getString("ename"));
	  emp.setSal(rs.getInt("sal"));
	  emp.setJob(rs.getString("job"));
	  list.add(emp);
  }
  
  // Java에서 Jsonlib를 사용하면
  JSONArray jsonlist = JSONArray.fromObject(list);
%>
<%=jsonlist%>
