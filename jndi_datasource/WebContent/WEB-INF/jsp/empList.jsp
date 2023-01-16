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
</head>
<body>
	<header>
		<h1 class="center-layout">社員情報マネージャー</h1>
	</header>
	<article class="center-layout">
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
		<form action="${pageContext.request.contextPath}/new" method="GET">
			<input type="submit" value="新規メンバー登録">
		</form>
	</article>
	<footer>
		<small>&copy; 2023 Seiichi Nukayama</small>
	</footer>
</body>
</html>