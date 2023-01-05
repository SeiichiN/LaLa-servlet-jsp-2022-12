<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員管理マネージャー</title>
	<link rel="stylesheet" 
	      href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
	<header>
		<h1 class="center-layout">社員管理マネージャー</h1>
	</header>
	<article class="center-layout">
		<h1>削除処理</h1>
		<p>${msg}</p>
    <form>
    	<button type="submit"
    	        formaction="${pageContext.request.contextPath}/list"
    	        formmethod="get">
    		一覧へ
    	</button>
    </form>				
	</article>

	<footer>
		<small>&copy; 2023 Seiichi Nukayama</small>
	</footer>
</body>
</html>