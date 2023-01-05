<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
<!-- 	<link href="/chap13/css/create-page.css" rel="stylesheet"> -->
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h1>社員情報削除</h1>
				<p><c:out value="${msg}" /></p>
				<p><a href="${pageContext.request.contextPath}/list">
				     <button type="button">一覧へ</button></a></p>									
			</article>
	
		   <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>