<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String img_pencil = "<img src='/chap13/img/pencil.png' alt='編集' class='img-pencil'>";
String img_trash = "<img src='/chap13/img/trash.png' alt='削除' class='img-trash'>";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="/chap13/css/common.css" rel="stylesheet">
	<link href="/chap13/css/list-page.css" rel="stylesheet">
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
						<th>年齢</th>
						<th class="no-border"></th>
						<th class="no-border"></th>
					</tr>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.age}</td>
						<td class="no-border img-btn">
							<form action="/chap13/edit?id=${emp.id}" method="post">
								<button class="no-border no-background link-word" type="submit">
									<%= img_pencil %>
								</button>
							</form>
						</td>
						<td class="no-border img-btn">
							<form action="/chap13/delete?id=${emp.id}" method="post">
								<button class="no-border no-background link-word" type="submit">
									<%= img_trash %>
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