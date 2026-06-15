<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>  
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:set var="rpp" value="10"></c:set>
<c:set var="page" value="${empty param.page ? 1 : param.page }"></c:set>
<c:set var="start" value="${(page - 1) * rpp }"></c:set>
<c:set var="prev" value="${page == 1?1:page - 1 }"></c:set>
<c:set var="next" value="${page + 1 }"></c:set>
<sql:query var="rs" dataSource="jdbc/mysql">
	SELECT * FROM gift LIMIT ${start }, ${rpp }
</sql:query>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			table {border-collapse:collapse; width: 100%}
			th,td {border: 1px solid #ccc; padding 8px}
		</style>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<div><a href="?page=${prev }">Prev</a> | Page: <span>${page }</span>| <a href="?page=${next }">Next</a></div>
		<hr />
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Tel</th>
			</tr>
			<c:forEach items="${rs.rows }" var="gift">
				<tr>
					<td>${gift.id }</td>
					<td>${gift.name }</td>
					<td>${gift.tel }</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>