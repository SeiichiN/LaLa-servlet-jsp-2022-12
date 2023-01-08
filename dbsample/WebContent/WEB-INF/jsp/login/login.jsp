<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン - 社員情報マネージャー</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
	<header>
		<div id="header-inn" class="center-layout">
			<h1>社員情報マネージャー</h1>
		</div>
	</header>
  
  <main class="center-layout">
  		<article>
  			<h1>ログイン</h1>
				<ul>
  				<c:forEach var="error" items="${errorList}">
  					<li class="error">${error.key} : ${error.msg}</li>
  				</c:forEach>
  			</ul>
  			<form action="${pageContext.request.contextPath}/login" method="POST">
	  			ID：<input type="text" name="id"><br>
	  			パスワード：<input type="password" name="pass"><br>
	  			<input type="submit" value="ログイン">
  			</form>
  		</article>
  		
  </main>
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />

</body>
</html>