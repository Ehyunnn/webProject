<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
</head>
<body>
	<header>
		<h1>selectAll</h1>
		<c:if test="${num != null}">
			<h1>${num} welcome </h1>
		</c:if>
		<jsp:include page="menu.html"></jsp:include>
	</header>
	<section>
		<table>
			<thead>
				<tr>
					<th>no</th>
					<th>num</th>
					<th>name</th>
					<th>tel</th>
					<th>address</th>
					<th>wdate</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list}" varStatus="i">
					<tr>
						<td>${i.index+1}</td>
						<td><a href="selectOne.do?num=${vo.num}">${vo.num}</a></td>
						<td><a href="selectOne.do?num=${vo.num}">${vo.name}</a></td>
						<td>${vo.tel}</td>
						<td>${vo.address}</td>
						<td>${vo.wdate}</td>
						<td><a href="deleteOK.do?num=${vo.num}">delete</a></td>
					</tr>
				</c:forEach>
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7" align="center">1 2 3 4 5</td>
				</tr>
			</tfoot>
		</table>
	</section>
</body>
</html>