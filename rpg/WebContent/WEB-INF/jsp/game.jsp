<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Hero" %>
<%@ page import="model.Dragon" %>
<%
Hero hero = (Hero) session.getAttribute("hero");
Dragon dragon = (Dragon) session.getAttribute("dragon");
String dragonAttack = (String) request.getAttribute("dragonAttack");
String heroAttack = (String) request.getAttribute("heroAttack");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>桃太郎</title>
</head>
<body>
	<h1>桃太郎とドラゴンとの戦い</h1>
	<h2>ドラゴン</h2>
	<p><%= dragon %> </p>

	<h2>桃太郎</h2>
	<p><%= hero %> </p>
	
	<h3>ドラゴンの攻撃</h3>
	<p><%= dragonAttack %>
	
	<h3>ヒーローの攻撃</h3>
	<p><%= heroAttack %>
	
	<h3>どうする？</h3>
	<form action="/rpg/Game" method="post">
		<input type="radio" name="sentaku" value="x">攻撃 ： 
		<input type="radio" name="sentaku" value="n">逃げる  
		<input type="submit" value="決定">
	</form>
</body>
</html>