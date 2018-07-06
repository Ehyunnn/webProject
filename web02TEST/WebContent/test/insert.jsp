<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.jsp</title>
</head>
<body>
	<h1>insert.jsp</h1>
	<jsp:include page="../menu.html"></jsp:include>
	<form action="insertOK.do" method="post">
		<label>col2</label>:
		<input type="text" name="column2" value="aaa"><br>
		<label>col3</label>:
		<input type="text" name="column3" value="bbb"><br>
		<label>col4</label>:
		<input type="text" name="column4" value="ccc"><br>
		<label>col5</label>:
		<input type="text" name="column5" value="ddd"><br>
		<label>col6</label>:
		<input type="text" name="column6" value="eee"><br>
		<input type="submit" value="insertOK">
	</form>
</body>
</html>