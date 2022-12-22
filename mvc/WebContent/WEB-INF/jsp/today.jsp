<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Uranai" %>
<%
Uranai u = (Uranai) request.getAttribute("kekka");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ占い</title>
</head>
<body>
	<h1>スッキリ占い</h1>
	<p><%= u.getToday() %>の運勢は <%= u.getLuck() %></p>
</body>
</html>