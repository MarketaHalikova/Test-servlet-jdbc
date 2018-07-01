<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.marketahalikova.jdbctest.model.User" %>
<%@ page import="com.marketahalikova.jdbctest.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    Date date = new Date();
    String sDate  = dateFormat.format(date);
    User user = (User) session.getAttribute("userLogged");
%>
<head>
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>ProjectList</title>
</head>
<body>
<h2>Project List</h2>
<div>Date: <%= sDate%></div>
<div>User: <%= user.getUserName()%></div>
<form method="post" action="projectList.do">

    <br>
    <br>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>URL</th>
            <th>:)</th>
        </tr>
        </thead>
        <tbody>

<%
    List<Project> projects = (List<Project>) request.getAttribute("projects");
    for ( Project project : projects){
%>


        <tr>
            <td><%= project.getId()%></td>
            <td><%= project.getName()%></td>
            <td><%= project.getGitURL()%></td>
            <td><button type="submit" name="btn_project" value="<%= project.getId()%>">detail</button></td>
        </tr>
<%
    }
%>

        </tbody>
    </table>
    <br>
    <br>
    <button type="submit" name="btn_logout">logout</button>

</form>
</body>
</html>
