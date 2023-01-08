<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
	<h1>${article_title}</h1>
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
	  		<td class="no-border no-padding">
	  			<form action="${pageContext.request.contextPath}/edit" method="post">
	  				<input type="hidden" name="id" value="${emp.id}">
	  				<button type="submit" class="no-border no-background link-word">${img_pencil}</button>
	  			</form>
	  		</td>
	  		<td class="no-border no-padding">
	  			<form action="${pageContext.request.contextPath}/delete" method="post">
	  				<input type="hidden" name="id" value="${emp.id}">
	  				<button type="submit" class="no-border no-background link-word">${img_trash}</button>
	  			</form>
	  		</td>
	  	</tr>
	  </c:forEach>
  </table>	
  <c:if test="${article_title == '検索結果'}">
  	<p><a href="${pageContext.request.contextPath}/list">一覧へ</a></p>
  </c:if>
</article>


