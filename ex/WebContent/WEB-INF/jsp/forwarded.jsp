<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = (Integer)request.getAttribute("number");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwarded.jsp</title>
</head>
<body>
	<h1>forwarded.jspだよ～</h1>
	<p>偶数やね > <%= num %></p>
	<p><a href="/ex/ex62">もう一度やる</a></p>
</body>
</html>