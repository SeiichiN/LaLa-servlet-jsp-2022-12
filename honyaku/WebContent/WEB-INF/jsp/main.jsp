<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>翻訳</title>
</head>
<body>
<h1>グーグル翻訳</h1>
	<table>
		<tr>
			<th>英語</th>
			<th>日本語</th>
		</tr>
		<tr>
			<td>
				<form action="" method="post" id="input-form">
					<input type="text" name="word" value="<c:out value="${word}" />">
				</form>
			</td>
			<td>
				${data}
			</td>
		</tr>
	</table>
		<button type="submit" form="input-form">翻訳</button>
</body>
</html>