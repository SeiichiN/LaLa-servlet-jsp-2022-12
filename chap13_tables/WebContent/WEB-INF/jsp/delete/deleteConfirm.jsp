<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
<%-- 	<link href="${pageContext.request.contextPath}/css/create-page.css" rel="stylesheet"> --%>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h1>社員情報削除・確認</h1>
				<p>以下の社員情報を削除します。よろしいですか？</p>
				<form>
					<table>
						<tr>
							<th>ID</th>
							<td><c:out value="${emp.id}" /></td>
						</tr>
						<tr>
							<th>名前</th>
							<td>
								<c:out value="${emp.name}" />
							</td>
						</tr>
						<tr>
							<th>性別</th>
							<td>
								<c:if test="${emp.gender.id == '0'}">不明</c:if>
								<c:if test="${emp.gender.id == '1'}">男性</c:if>
								<c:if test="${emp.gender.id == '2'}">女性</c:if>
								<c:if test="${emp.gender.id == '3'}">その他</c:if>
							</td>
						</tr>
						<tr>
							<th>誕生日</th>
							<td>
								<c:out value="${emp.birthday.text}" />
							</td>
						</tr>
						<tr>
							<th>部署</th>
							<td>
								<c:out value="${emp.dept.name}" />
							</td>
						</tr>
					</table>
					<input type="hidden" name="id" value="${emp.id}">
					<input type="hidden" name="name" value="${emp.name}">
					
					<div class="btn-area">
						<input type="submit" class="link-btn" value="キャンセル" 
						       formaction="${pageContext.request.contextPath}/list" formmethod="get">
						<input type="submit" class="submit-btn" 
						       formaction="${pageContext.request.contextPath}/deleteDone" value="削除" formmethod="post">
					</div>
				</form>
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>