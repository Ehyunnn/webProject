<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>random.do</title>
</head>
<body>
	<h1>random.do</h1>
	<h1>당첨 : ${param.name}</h1>
	<form action="randomPro.do" method="post">
		<input type="text" name="n01" value="김남은"/>
		<input type="text" name="n02" value="김윤성"/>
		<input type="text" name="n03" value="박이현"/>
		<input type="text" name="n04" value="이동준"/>
		<input type="text" name="n05" value="이세희"/>
		<input type="text" name="n06" value="장재광"/>
		<input type="text" name="n07" value="정은아"/>
		<input type="text" name="n08" value="조상묵"/>
		<input type="text" name="n09" value="진형기"/>
		<input type="text" name="n10" value="최준형"/>
		<input type="text" name="n11" value="한수진"/>
		<input type="text" name="n12" value="최태용"/>
		<input type="text" name="n13" value="곽찬양"/>
		<input type="submit" value="random button"/>
	</form>
</body>
</html>