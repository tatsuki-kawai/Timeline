<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Action, java.util.List" %>
<%
User user = (User) session.getAttribute("User");
List<Action> actions = (List<Action>) session.getAttribute("Actions");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeLine</title>
</head>
<body>
<p>ユーザー名:<%= user.getName() %></p>
<a href="/TimeLine/Logout">ログアウト</a>
<form action="/TimeLine/Main" method="post">
<p>いつ？(ex.17:00):<input type="text" name="when"></p>
<p>なにをしました？(ex.バイト):<input type="text" name="what"></p>
<input type="submit" value="決定">
</form>
<%for(Action action : actions){ %>
 <p><%= action.getWhen() %>～ <%= action.getWhat()%></p>
<%} %>
</body>
</html>