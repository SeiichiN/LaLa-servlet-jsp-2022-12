<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>新規社員情報登録結果 - 社員情報マネージャー</title>
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/common/header.jsp" />
  
  <main class="center-layout">
  	<article>
  		<h1>新規社員情報登録結果</h1>
  		<p>${msg}</p>
  		<a href="${pageContext.request.contextPath}/list">一覧</a>
 	  </article>
	  <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
  </main>
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>