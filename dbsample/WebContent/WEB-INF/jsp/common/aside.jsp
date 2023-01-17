<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside>
	<h1>メニュー</h1>
	<nav>
		<ul class="menu">
			<li><a href="${pageContext.request.contextPath}/create">新規社員情報登録</a></li>
			<li>
				<form action="${pageContext.request.contextPath}/findName" method="post" 
				      class="search-form">
					<input type="text" name="name" class="search-box" placeholder="名前で検索">
					<button type="submit" class="no-border no-background search-img">${img_find}</button>
				</form>
			</li>
			<li>
				<form action="${pageContext.request.contextPath}/findDept" method="post" 
				      class="search-form">
					<select name="deptId" class="search-box">
						<c:forEach var="dept" items="${deptList}">
							<option value="${dept.id}">${dept.name}</option>
						</c:forEach>
					</select>
					<button type="submit" class="no-border no-background search-img">${img_find}</button>
				</form>
			</li>
			<li class="out-item">管理ユーザー
				<ul class="in-menu">
					<li><a href="${pageContext.request.contextPath}/createUser">登録</a></li>
					<li><a href="${pageContext.request.contextPath}/userList">一覧</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</aside>
