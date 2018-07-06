<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = "";
	String result = "";
	if (request.getParameter("id") == null) {
		out.print("No State Sent");
	} else {
		id = request.getParameter("id").trim();
		System.out.println(id);
		if (id.equals("admin") || id.length()==0) {
			result = "bad";
		}else{
			result = "good";
		}
	}
	out.print(id + "#" + result);
%>