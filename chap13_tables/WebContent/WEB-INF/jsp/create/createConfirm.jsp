<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/list-page.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h1>新規社員登録・確認</h1>
				<form method="post">
					<table>
						<tr>
							<th>名前</th>
							<td>
								<c:out value="${paramEmp.name}" />
							</td>
						</tr>
						<tr>
							<th>性別</th>
							<td>
								<c:choose>
									<c:when test="paramEmp.gender == 0">不明</c:when>
									<c:when test="paramEmp.gender == 1">男性</c:when>
									<c:when test="paramEmp.gender == 2">女性</c:when>
									<c:otherwise>その他</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<th>誕生日</th>
							<td>
								<c:out value="${paramEmp.birthday}" />
							</td>
						</tr>
						<tr>
							<th>部署</th>
							<td>
								<c:out value="${paramEmp.dept_id}" />
							</td>
						</tr>
					</table>
					<input type="hidden" name="name" value="${paramEmp.name}">
					<input type="hidden" name="gender_id" value="${paramEmp.gender_id}">
					<input type="hidden" name="birthday" value="${paramEmp.birthday}">
					<input type="hidden" name="dept_id" value="${paramEmp.dept_id}">
					
					<div class="btn-area">
						<input type="submit" class="link-btn" value="キャンセル" 
						       formaction="${pageContext.request.contextPath}/create">
						<input type="submit" class="submit-btn" 
						       formaction="${pageContext.request.contextPath}/createDone" value="登録">
					</div>
				</form>
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>