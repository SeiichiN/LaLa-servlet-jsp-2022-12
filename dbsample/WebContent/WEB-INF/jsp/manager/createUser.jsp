<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理ユーザー - 社員情報マネージャー</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
	<style>
		.input-form {
			width: 350px;
		}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<main class="center-layout">
		<article>
			<h1>管理ユーザー新規登録</h1>
			<p>管理者として登録したい人のIDを入力してください。</p>
			<c:if test="${not empty msg}">
				<p class="error">${msg}</p>
			</c:if>
			<form class="input-form" action="${pageContext.request.contextPath}/createUser" method="post">
			  ID: <input type="text" name="id" value="<c:out value="${newUser.id}" />">
					<div><input type="submit" class="submit-btn" value="呼出"></div>
			</form>
	
			<p><a href="${pageContext.request.contextPath}/list">一覧へ</a></p>
		</article>
	
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
	</main>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>