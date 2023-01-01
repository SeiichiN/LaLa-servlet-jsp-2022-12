<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="/chap13/css/common.css" rel="stylesheet">
<!-- 	<link href="/chap13/css/create-page.css" rel="stylesheet"> -->
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
							<td>
								<c:out value="${emp.id}" />
							</td>
						</tr>
						<tr>
							<th>名前</th>
							<td>
								<c:out value="${emp.name}" />
							</td>
						</tr>
						<tr>
							<th>年齢</th>
							<td>
								<c:out value="${emp.age}" />
							</td>
						</tr>
					</table>
					<input type="hidden" name="id" value="${emp.id}">
					<input type="hidden" name="name" value="${emp.name}">
					
					<div class="btn-area">
						<input type="submit" class="link-btn" value="キャンセル" 
						       formaction="/chap13/employee" formmethod="get">
						<input type="submit" class="submit-btn" formaction="/chap13/deleteDone" value="削除" formmethod="post">
					</div>
				</form>
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>