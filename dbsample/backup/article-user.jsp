<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<article>
	<h1>${article_title}</h1>
	<div class="input-form">
		<table>
			<tr>
				<th>ID</th>
				<td>${loginUser.id}</td>
			</tr>			
			<tr>
				<th>名前</th>
	  		<td>${loginUser.name}</td>
			</tr>
			<tr>
				<th>パスワード</th>
	  		<td class="password-td">
		  		<form id="password-form">
		  			<input type="text" name="password" class="input-box password-box"
		  			       value="<c:out value="${loginUser.pass}" />">
		  			<span class="view-btn">(*)</span>
		  		</form>
	  		</td>
			</tr>
	  </table>
  </div>
	<div class="btn-area flex-area">
		<form action="${pageContext.request.contextPath}/list" method="get">
			<input type="submit" class="cansel-btn"	value="キャンセル">
		</form> 
		<input
			type="submit" class="submit-btn" value="パスワード更新" formmethod="post"
			form="password-form"
			formaction="${pageContext.request.contextPath}/changePassword">
	</div>

	<p><a href="${pageContext.request.contextPath}/list">一覧へ</a></p>
</article>


