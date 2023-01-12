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
  		
  		<form class="input-form">
	  		<table>
					<tr>
						<th>ID</th>
						<td>
						  <input class="input-box" type="text" name="id"
						         value="<c:out value="${emp.id}" />">
						</td>
					</tr>
					<tr>
						<th>名前</th>
						<td>
							<input class="input-box" type="text" name="name"
							       value="<c:out value="${emp.name}" />">
						</td>
					</tr>
					<tr>
						<th>性別</th>
						<td>
							<input type="radio" name="gender" value="1" id="man"
							       ${emp.gender.id == 1 ? 'checked' : ''}>
							<label for="man">男性</label>
							<input type="radio" name="gender" value="2" id="woman"
							       ${emp.gender.id == 2 ? 'checked' : ''}>
							<label for="woman">女性</label>
							<input type="radio" name="gender" value="3" id="other"
							       ${emp.gender.id == 3 ? 'checked' : ''}>
							<label for="other">その他</label>
						</td>
					</tr>
					<tr>
						<th>誕生日</th>
						<td>
						  <input class="input-box" type="text" name="birthday" 
						         placeholder="0000-00-00"
						         value="<c:out value="${emp.birthday}" />">
						</td>
					</tr>
					<tr>
						<th>部署</th>
						<td>
							<select name="dept">
								<c:forEach var="dept" items="${deptList}">
									<option value="${dept.id}"
									       ${dept.id == emp.dept.id ? 'selected' : ''}>
									  ${dept.name}
								  </option>
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