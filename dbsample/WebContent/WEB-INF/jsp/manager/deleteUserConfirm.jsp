<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理ユーザー一覧 - 社員情報マネージャー</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
	<style>
		#password-form {
			display: flex;
		}
		.view-btn {
			font-size: 8px;
		}
		.flex-area {
			display: flex;
			justify-content: flex-end;
		}
		.input-form {
			width: 350px;
		}
		.submit-btn {
			margin-left: 10px;
		}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<main class="center-layout">
		<article>
			<h1>管理ユーザー削除・確認</h1>
			<div class="input-form">
				<table>
					<tr>
						<th>ID</th>
						<td>${deleteUser.id}</td>
					</tr>			
					<tr>
						<th>名前</th>
			  		<td>${deleteUser.name}</td>
					</tr>
	  		    </table>
				<div class="btn-area flex-area">
					<form action="${pageContext.request.contextPath}/list" method="get">
						<input type="submit" class="cansel-btn"	value="キャンセル">
					</form> 
					<form action="${pageContext.request.contextPath}/deleteUserDone" method="post">
						<input type="hidden" name="id" value="${deleteUser.id}">
						<input type="submit" class="submit-btn" value="削除">
					</form>
				</div>
		  </div>
	
			<p><a href="${pageContext.request.contextPath}/list">一覧へ</a></p>
		</article>
	
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
	</main>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>