<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="toba.Saicoro" %>
<%
Saicoro sai = new Saicoro();
int me = sai.getEye();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>丁半</title>
</head>
<body>
	<h1>丁半</h1>
	<div>
	    <% if (me % 2 == 0) { %>
		    丁です。
	    <% } else { %>
		    半です。
	    <% } %>
	</div>
</body>
</html>