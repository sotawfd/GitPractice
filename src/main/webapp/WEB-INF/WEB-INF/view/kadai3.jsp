<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Account3" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データ削除</title>
</head>
<body>
	<h1>削除するメールアドレスを入力してください</h1>
	<form action="RegisterFormServlet3" method="post">
		<input type="text" name="mail"><br>
		<input type="submit" value="送信">
		</form>
		<a href="./">戻る</a>
</body>
</html>