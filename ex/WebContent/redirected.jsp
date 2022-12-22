<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = (Integer) request.getAttribute("number");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirected.jsp</title>
</head>
<body>
	<h1>redirected.jspだよ～</h1>
	<p>奇数やね > <%= num %></p>
	<p><a href="/ex/ex62">もう一度やる</a></p>
</body>
</html>