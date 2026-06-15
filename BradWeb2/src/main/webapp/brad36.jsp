<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="x" value="10"></c:set>
		x=${x }<br />
		<c:set var="x" value="100" scope="request"></c:set>
		request x =${requestScope.x }<br />
		<c:set var="y">3</c:set>
		y=${y }<br />
		<c:set value="Hello,World"></c:set>
		param.x=${param.x } <br />
		param.x
	</body>
</html>