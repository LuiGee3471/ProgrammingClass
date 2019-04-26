<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
if (<%=request.getAttribute("hasId")%> === true) {
  alert("이미 존재하는 아이디입니다.");
} else {
  alert("사용 가능한 아이디입니다.");
}