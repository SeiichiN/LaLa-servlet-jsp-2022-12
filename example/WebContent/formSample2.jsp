<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録もどき2</title>
</head>
<body>
	<h1>ユーザー登録もどき2</h1>
	<form action="/example/FormSampleServlet2"
	      method="post">
		名前：<input type="text" name="name"><br>
		パスワード(半角英数4文字)：<input type="password" name="password"><br>
		<input type="submit" value="ログイン">
	</form>

</body>
</html>