<%@ page import="com.marketahalikova.jdbctest.model.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.marketahalikova.jdbctest.model.Project" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date date = new Date();
    String sDate  = dateFormat.format(date);
    User user = (User) session.getAttribute("userLogged");
    Project project = (Project) request.getAttribute("project");
%>
<head>
    <title>ProjectDetail</title>
</head>
<body>
<h2>Project Detail</h2>
<div>Date: <%= sDate%></div>
<div>User: <%= user.getUserName()%></div>
<br>
<div>Name: <%= project.getName()%></div>
<div>ID: <%= project.getId()%></div>
<div>GIT url: <%= project.getGitURL()%></div>
<br>
<!-- zobrazit fonty projektu -->
<form method="post" action="projectDetail.do">
    <button type="submit" name="btn_back">back</button>
    <button type="submit" name="btn_logout">logout</button>
    <button type="submit" name="btn_error">surprise</button>
</form>
</body>
</html>
