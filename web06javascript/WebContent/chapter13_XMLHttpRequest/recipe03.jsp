<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String result = "";
	String search = "";
	if (request.getParameter("photo") == null) {
		out.print("No State Sent");
	} else {
		search = request.getParameter("photo").trim();
		System.out.println(search);
		if (search.equals("dragonfly2")) {
			result = "This photo was taken at the Missouri Botanical Gardens, and features common dragonfly on pink and yellow flower";
		} else if (search.equals("dragonfly4")) {
			result = "This photo as taken at the Missouri Botanical Gardens, and features a small orange dragon fly on a water lily";
		} else if (search.equals("dragonfly6")) {
			result = "Another dragonfly on a purple water lily, again taken at the Missouri Botanical Gardens";
		} else if (search.equals("dragonfly8")) {
			result = "Common dragonfly on pink water lily at the Missouri Botanical Gardens";
		} else {
			result = "No Nice Things  Found";
		}

	}
	out.print(search + "#" + result);
%>