<%-- 
    Document   : home
    Created on : Aug 23, 2013, 7:34:26 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/style-v1.css" />
        <script type="text/javascript" src="Script/Jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="Script/main-app.js"></script> 
        <style type="text/css">
            html{
                background-color: #6E7F71;
                font-family: verdana,arial,times new roman;
                font-size: 14px;
            }
        </style>
    </head>
    <body>
    <center>
        <form action="./LoginServlet" method="POST">
            <div style="width:75%;">
                <table style="width:100%">
                    <tr>
                        <td style="border:1px solid white">
                            <div style="height: 100px;">
                                <img style="margin-top:1px;" src="./Image/header_image.png" width="100%" height="98" alt='Logo' />  
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="height:510px;border:1px solid white">
                            <div style="width:100%; height: 100%;">
                                <table style="width:100%; height: 100%;">
                                    <tr>
                                        <td style="vertical-align: top; background-color: whitesmoke;">
                                            <div>
                                               
                                                    <div>

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

                                                    </div>
                                              
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <td style="border:1px solid white">
                    <center>
                        <div class="copyright">Copyright © 2013 by Darkhouse Inc. All Rights Reserved. </div>
                    </center>                        
                    </td>
                    </tr>
                </table>
            </div>
    </center>
</body>
</html>
