<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン - 社員情報マネージャー</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <style>
  	.login-form {
  		width: 300px;
  	}
  	.input-line {
  		display: flex;
  		margin-bottom: 10px;
  	}
  	.input-title {
  		text-align: right;
  		flex-basis: 200px;
  	}
  	.submit-line {
  		text-align: right;
  	}
  	.input-box {
  		border: solid 1px #aaa;
  	}
  </style>
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
  			<form class="login-form" action="${pageContext.request.contextPath}/login" method="POST">
	  			<div class="input-line">
	  			  <div class="input-title">ID：</div>
	  			  <input class="input-box" type="text" name="id">
	  			</div>
	  			<div class="input-line">
	  				<div class="input-title">パスワード：</div>
	  			  <input class="input-box" type="password" name="pass">
					</div>
	  			<div class="submit-line">
	  				<input type="submit" value="ログイン">
	  			</div>
  			</form>
  		</article>
  		
  </main>
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />

</body>
</html>