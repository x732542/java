<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
    	int r = 0;
	
    	String x = request.getParameter("x");
    	String y = request.getParameter("y");
    
        if (x != null && y != null && !x.isEmpty() && !y.isEmpty()) {
            try {
                int xx = Integer.parseInt(x);
                int yy = Integer.parseInt(y);
                r = xx + yy;
            } catch (Exception e) {
            }			
        }
    %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="Brad16">
        <input name="x" value="<%= x != null ? x : "" %>" />
        +
        <input name="y" value="<%= y != null ? y : "" %>" />
        <input type="submit" value="=" />
        <div>結果為：<%= r %></div>		
        </form>
	</body>
</html>