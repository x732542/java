<%@page import="org.json.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String data = request.getParameter("data");

JSONObject root = new JSONObject(data);
String op =root.getString("op");

JSONObject params = new JSONObject("params");
String x =params.getString("x");
String y =params.getString("y");

StringBuffer result = new StringBuffer();
switch (op){
case"1": result.append(Integer.parseInt(x) + Integer.parseInt(y));break;
case"2": result.append(Integer.parseInt(x) - Integer.parseInt(y));break;
case"3": result.append(Integer.parseInt(x) * Integer.parseInt(y));break;
case"4": 
	result.append(Integer.parseInt(x) / Integer.parseInt(y))
	.append("......")
	.append(Integer.parseInt(x) % Integer.parseInt(y));break;
}
JSONObject obj = new JSONObject();
obj.put("result",result);
out.print(obj);

%>