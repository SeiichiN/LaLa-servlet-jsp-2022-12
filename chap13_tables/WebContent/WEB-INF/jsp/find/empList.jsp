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
				<h1>社員一覧</h1>
				<c:if test="${not empty myError}">
					${myError.key} : ${myError.msg}
				</c:if>
				<table>
					<tr>
						<th>ID</th>
						<th>名前</th>
						<th>性別</th>
						<th>年齢</th>
						<th>誕生日</th>
						<th>部署</th>
						<th class="no-border"></th>
						<th class="no-border"></th>
					</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.gender.name}</td>
						<td>${emp.birthday.age}</td>
						<td>${emp.birthday.text}</td>
						<td>${emp.dept.name}</td>
						<td class="no-border img-btn">
							<form action="${pageContext.request.contextPath}/edit" method="post">
								<input type="hidden" name="id" value="${emp.id}">
								<button class="no-border no-background link-word" type="submit">
									${img_pencil}
								</button>
							</form>
						</td>
						<td class="no-border img-btn">
							<form action="${pageContext.request.contextPath}/delete" method="post">
								<input type="hidden" name="id" value="${emp.id}">
								<button class="no-border no-background link-word" type="submit">
									${img_trash}
								</button>
							</form>
						</td>
					</tr>
				</c:forEach>
				</table>
			</article>
	
		   <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>