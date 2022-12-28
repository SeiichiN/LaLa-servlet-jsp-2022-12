<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p349</title>
</head>
<body>
	<h1>静的インクルード</h1>
	<%= name %>さん<br>
	今日は<%= today %>です。
</body>
</html>