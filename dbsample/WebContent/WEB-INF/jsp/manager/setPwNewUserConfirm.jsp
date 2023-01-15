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
			<h1>管理ユーザー編集・パスワード設定</h1>
			<p>${msg}</p>
			<div class="input-form">
				<table>
					<tr>
						<th>ID</th>
						<td>${newUser.id}</td>
					</tr>			
					<tr>
						<th>名前</th>
			  		<td>${newUser.name}</td>
					</tr>
					<tr>
						<th>パスワード</th>
				  	<td>
				  		<form id="password-form" method="post"
				  		       action="${pageContext.request.contextPath}/setPwNewUserDone">
					  		<input type="password" name="pass" class="input-box password-box"
				  			       value="<c:out value="${newUser.pass}" />">
				  			<span class="view-btn">(*)</span>
				  			<input type="hidden" name="id" value="${newUser.id}">
				  			<input type="hidden" name="name" value="${newUser.name}">
			  			</form>
				  	</td>
					</tr>
			  </table>
				<div class="btn-area flex-area">
					<input form="password-form" type="submit" class="submit-btn"	value="登録">
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