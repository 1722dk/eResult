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
        <title>Exam Information</title>        
    </head>
    <body>
    <center>
        <form action="./ExamServlet" method="POST">
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
                                            <div id="examInfo">
                                                <fieldset>
                                                    <legend>Add/Edit Exam Information</legend>

                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="txtExamId">Exam Id:</label>                    
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtExamId" name="txtExamId" value="${txtExamId}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="ddlBatch">Batch No:</label>                    
                                                        </div>
                                                        <div>
                                                            <select id="ddlBatch" name="ddlBatch" class="ddloption">
                                                                <option value="0" selected>--- Select Batch---</option>
                                                                <option value="MIT 7th">MIT 7th</option>
                                                                <option value="MIT 8th">MIT 8th</option>
                                                                <option value="MIT 9th">MIT 9th</option>                                                                
                                                                <option value="MIT 10th">MIT 10th</option>
                                                            </select>                     
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="ddlCourse">Course Id:</label>                    
                                                        </div>
                                                        <div>
                                                            <select id="ddlCourse" name="ddlCourse" class="ddloption">
                                                                <option value="0" selected>--- Select Course---</option>
                                                                <option value="MITM301">MITM301</option>
                                                                <option value="MITM302">MITM302</option>
                                                                <option value="MITM304">MITM304</option>                                                                
                                                                <option value="MITM306">MITM306</option>
                                                                <option value="MITE403">MITE403</option>
                                                                <option value="MITE404">MITE404</option>
                                                                <option value="MITE408">MITE408</option>
                                                                <option value="MITE411">MITE411</option>
                                                                <option value="MITE412">MITE412</option>
                                                                <option value="MITP421">MITP421</option>
                                                            </select>                    
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="ddlExamType">Exam Type:</label>                   
                                                        </div>
                                                        <div>
                                                            <select id="ddlExamType" name="ddlExamType" class="ddloption">
                                                                <option value="0" selected>--- Select Exam---</option>
                                                                <option value="Quiz">Quiz</option>
                                                                <option value="Assignment">Assignment</option>
                                                                <option value="Presentation">Presentation</option>
                                                                <option value="Attendance">Attendance</option>                                                                
                                                                <option value="Mid Term">Mid Term</option>
                                                                <option value="Final">Final</option>
                                                            </select>
                                                        </div>
                                                    </div>                                                    
                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="txtExamNo">Exam No:</label>                    
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtExamNo" name="txtExamNo" value="${txtExamNo}"/>
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="exam-labler">
                                                            <label for="txtExamMark">Marks:</label>                    
                                                        </div>
                                                        <div>
                                                            <input type="text" id="txtExamMark" name="txtExamMark" value="${txtExamMark}"/>                       
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
                                            <div id="examsummary" style="margin-top: 5px;">
                                                <fieldset>
                                                    <legend>Exam Summary</legend>
                                                    <table id="exmSummary" style="width:100%;">
                                                        <thead>
                                                            <tr style="background-color: #cccccc;">
                                                                <th>Id</th>
                                                                <th>Batch No</th>
                                                                <th>Course Id</th>
                                                                <th>Exam Type</th>
                                                                <th>Exam No</th>
                                                                <th>Marks</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="data">
                                                                <c:forEach items="${modelList}" var="model">
                                                                <tr>
                                                                    <td>${model.getExamId()}</td>  
                                                                    <td>${model.getBatchNo()}</td> 
                                                                    <td>${model.getCourseId()}</td> 
                                                                    <td>${model.getExamType()}</td> 
                                                                    <td>${model.getExamNo()}</td> 
                                                                    <td>${model.getExamMarks()}</td> 
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

