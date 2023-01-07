<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="/chap13/css/common.css" rel="stylesheet">
	<link href="/chap13/css/create-page.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h1>社員情報更新・確認</h1>
				<p>以下の内容で更新します。よろしいですか？</p>
				<table>
					<tr>
						<th class="no-border">ID</th>
						<td class="no-border">
							${emp.id}
						</td>
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
							<c:out value="${emp.gender.name}" />
						</td>
					</tr>
					<tr>
						<th>誕生日</th>
						<td>
							<c:out value="${emp.birthday}" />
						</td>
					</tr>
					<tr>
						<th>部署名</th>
						<td>
							<c:out value="${emp.dept.name}" />
						</td>
					</tr>
					
				</table>
				<form method="post">
					<input type="hidden" name="id" value="${emp.id}">
					<input type="hidden" name="name" value="${emp.name}">
					<input type="hidden" name="gender_id" value="${emp.gender.id}">
					<input type="hidden" name="birthday" value="${emp.birthday}">
					<input type="hidden" name="dept_id" value="${emp.dept_id}">
					
					<div class="btn-area">
						<input type="submit" class="cansel-btn" value="キャンセル"
						       formaction="${pageContext.request.contextPath}/edit">
						<input type="submit" class="submit-btn" value="更新"
						       formaction="${pageContext.request.contextPath}/updateDone">
					</div>
				</form>
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>