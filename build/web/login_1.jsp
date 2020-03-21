<%-- 
    Document   : login
    Created on : Aug 14, 2013, 5:02:57 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/style-v1.css" />
        <script type="text/javascript" src="Script/Jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="Script/main-app.js"></script>        
    </head>
    <body>
        <form action="./LoginServlet" method="POST">           
            <div class="login-page">
                <div style="margin: 10px;">
                    <div>Please enter your username and password.</div>
                    <br/>
                    <div>Username:</div>
                    <div>
                        <input type="text" id="txtUsername" name="txtUsername" class="txt-login" value="${username}"></input>
                        <span id="spanUsername" class="hide-required">*</span>
                    </div>
                    <div>Password:</div>
                    <div>
                        <input type="password" id="txtPassword" name="txtPassword" class="txt-login" value="${password}"></input>
                        <span id="spanPassword" class="hide-required">*</span>
                    </div>
                    <div style="margin-top:5px;">
                        <input type="submit" id="btnLogin" value="Login"></input>
                    </div>
                    <br/>
                    <div>
                        <label id="lblResult"></label>
                    </div>
                </div>
            </div>           
        </form>
    </body>
</html>
