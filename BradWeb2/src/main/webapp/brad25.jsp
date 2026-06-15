<%@page import="org.json.JSONObject"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BufferedReader reader = request.getReader();
String line;
StringBuffer sb = new StringBuffer();
while ((line = reader.readLine()) != null) {
	sb.append(line);
}

//--------------------------------
String json = sb.toString();
JSONObject root = new JSONObject();

String op = root.getString("op");
JSONObject params = root.getJSONObject("params");
String x = params.getString("x");
String y = params.getString("y");

System.out.println(op + ":" + x + ":" + y);
%>