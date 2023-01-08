<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div id="header-inn" class="center-layout">
		<h1 class=""><a href="${pageContext.request.contextPath}/list">社員情報マネージャー</a></h1>
		<div id="logout">
			<span id="loginuser">${loginUser.name}さん、ログイン中</span>
			<a href="${pageContext.request.contextPath}/logout">ログアウト</a>
		</div>
	</div>
</header>
