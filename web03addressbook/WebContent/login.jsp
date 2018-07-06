<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<header>
		<h1>login</h1>
		<jsp:include page="menu.html"></jsp:include>
	</header>
	<section>
		<form action="loginOK.do" method="post">
			<label>num</label>
			<input type="text" name="num" value="24"/><br>
			<label>tel</label>
			<input type="password" name="tel" value="010"/><br>
			<input type="submit" value="login"/>
		</form>
	</section>
</body>
</html>




