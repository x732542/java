<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int a = 0;
	application.setAttribute("a", a);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>brad34 page</h1>
		a = ${a }<br />
		<a href="brad35.jsp">Goto brad35</a>
	</body>
</html>