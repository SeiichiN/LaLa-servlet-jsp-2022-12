<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アルコール</title>
</head>
<body>
	<h1>アルコール</h1>
	<p><%= user.getText() %></p>
	<p><a href="/alchole/ask">もどる</a></p>
</body>
</html>