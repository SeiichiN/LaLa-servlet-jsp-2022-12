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
		<h1>削除確認</h1>
		<p>以下の社員情報を削除してもいいですか？</p>
		<table>
			<tr><th>ID</th><td>${emp.id}</td></tr>
			<tr><th>名前</th><td>${emp.name}</td></tr>
			<tr><th>年齢</th><td>${emp.age}</td></tr>
    </table>
    <form>
    	<button type="submit"
    	        formaction="${pageContext.request.contextPath}/list"
    	        formmethod="get">
    		戻る
    	</button>
    	<input type="hidden" name="id" value="${emp.id}">
    	<button type="submit"
    				  formaction="${pageContext.request.contextPath}/deleteDone"
    				  formmethod="post">
    	  削除
    	</button>
    </form>				
	</article>

	<footer>
		<small>&copy; 2023 Seiichi Nukayama</small>
	</footer>
</body>
</html>