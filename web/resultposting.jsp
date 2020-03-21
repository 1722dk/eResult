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
        <title>Result Information</title>   
        <script type="text/javascript">
            $(function() {
                $('#btnSubmit').click(function() {
                    //var ok = true;
                    if ($('#ddlBatch').val() === '0') {
                        alert('Please select a batch.');
                        $('#ddlBatch').focus();
                        return false;
                    } else if ($('#ddlCourse').val() === '0') {
                        alert('Please select a course.');
                        $('#ddlCourse').focus();
                        return false;
                    } else if ($('#ddlExamType').val() === '0') {
                        alert('Please select exam type.');
                        $('#ddlExamType').focus();
                        return false;
                    }
                    return true;
                });
            });

        </script>
    </head>
    <body>
    <center>
        <form action="./ResultProcServlet" method="POST">
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
                                                </div>
                                            </div>
                                            <div id="resultInfo">
                                                <fieldset>
                                                    <legend>Result Posting</legend>
                                                    <div class="div-merger">
                                                        <div class="result-labler">
                                                            <label>Course Id:</label>                    
                                                        </div>
                                                        <div>
                                                            <label name="lblCourseId"><strong>${strCourseId}</strong></label>  
                                                            <input type="hidden" name="txtCourseId" value="${strCourseId}" />
                                                        </div>
                                                    </div>
                                                    <div class="div-merger">
                                                        <div class="result-labler">
                                                            <label>Batch No:</label>                    
                                                        </div>
                                                        <div>
                                                            <label name="lblBatchNo"><strong>${strBatchNo}</strong></label> 
                                                            <input type="hidden" name="txtBatchNo" value="${strBatchNo}" />
                                                        </div>
                                                    </div>

                                                    <div class="div-merger">
                                                        <div class="result-labler">
                                                            <label>Exam Type:</label>                   
                                                        </div>
                                                        <div>
                                                            <label name="lblExamType"><strong>${strExamType}</strong></label>
                                                            <input type="hidden" name="txtExamType" value="${strExamType}" />
                                                        </div>
                                                    </div> 
                                                    <div class="div-merger">
                                                        <div class="result-labler">
                                                            <label>Exam No:</label>                   
                                                        </div>
                                                        <div>
                                                            <label name="lblExamNo"><strong>${strExamNo}</strong></label> 
                                                            <input type="hidden" name="txtExamNo" value="${strExamNo}" />
                                                        </div>
                                                    </div>
                                                    <br/>
                                                    <table id="procResult" name="procResult" style="width:25%;">
                                                        <thead>
                                                            <tr style="background-color: #cccccc;">
                                                                <th>StudentId</th>
                                                                <th>Mark</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody style="text-align: center;">
                                                            <tr class="data">
                                                                <c:forEach items="${modelList}" var="model">
                                                                <tr>                                                                    
                                                                    <td>
                                                                        ${model.getStudentId()}
                                                                        <input type="hidden" name="txtStudents" value="${model.getStudentId()}" />
                                                                    </td> 
                                                                    <td>
                                                                        <input type="text" id="txt_${model.getStudentId()}" name="txtMarks" />
                                                                    </td>
                                                                </tr>            
                                                            </c:forEach>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    <input type="hidden" name="procResult" value="${procResult}" />
                                                    <div style="margin-top:5px; margin-left: 2px;">
                                                        <input type="submit" name="action" value="Add"/>
                                                        <input type="submit" name="action" value="Edit"/>
                                                        <input type="submit" name="action" value="Delete"/>
                                                    </div>
                                                    <div><label name="lblErrorMsg" style="color: red;">${lblErrorMsg}</label> </div>
                                                    </form>
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

