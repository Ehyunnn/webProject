<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectOne.do</title>
</head>
<body>
	<h1>selectOne.do</h1>
	<jsp:include page="../menu.html"></jsp:include>
	<form action="updateOK.do" method="post">
		<label>col1</label>:<label>${param.column1}</label>
		<input type="hidden" name="column1" value="${param.column1}"><br>
		<label>col2</label>:
		<input type="text" name="column2" value="${vo2.column2}"><br>
		<label>col3</label>:
		<input type="text" name="column3" value="${vo2.column3}"><br>
		<label>col4</label>:
		<input type="text" name="column4" value="${vo2.column4}"><br>
		<label>col5</label>:
		<input type="text" name="column5" value="${vo2.column5}"><br>
		<label>col6</label>:
		<input type="text" name="column6" value="${vo2.column6}"><br>
		<input type="submit" value="updateOK">
	</form>
</body>
</html>