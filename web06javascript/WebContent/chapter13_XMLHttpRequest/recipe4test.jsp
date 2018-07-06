<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String name = "";
	
	
	if(request.getParameter("name")==null){
		out.print("sorry");
	}else{
		name = request.getParameter("name");
		System.out.println(name);
		if(name.equals("yangssem")){
			out.print("welcome");
		}else{
			out.print("Who are you");
		}
	}
	
	
	
%>