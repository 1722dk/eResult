<%-- 
    Document   : index
    Created on : Aug 20, 2013, 5:17:41 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Css/style-v1.css" />
        <script type="text/javascript" src="Script/Jquery/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="Script/main-app.js"></script>
        <title>Course Information</title>        
    </head>
    <body>
    <center>
        <form action="./CourseServlet" method="POST">
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
                                            <div style="margin:5px;"><a name="home" href="./home.jsp">Home</a>  
                                            </div>
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
                                            <div id="divHeader">
                                                <div style="margin-top:5px; margin-bottom: 5px;">
                                                    <input type="button" id="btnShowAddEdit" value="Hide Add/Edit"/>
                                                    <input type="button" id="btnShowSummary" value="Hide Summary"/> 
                                                    <input type="submit" name="action" id="btnViewAll" value="View All"/> 
                                                </div>
                                            </div>
                                            <div id="courseInfo">
                                                <fieldset>
                                                    <legend>Add/Edit Course Information</legend>

                                                    <div class="div-merger">
                                                        <div class="course-labler">
                                                            <label for="txtCourseId">Course Id:</label>                    
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtCourseId" name="txtCourseId" value="${txtCourseId}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="course-labler">
                                                            <label for="txtCourseCredit">Course Credit:</label>                    
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtCourseCredit" name="txtCourseCredit" value="${txtCourseCredit}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="course-labler">
                                                            <label for="txtCourseTitle">Course Title:</label>                    
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtCourseTitle" name="txtCourseTitle" style="width:420px;" value="${txtCourseTitle}"/>                       
                                                        </div>
                                                    </div>
                                                    <div style="margin-top:5px;">
                                                        <input type="submit" name="action" value="Add"/>
                                                        <input type="submit" name="action" value="Edit"/>
                                                        <input type="submit" name="action" value="Delete"/>
                                                        <input type="submit" name="action" value="Search"/>  
                                                    </div>
                                                    </form>
                                                </fieldset>
                                            </div> 
                                            <div id="coursesummary" style="margin-top: 5px;">
                                                <fieldset>
                                                    <legend>Course Summary</legend>
                                                    <table id="crsSummary" style="width:100%;">
                                                        <thead>
                                                            <tr style="background-color: #cccccc;">
                                                                <th>Course Id</th>
                                                                <th>Course Credit</th>
                                                                <th>Course Title</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="data">
                                                                <c:forEach items="${modelList}" var="model">
                                                                <tr>
                                                                    <td>${model.getCourseId()}</td> 
                                                                    <td>${model.getCourseCredit()}</td> 
                                                                    <td>${model.getCourseTitle()}</td>  
                                                                </tr>            
                                                            </c:forEach>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </fieldset>
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

