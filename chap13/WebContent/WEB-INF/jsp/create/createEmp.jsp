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
				<h1>新規社員登録</h1>
				<c:if test="${not empty errorList}">
					<ul>
					<c:forEach var="error" items="${errorList}">
						<li class="error">
							<c:out value="${error.key}" /> :
							<c:out value="${error.msg}" /> 
						</li>
					</c:forEach>
					</ul>
				</c:if>
				<form method="post">
					<table>
						<tr>
							<th>ID</th>
							<td>
								<input type="text" name="id" value="<c:out value="${paramEmp.id}" />">
							</td>
						</tr>
						<tr>
							<th>名前</th>
							<td>
								<input type="text" name="name" value="<c:out value="${paramEmp.name}" />">
							</td>
						</tr>
						<tr>
							<th>年齢</th>
							<td>
								<input type="text" name="age" value="<c:out value="${paramEmp.age}" />">
							</td>
						</tr>
					</table>
					<div class="btn-area">
						<a href="/chap13/employee"><button class="link-btn" type="button">キャンセル</button></a>
						<input type="submit" value="確認" formaction="/chap13/createConfirm">
					</div>
				</form>
				
			</article>
	
			<aside>
				<div><a href="/chap13/create">新規社員登録</a></div>
			</aside>	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>