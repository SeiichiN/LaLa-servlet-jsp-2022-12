<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>社員情報マネージャー</title>
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/common/header.jsp" />
  
  <main class="center-layout">
	<article>
		<h1>管理ユーザー一覧</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>名前</th>
			</tr>
		  <c:forEach var="user" items="${userList}">
		  	<tr>
		  		<td>${user.id}</td>
		  		<td>${user.name}</td>
		  	</tr>
		  </c:forEach>
	  </table>	
	  <p><a href="${pageContext.request.contextPath}/list">一覧へ</a></p>
	</article>

    <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
  </main>
  
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>
