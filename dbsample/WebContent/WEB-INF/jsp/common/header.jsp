<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div id="header-inn" class="center-layout">
		<h1 class=""><a href="${pageContext.request.contextPath}/list">社員情報マネージャー</a></h1>
		<div>
			<span id="loginuser">
			  <a href="${pageContext.request.contextPath}/dbmanager">${loginUser.name}さん</a>、ログイン中
			</span>
			<span id="logout"><a href="${pageContext.request.contextPath}/logout">ログアウト</a></span>
		</div>
	</div>
</header>
