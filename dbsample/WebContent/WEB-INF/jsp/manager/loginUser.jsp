<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管理ユーザー一覧 - 社員情報マネージャー</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
	<main class="center-layout">
		<jsp:include page="/WEB-INF/jsp/common/article-user.jsp" />
		<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
	</main>
	<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>