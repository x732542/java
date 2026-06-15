<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String mesg = "";
String errType = request.getParameter("errType");
if (errType != null) {
	if (errType.equals("1")) {
		mesg = "Register Failure";
	}
}
%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			src = "https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" >
		</script>
		
		<script type="text/javascript">
			function checkAccount() {
				let url = "CheckAccount";
				$.ajax({
					url : url,
					method : 'get',
					data : {
						data : JSON.stringfy({
							account : $("#account").val()
						})
					},
					success : function(data) {
						if (data.result) {
							$("#mesg").html("Account EXIST")
						} else {
							$("#mesg").html("")
						}
					},
				});
			}
			function checkForm() {
				return true;
			}
		</script>
	</head>
	<body>
		<h1>Register Page</h1>
		<hr />
		<div><%=mesg%></div>
		<form action="Register" method="post" onsumbit="checkForm()">
			Account: <input name="account" id="account" onblur="checkAccount()" />
			<span id="mesg"></span> <br /> Password: <input type="password"
				name="passwd" /><br /> <input type="submit" value="Register" />
		</form>
	</body>
</html>