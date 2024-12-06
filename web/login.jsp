<%-- 
    Class      : CIS175 - Java II
    Document   : login.jsp
    Created on : Nov 26, 2024
    Author     : Logun Van Luong
    Contact    : lvanluong@dmacc.edu
    Description: Login form for authentication.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Management login Page</title>
        <link rel="stylesheet" type="text/css" media="screen" href="styles/myStyle.css" />
    </head>
    <header>
        <h1 style="color: cadetblue">Login Form</h1>
    </header>
    <body>
        <p class="center">Enter a username and password to continue.</p>
        <form action="j_security_check" method="get" class="center">
            <label>Username</label>
            <input type="text" name="j_username" class="formpadding"/><br>
            <label>Password</label>
            <input type="password" name="j_password" class="formpadding"/><br>
            <label>&nbsp;</label>
            <input type="submit" value="Login" class="formpadding"/><br>
        </form>
    </body>
</html>
