<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>index</h1>
	<c:if test="${num != null}">
		<h1>${num}welcome</h1>
	</c:if>
	<jsp:include page="menu.html"></jsp:include><br>
	<img width="400px" alt="index image" src="googlezzap.png">
</body>
</html>