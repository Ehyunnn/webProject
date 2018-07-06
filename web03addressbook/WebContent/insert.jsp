<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
	<header>
		<h1>insert</h1>
		<jsp:include page="menu.html"></jsp:include>
	</header>
	<section>
		<form action="insertOK.do" method="post">
			<label>name</label>
			<input type="text" name="name" value="kim"/><br>
			<label>tel</label>
			<input type="text" name="tel" value="010"/><br>
			<label>address</label>
			<input type="text" name="address" value="ganglung"/><br>
			<input type="submit" value="OK"/>
		</form>
	</section>
</body>
</html>




