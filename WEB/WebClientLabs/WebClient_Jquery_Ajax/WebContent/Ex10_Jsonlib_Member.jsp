<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="kr.or.bit.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
   Member member = new Member();
   JSONObject json = JSONObject.fromObject(member);
%>
<%=json%>
<%
   List<Member> memberlist = new ArrayList<>();
   memberlist.add(new Member("hong", "1004", "서울시 강남구", "0"));
   memberlist.add(new Member("kim", "1004", "서울시 양천구", "1"));
   memberlist.add(new Member("park", "1111", "서울시 성동구", "0"));
   
   JSONArray jsonarray = JSONArray.fromObject(memberlist);
%>
<%=jsonarray%>