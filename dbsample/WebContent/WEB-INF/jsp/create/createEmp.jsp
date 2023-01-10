<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>新規社員情報登録 - 社員情報マネージャー</title>
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
  <jsp:include page="/WEB-INF/jsp/common/header.jsp" />
  
  <main class="center-layout">
  	<article>
  		<h1>新規社員情報登録</h1>
  		
  		<form class="input-form">
	  		<table>
					<tr>
						<th>ID</th>
						<td><input class="input-box" type="text" name="id"></td>
					</tr>
					<tr>
						<th>名前</th>
						<td><input class="input-box" type="text" name="name"></td>
					</tr>
					<tr>
						<th>性別</th>
						<td>
							<input type="radio" name="gender" value="1" id="man">
							<label for="man">男性</label>
							<input type="radio" name="gender" value="2" id="woman">
							<label for="woman">女性</label>
							<input type="radio" name="gender" value="3" id="other">
							<label for="other">その他</label>
						</td>
					</tr>
					<tr>
						<th>誕生日</th>
						<td><input class="input-box" type="text" name="birthday" 
						           placeholder="0000-00-00"></td>
					</tr>
					<tr>
						<th>部署</th>
						<td>
							<select name="dept">
								<c:forEach var="dept" items="${deptList}">
									<option value="${dept.id}">${dept.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
			  </table>
		  	<div class="btn-area">
		  		<input type="submit" value="キャンセル" 
		  		       class="cansel-btn" formmethod="GET"
		  		       formaction="${pageContext.request.contextPath}/list">
		  		<input type="submit" value="確認" 
		  		       class="submit-btn" formmethod="POST"
		  		       formaction="${pageContext.request.contextPath}/createConfirm">
		  	</div>
		  </form>
	  </article>
	  <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
  </main>
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>