<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Fruit" %>
<%
Fruit fruit = (Fruit) session.getAttribute("fruit");
String sessionId = (String) session.getAttribute("sessionId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>セッションスコープ</title>
</head>
<body>
	<h1>fruit2.jsp</h1>
	<p><%= fruit.getName() %>の値段は、
	   <%= fruit.getPrice() %>です。</p>
	<p>sessionId: <%=sessionId %></p>
	<p><a href="/lesson7/FruitServlet">再読込</a></p>
</body>
</html>