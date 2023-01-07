<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
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
  		<h1>社員一覧</h1>
  		<table>
  			<tr>
  				<th>ID</th>
  				<th>名前</th>
  				<th>性別</th>
  				<th>誕生日</th>
  				<th>所属</th>
  				<th class="no-border"></th>
  				<th class="no-border"></th>
  			</tr>
			  <c:forEach var="emp" items="${empList}">
			  	<tr>
			  		<td>${emp.id}</td>
			  		<td>${emp.name}</td>
			  		<td>${emp.gender.name}</td>
			  		<td>${emp.birthday}</td>
			  		<td>${emp.dept.name}</td>
			  		<td class="no-border">
			  			<form action="${pageContext.request.contextPath}/edit" method="post">
			  				<input type="hidden" name="id" value="${emp.id}">
			  				<input type="submit" value="編集" class="no-border no-background link-word">
			  			</form>
			  		</td>
			  		<td class="no-border">
			  			<form action="${pageContext.request.contextPath}/delete" method="post">
			  				<input type="hidden" name="id" value="${emp.id}">
			  				<input type="submit" value="削除" class="no-border no-background link-word">
			  			</form>
			  		</td>
			  	</tr>
			  </c:forEach>
			</table>	
	  </article>
	  <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
  </main>
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>