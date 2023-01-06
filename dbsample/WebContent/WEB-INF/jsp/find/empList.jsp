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
		  <c:forEach var="emp" items="${empList}">
		  	${emp.id}<br>
		  	${emp.name}<br>
		  	${emp.gender.id} : ${emp.gender.name}<br>
		  	${emp.birthday}<br>
		  	${emp.dept.id} : ${emp.dept.name}<br>
		  	<br>
		  </c:forEach>
	  </article>
	  <jsp:include page="/WEB-INF/jsp/common/aside.jsp" />
  </main>
  <jsp:include page="/WEB-INF/jsp/common/footer.jsp" />
</body>
</html>