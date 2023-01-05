<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員管理マネージャー</title>
	<link rel="stylesheet" 
	      href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<header>
		<h1 class="center-layout">社員管理マネージャー</h1>
	</header>
	<article class="center-layout">
		<table>
			<tr>
				<th>ID</th>
				<th>名前</th>
				<th>年齢</th>
				<th class="no-border"></th>
				<th class="no-border"></th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.name}</td>
					<td>${emp.age}</td>
					<td class="no-border">編集</td>
					<td class="no-border">
						<form action="${pageContext.request.contextPath}/delete" method="post">
							<input type="hidden" name="id" value="${emp.id}">
							<button type="submit"
							       class="submit-btn no-border no-background">削除</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</article>
	<footer>
		<small>&copy; 2023 Seiichi Nukayama</small>
	</footer>
</body>
</html>