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
		if (search.equals("dragonfly2.thumbnail.jpg")) {
			result = "This photo was taken at the Missouri Botanical Gardens, and features common dragonfly on pink and yellow flower";
		} else if (search.equals("dragonfly4.thumbnail.jpg")) {
			result = "This photo as taken at the Missouri Botanical Gardens, and features a small orange dragon fly on a water lily";
		} else if (search.equals("dragonfly6.thumbnail.jpg")) {
			result = "Another dragonfly on a purple water lily, again taken at the Missouri Botanical Gardens";
		} else if (search.equals("dragonfly8.thumbnail.jpg")) {
			result = "Common dragonfly on pink water lily at the Missouri Botanical Gardens";
		} else {
			result = "No Nice Things  Found";
		}

	}
	out.print(search + "#" + result);
%>