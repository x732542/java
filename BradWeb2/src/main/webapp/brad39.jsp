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
	<sql:update var="n">
		INSERT INTO test
		  (cname, tel, birthday)
		VALUES
		  ('eee','123','1999-01-02'),
		  ('fff','123','1999-01-02'),
		  ('ggg','123','1999-01-02')
	</sql:update>
</c:catch>
${err }
${n }
