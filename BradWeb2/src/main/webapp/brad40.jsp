<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql"  prefix="sql" %>
<c:catch var="err">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/brad"
		user="root"
		password="root"
	/>
	<sql:query var="rs">
		SELECT * 
		FROM food
	</sql:query>
</c:catch>
${err }
資料筆數:${rs.rowCount }<br />
<!-- rs.rows => [Map,Map,Map ,...] -->
<table border="1" width="100%">
	<tr>
		<th>Id</th>
		<th>Name</th>
	</tr>
	<c:forEach items="${rs.rows }" var="food">
	<tr>
		<td>${food.id }</td>
		<td>${food.name }</td>
	</tr>
	
	</c:forEach>
</table>