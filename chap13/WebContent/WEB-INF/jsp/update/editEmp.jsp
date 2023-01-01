<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員編集 - 社員管理システム</title>
	<link href="/chap13/css/common.css" rel="stylesheet">
	<link href="/chap13/css/create-page.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h1>社員情報編集</h1>
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
							<th class="no-border">ID</th>
							<td class="no-border"><c:out value="${paramEmp.id}" /></td>
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
					<input type="hidden" name="id" value="${paramEmp.id}">
					<div class="btn-area">
						<a href="/chap13/employee"><button class="link-btn" type="button">キャンセル</button></a>
						<input type="submit" class="submit-btn" value="確認" formaction="/chap13/updateConfirm">
					</div>
				</form>
				
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>