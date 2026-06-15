<%@page import="org.json.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String x = request.getParameter("x");
String y = request.getParameter("y");

try {
    int result = Integer.parseInt(x) + Integer.parseInt(y);
    // 回傳包含結果的 JSON：{"result": 30}
	JSONObject obj = new JSONObject();
	obj.put("result",result);
	out.print(obj);

} catch (Exception e) {
    // 發生錯誤時回傳錯誤訊息 JSON
    out.print("{\"error\":\"請輸入有效數字\"}");
}
%>