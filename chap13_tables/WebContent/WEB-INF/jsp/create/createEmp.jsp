<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/create-page.css" rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		<main class="center-layout">
			<article>
				<h1>新規社員登録</h1>
				<c:if test="${not empty errorList}">
					<ul>
					<c:forEach var="error" items="${errorList}">
						<li class="error">
							<c:out value="${error.key}" /> :
							<c:out value="${error.msg}" /> 
						</li>
					</c:forEach>
					</ul>
				</c:if>
				<form method="post">
					<table>
						<tr>
							<th>名前</th>
							<td>
								<input type="text" name="name" value="<c:out value="${paramEmp.name}" />">
							</td>
						</tr>
						<tr>
							<th>性別</th>
							<td>
								<input type="radio" id="male" name="gender_id" value="1"
								        ${paramEmp.gender_id == 1 ? 'checked' : ''}>
								<label for="male">男性</label><br>
								<input type="radio" id="female" name="gender_id" value="2"
								       ${paramEmp.gender_id == 2 ? 'checked' : ''}>
								<label for="female">女性</label><br>
								<input type="radio" id="other" name="gender_id" value="3"
								       ${paramEmp.gender_id == 3 ? 'checked' : ''}>
								<label for="other">その他</label>
							</td>
						</tr>
						<tr>
							<th>誕生日</th>
							<td>
								<input type="text" name="birthday" placeholder="西暦年4桁-月2桁-日2桁"
								       value="<c:out value="${paramEmp.birthday}" />">
							</td>
						</tr>
						<tr>
							<th>部署</th>
							<td>
								<select name="dept_id" class="dept">
									<c:forEach var="dept" items="${deptList}">
										<option value="${dept.id}">${dept.name}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<div class="btn-area">
						<a href="${pageContext.request.contextPath}/list">
						    <button class="link-btn" type="button">キャンセル</button>
						</a>
						<input type="submit" class="submit-btn" value="確認" 
						       formaction="${pageContext.request.contextPath}/createConfirm">
					</div>
				</form>
				
			</article>
	
			<jsp:include page="/WEB-INF/jsp/common/aside.jsp" />	
		</main>
		<jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
	</div><!-- #wrap -->
</body>
</html>