<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>p150</title>
</head>
<body>
	<h1>３つの部品をもつフォームの例</h1>
	<form action="/example/FormSampleServlet"
	      method="post">
		名前：<input type="text" name="name"><br>
		性別：
		男<input type="radio" name="gender" value="0">
		女<input type="radio" name="gender" value="1"><br>
		<input type="submit" value="送信">
	</form>
</body>
</html>