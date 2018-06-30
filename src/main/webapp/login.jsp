<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login please</h2>
<form method="post" action="login.do">

    <label for="userName">Username</label>
    <input type="text" name="userName" id="userName">
    <label for="password">Password</label>
    <input type="password" name="inputPassword" id="password">
    <br/><br/>
    <div class="checkbox">
    <label>
        <input type="checkbox" name="rememberMe">Remember me
    </label>
    </div>
    <br/>
    <button type="submit" name="btn_login">Login</button>
</form>
</body>
</html>
