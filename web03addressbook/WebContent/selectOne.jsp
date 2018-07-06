<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne</title>
</head>
<body>
	<header>
		<h1>selectOne</h1>
		<jsp:include page="menu.html"></jsp:include>
	</header>
	<section>
		<form action="updateOK.do" method="get">
			<label>num</label>: <label>${param.num}</label> 
			<input type="hidden" name="num" value="${param.num}" /><br> 
			
			<label>name</label> 
			<input type="text" name="name" value="${vo2.name}" /><br> 
			
			<label>tel</label>
			<input type="text" name="tel" value="${vo2.tel}" /><br> 
			
			<label>address</label>
			<input type="text" name="address" value="${vo2.address}" /><br> 
			
			<label>wdate</label>
			<label>${vo2.wdate}</label><br>
			<input type="submit" value="OK" />
		</form>
	</section>
</body>
</html>




