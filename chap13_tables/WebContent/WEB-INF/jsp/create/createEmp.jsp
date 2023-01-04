<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>社員一覧</title>
	<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet">
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
				<form class="edit-form">
					<table>
						<tr>
							<th>名前</th>
							<td>
								<input type="text" name="name" 
								       value="<c:out value="${emp.name}" />">
							</td>
						</tr>
						<tr>
							<th>性別</th>
							<td>
								<input type="radio" id="male" name="gender_id" value="1"
								        ${emp.gender.id == 1 ? 'checked' : ''}>
								<label for="male">男性</label><br>
								<input type="radio" id="female" name="gender_id" value="2"
								       ${emp.gender.id == 2 ? 'checked' : ''}>
								<label for="female">女性</label><br>
								<input type="radio" id="other" name="gender_id" value="3"
								       ${emp.gender.id == 3 ? 'checked' : ''}>
								<label for="other">その他</label>
							</td>
						</tr>
						<tr>
							<th>誕生日</th>
							<td>
								<input type="text" name="birthday" placeholder="0000-00-00"
								       value="<c:out value="${emp.birthday.text}" />">
							</td>
						</tr>
						<tr>
							<th>部署</th>
							<td>
								<select name="dept_id" class="dept">
									<c:forEach var="dept" items="${deptList}">
										<option value="${dept.id}" ${dept.id == emp.dept.id ? 'selected' : '' }>
										${dept.name}
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<div class="btn-area">
						<input type="submit" class="link-btn" value="キャンセル"
						       formmethod="get"
						       formaction="${pageContext.request.contextPath}/list">
						<input type="submit" class="submit-btn" value="確認"
						       formmethod="post" 
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