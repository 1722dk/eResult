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
        <form action="../HomeServlet" method="POST"></form>
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
                                    <td style="vertical-align: top;width:200px; background-color: InactiveCaption;">
                                        <div style="margin:5px;"><a name="studentinfo" href="./studentinfo.jsp">Student Information</a>  
                                            </div>
                                            <div style="margin:5px;"><a name="teacherinfo" href="./teacherinfo.jsp">Teacher Information</a>
                                            </div>
                                            <div style="margin:5px;"><a name="courseinfo" href="./courseinfo.jsp">Course Information</a>
                                            </div>
                                            <div style="margin:5px;"><a name="examinfo" href="./examinfo.jsp">Exam Information
                                            </div>
                                            <div style="margin:5px;"><a name="resultinfo" href="./resultinfo.jsp">Result Information</a>
                                            </div>
                                        <br/>
                                            <div style="margin:5px;"><a name="logout" href="./login.jsp">Logout</a>
                                            </div>
                                    </td>
                                    <td style="vertical-align: top; background-color: whitesmoke;">
                                        <div>
                                            <center>
                                                <div>
                                                    <h1>Welcome to MIT e-Result Application</h1>
                                                    <div style="margin-top:12px; text-align: left; margin-left: 27%;">To Build This Application Following Tools and Technology are used - <br/>
                                                        <ul>
                                                            <li>
                                                                NetBeans IDE-7.3.1
                                                            </li>
                                                            <li>
                                                                Web Server - Apache Tomcat-7.0
                                                            </li>
                                                            <li>
                                                                Database - Oracle 11G Express Edition
                                                            </li>                                                             
                                                            <li>
                                                                Java Servlet
                                                            </li>  
                                                            <li>
                                                                JSP and
                                                            </li>
                                                            <li>
                                                                J2EE
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </center>
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
