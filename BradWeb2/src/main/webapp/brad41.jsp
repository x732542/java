<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.apis.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>  
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>    
<c:catch var="err">
	<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx" var="data"></c:import>
	<c:set var="gifts" value="${BradUtils.parseGift(data) }"></c:set>

	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/brad"
		user="root"
		password="root"
	/>
	<sql:update>DELETE FROM gift</sql:update>
	<sql:update>ALTER TABLE gift AUTO_INCREMENT = 1</sql:update>
	<c:forEach items="${gifts }" var="gift">
		<sql:update>
			INSERT INTO gift (name,city,town,addr,tel,picurl) VALUES (?,?,?,?,?,?)
			<sql:param>${gift.name }</sql:param>
			<sql:param>${gift.city }</sql:param>
			<sql:param>${gift.town }</sql:param>
			<sql:param>${gift.addr }</sql:param>
			<sql:param>${gift.tel }</sql:param>
			<sql:param>${gift.picurl }</sql:param>
		 </sql:update>
	</c:forEach>
</c:catch>
<c:choose>
	<c:when test="${!empty err }">${err }</c:when>
	<c:otherwise>Finish</c:otherwise>
</c:choose>