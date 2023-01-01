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
				<form method="post">
					<table>
						<tr>
							<th class="no-border">ID</th>
							<td class="no-border">
								${paramEmp.id}
							</td>
						</tr>
						<tr>
							<th>名前</th>
							<td>
								<c:out value="${paramEmp.name}" />
							</td>
						</tr>
						<tr>
							<th>年齢</th>
							<td>
								<c:out value="${paramEmp.age}" />
							</td>
						</tr>
					</table>
					<input type="hidden" name="id" value="${paramEmp.id}">
					<input type="hidden" name="name" value="${paramEmp.name}">
					<input type="hidden" name="age" value="${paramEmp.age}">
					
					<div class="btn-area">
						<input type="submit" class="link-btn" value="キャンセル" formaction="/chap13/edit">
						<input type="submit" class="submit-btn" formaction="/chap13/updateDone" value="更新">
					</div>
				</form>
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>