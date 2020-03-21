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
        <title>Student Information</title>        
    </head>
    <body>
    <center>
        <form action="./StudentServlet" method="POST">
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
                                            <div id="studentInfo">
                                                <fieldset>
                                                    <legend>Add/Edit Student Information</legend>

                                                    <div class="div-merger">
                                                        <div class="labeler">
                                                            <label for="txtStudentId">Student Id:</label>
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtStudentId" name="txtStudentId" value="${txtStudentId}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="labeler">
                                                            <label for="txtFirstName">First Name:</label>
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtFirstName" name="txtFirstName" value="${txtFirstName}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="labeler">
                                                            <label for="txtLastName">Last Name:</label>
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtLastName" name="txtLastName" value="${txtLastName}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="ddlBatch">Batch No:</label>                    
                                                        </div>
                                                        <div>
                                                            <select id="ddlBatch" name="ddlBatch" class="ddloption" style="margin-left: -10px;">
                                                                <option value="0" selected>---Select Batch---</option>
                                                                <option value="MIT 7th">MIT 7th</option>
                                                                <option value="MIT 8th">MIT 8th</option>
                                                                <option value="MIT 9th">MIT 9th</option>                                                                
                                                                <option value="MIT 10th">MIT 10th</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="labeler">
                                                            <label for="txtSession">Session:</label>
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtSession" name="txtSession" value="${txtSession}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="labeler">
                                                            <label for="txtEmail">E-mail:</label>
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtEmail" name="txtEmail" value="${txtEmail}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="labeler">
                                                            <label for="txtContactNo">Contact No:</label>
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtContactNo" name="txtContactNo" value="${txtContactNo}"/>
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
                                            <div id="studentsummary" style="margin-top: 5px;">
                                                <fieldset>
                                                    <legend>Student Summary</legend>
                                                    <table id="stdSummary" style="width:100%;">
                                                        <thead>
                                                            <tr style="background-color: #cccccc;">
                                                                <th>ID</th>
                                                                <th>First Name</th>
                                                                <th>Last Name</th>
                                                                <th>Batch No</th>
                                                                <th>Session</th>
                                                                <th>E-mail</th>
                                                                <th>Contact</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="data">
                                                                <c:forEach items="${modelList}" var="model">
                                                                <tr>
                                                                    <td>${model.getStudentId()}</td>  
                                                                    <td>${model.getFirstName()}</td> 
                                                                    <td>${model.getLastName()}</td> 
                                                                    <td>${model.getBatchNo()}</td> 
                                                                    <td>${model.getStdSession()}</td>  
                                                                    <td>${model.getEmail()}</td>  
                                                                    <td>${model.getContactNo()}</td>  
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

