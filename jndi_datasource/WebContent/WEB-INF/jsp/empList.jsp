<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員情報マネージャー</title>
	<link rel="stylesheet" 
	      href="<%= request.getContextPath() %>/css/style.css">
	<style>
	  .input-head { display: inline-block; width: 40px; text-align: right; }
	  .flex-area { display: flex; }
	  .left-area { flex-basis: 60%;}
	  .right-area { flex-basis: 40%; }
	</style>
</head>
<body>
	<header>
		<h1 class="center-layout">社員情報マネージャー</h1>
	</header>
	<main class="center-layout flex-area">
		<article class="left-area">
			<table>
				<tr>
					<th>ID</th>
					<th>名前</th>
					<th>年齢</th>
				</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.age}</td>
					</tr>
				</c:forEach>
			</table>
		</article>
		<aside class="right-area">
			<form action="${pageContext.request.contextPath}/new" method="POST">
				<span class="input-head">ID:</span> <input type="text" name="id"><br>
				<span class="input-head">名前:</span> <input type="text" name="name"><br>
				<span class="input-head">年齢:</span> <input type="text" name="age"><br>
				<input type="submit" value="新規メンバー登録">
			</form>
		</aside>
	</main>
	<footer>
		<small>&copy; 2023 Seiichi Nukayama</small>
	</footer>
</body>
</html>