<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User user = (User) session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeLine</title>
</head>
<body>
<p>ユーザー名:<%= user.getName() %></p>
<form action="/TimeLine/Main" method="post">
<p>いつ？:<input type="text" name="when"></p>
<p>なにをしました？:<input type="text" name="what"></p>
<input type="submit" value="決定">
</form>
</body>
</html>