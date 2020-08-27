<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.LoginCheck" %>
<%
User user = (User) session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン結果画面</title>
</head>
<body>
<% if(user != null){%>
  <p><%= user.getName() %>さん、ようこそ<p>
  <a href="/TimeLine/Main">予定を投稿する</a>
<% }else{ %>
  <p>ログインに失敗しました</p>
  <a href="/TimeLine/">戻る</a>
<% } %>
</body>
</html>