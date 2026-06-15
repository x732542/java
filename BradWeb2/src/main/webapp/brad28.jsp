<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- $ { } => EL => Expression Language -->
<%
	Bike b1 = new Bike();
	pageContext.setAttribute("bike", b1);
	b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		PI: ${Math.PI }<br />
		PI: <%= Math.PI %><br />
		Random: ${Math.random() }<br />
		Bike: ${bike }
	</body>
</html>