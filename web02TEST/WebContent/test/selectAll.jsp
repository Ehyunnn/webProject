<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll.jsp</title>
</head>
<body>
	<h1>selectAll.jsp</h1>
	<jsp:include page="../menu.html"></jsp:include>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>col1</th>
				<th>col2</th>
				<th>col3</th>
				<th>col4</th>
				<th>col5</th>
				<th>col6</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="vo" items="${list}" varStatus="i">
				<tr>
					<td>${i.index+1}</td>
					<td><a href="selectOne.do?column1=${vo.column1}">${vo.column1}</a></td>
					<td>${vo.column2}</td>
					<td>${vo.column3}</td>
					<td>${vo.column4}</td>
					<td>${vo.column5}</td>
					<td>${vo.column6}</td>
					<td><a href="deleteOK.do?column1=${vo.column1}">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8">Tel:010-0000-0000</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>