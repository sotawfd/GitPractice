<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データ削除</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String mail= request.getParameter("mail");
	%>
	<h1>下期のデータを削除しました。</h1>
	<p>Iメールアドレス<%=mail %></p><br>
	<a href="./">戻る</a>
</body>
</html>