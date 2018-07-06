<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("userid");
	System.out.println("check.jsp" + id);
	if ("admin".equals(id)) {
		out.print("중복된 아이디입니다.");
	} else {
		out.print("사용가능한  아이디입니다.");
	}
%>
