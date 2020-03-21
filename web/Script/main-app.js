
$(function() {
    initialize();
});
function initialize() {
    //Login
    //loginValidation();
    
    //Student
    activeStudentInfo();
    activeStudentSummary();
    getStudentValuesFromTableRow();
    
    //Course
    activeCourseInfo();
    activeCourseSummary();
    getCourseValuesFromTableRow();
    
    //Exam
    activeExamInfo();
    activeExamSummary();
    getExamValuesFromTableRow();
    
    //Teacher
    activeTeacherInfo();
    activeTeacherSummary();
    getTeacherValuesFromTableRow();
    
    getHoberOnResultTableRow();
}

function loginValidation() {
    $("#btnLogin").click(function() {
        if ($("#txtUsername").val() === "" && $("#txtPassword").val() === "") {
            $("#spanUsername").removeClass("hide-required");
            $("#spanUsername").addClass("show-required");
            $("#spanPassword").removeClass("hide-required");
            $("#spanPassword").addClass("show-required");
            $("#txtUsername").focus();
            return;
        }
        if ($("#txtUsername").val() === "") {
            $("#spanUsername").removeClass("hide-required");
            $("#spanUsername").addClass("show-required");
            $("#txtUsername").focus();
            return;
        } else {
            $("#spanUsername").removeClass("show-required");
            $("#spanUsername").addClass("hide-required");
        }
        if ($("#txtPassword").val() === "") {
            $("#spanPassword").removeClass("hide-required");
            $("#spanPassword").addClass("show-required");
            $("#txtPassword").focus();
            return;
        } else {
            $("#spanPassword").removeClass("show-required");
            $("#spanPassword").addClass("hide-required");
        }
        try {
            $("#lblResult").html("Your Username & Password is - " + $("#txtUsername").val() + " " + $("#txtPassword").val());
        } catch (e) {
        }
    });
}

//Student Section
function activeStudentInfo() {
    $("#btnShowAddEdit").click(function() {
        $("#studentInfo").toggle("slow", function() {
            if ($("#btnShowAddEdit").val() === "Hide Add/Edit") {
                $("#btnShowAddEdit").val("Show Add/Edit");
            } else {
                $("#btnShowAddEdit").val("Hide Add/Edit");
            }
        });
        //$("#studentInfo").removeClass("hideblock");
        //$("#studentInfo").addClass("showblock");
    });
}
function activeStudentSummary() {
    $("#btnShowSummary").click(function() {
        $("#studentsummary").toggle("slow", function() {
            if ($("#btnShowSummary").val() === "Hide Summary") {
                $("#btnShowSummary").val("Show Summary");
            } else {
                $("#btnShowSummary").val("Hide Summary");
            }
        });
        //$("#studentsummary").removeClass("hideblock");
        //$("#studentsummary").addClass("showblock");
    });
}
function getStudentValuesFromTableRow() {
    var tr = $('#stdSummary').find('tr');
    tr.bind('click', function(event) {
        tr.removeClass('row-highlight');
        var tds = $(this).addClass('row-highlight').find('td');
        $.each(tds, function(index, item) {
            if (index === 0) {
                $("#txtStudentId").val(item.innerHTML);                
                $("#txtStudentId").attr('readonly', true); //attr('disabled', true);
            } else if (index === 1) {
                $("#txtFirstName").val(item.innerHTML);
            } else if (index === 2) {
                $("#txtLastName").val(item.innerHTML);
            } else if (index === 3) {
                $("#ddlBatch").val(item.innerHTML).prop('selected',true);
            } else if (index === 4) {
                $("#txtSession").val(item.innerHTML);
            } else if (index === 5) {
                $("#txtEmail").val(item.innerHTML);
            } else if (index === 6) {
                $("#txtContactNo").val(item.innerHTML);
            }
            //values = values + 'td' + (index + 1) + ':' + item.innerHTML + '<br/>';
        });
    });
    tr.hover(
            function() {  // mouseover
                $(this).addClass('row-highlight');
            },
            function() {  // mouseout
                $(this).removeClass('row-highlight');
            }
    );
}

//Course Section
function activeCourseInfo() {
    $("#btnShowAddEdit").click(function() {
        $("#courseInfo").toggle("slow", function() {
            if ($("#btnShowAddEdit").val() === "Hide Add/Edit") {
                $("#btnShowAddEdit").val("Show Add/Edit");
            } else {
                $("#btnShowAddEdit").val("Hide Add/Edit");
            }
        });
        //$("#studentInfo").removeClass("hideblock");
        //$("#studentInfo").addClass("showblock");
    });
}
function activeCourseSummary() {
    $("#btnShowSummary").click(function() {
        $("#coursesummary").toggle("slow", function() {
            if ($("#btnShowSummary").val() === "Hide Summary") {
                $("#btnShowSummary").val("Show Summary");
            } else {
                $("#btnShowSummary").val("Hide Summary");
            }
        });
        //$("#studentsummary").removeClass("hideblock");
        //$("#studentsummary").addClass("showblock");
    });
}
function getCourseValuesFromTableRow() {
    var tr = $('#crsSummary').find('tr');
    tr.bind('click', function(event) {
        tr.removeClass('row-highlight');
        var tds = $(this).addClass('row-highlight').find('td');
        $.each(tds, function(index, item) {
            if (index === 0) {
                $("#txtCourseId").val(item.innerHTML);
                $("#txtCourseId").attr('readonly', true); //attr('disabled', true);                
            } else if (index === 1) {
                $("#txtCourseCredit").val(item.innerHTML);
            } else if (index === 2) {
                $("#txtCourseTitle").val(item.innerHTML);
            } 
            //values = values + 'td' + (index + 1) + ':' + item.innerHTML + '<br/>';
        });
    });
    tr.hover(
            function() {  // mouseover
                $(this).addClass('row-highlight');
            },
            function() {  // mouseout
                $(this).removeClass('row-highlight');
            }
    );
}

//Exam Section
function activeExamInfo() {
    $("#btnShowAddEdit").click(function() {
        $("#examInfo").toggle("slow", function() {
            if ($("#btnShowAddEdit").val() === "Hide Add/Edit") {
                $("#btnShowAddEdit").val("Show Add/Edit");
            } else {
                $("#btnShowAddEdit").val("Hide Add/Edit");
            }
        });
        //$("#studentInfo").removeClass("hideblock");
        //$("#studentInfo").addClass("showblock");
    });
}
function activeExamSummary() {
    $("#btnShowSummary").click(function() {
        $("#examsummary").toggle("slow", function() {
            if ($("#btnShowSummary").val() === "Hide Summary") {
                $("#btnShowSummary").val("Show Summary");
            } else {
                $("#btnShowSummary").val("Hide Summary");
            }
        });
        //$("#studentsummary").removeClass("hideblock");
        //$("#studentsummary").addClass("showblock");
    });
}
function getExamValuesFromTableRow() {
    var tr = $('#exmSummary').find('tr');
    tr.bind('click', function(event) {
        tr.removeClass('row-highlight');
        var tds = $(this).addClass('row-highlight').find('td');
        $.each(tds, function(index, item) {
            if (index === 0) {
                $("#txtExamId").val(item.innerHTML);
                $("#txtExamId").attr('readonly', true); //attr('disabled', true);                
            } else if (index === 1) {
                $("#ddlBatch").val(item.innerHTML).prop('selected',true);
            } else if (index === 2) {
                $("#ddlCourse").val(item.innerHTML).prop('selected',true);
                //$("#txtCourseId").val(item.innerHTML);
            } else if (index === 3) {
                $("#ddlExamType").val(item.innerHTML).prop('selected',true);
                //$("#txtExamType").val(item.innerHTML);
            } else if (index === 4) {
                $("#txtExamNo").val(item.innerHTML);
            } else if (index === 5) {
                $("#txtExamMark").val(item.innerHTML);
            } 
            //values = values + 'td' + (index + 1) + ':' + item.innerHTML + '<br/>';
        });
    });
    tr.hover(
            function() {  // mouseover
                $(this).addClass('row-highlight');
            },
            function() {  // mouseout
                $(this).removeClass('row-highlight');
            }
    );
}

//Teacher Section
function activeTeacherInfo() {
    $("#btnShowAddEdit").click(function() {
        $("#teacherInfo").toggle("slow", function() {
            if ($("#btnShowAddEdit").val() === "Hide Add/Edit") {
                $("#btnShowAddEdit").val("Show Add/Edit");
            } else {
                $("#btnShowAddEdit").val("Hide Add/Edit");
            }
        });
        //$("#studentInfo").removeClass("hideblock");
        //$("#studentInfo").addClass("showblock");
    });
}
function activeTeacherSummary() {
    $("#btnShowSummary").click(function() {
        $("#teachersummary").toggle("slow", function() {
            if ($("#btnShowSummary").val() === "Hide Summary") {
                $("#btnShowSummary").val("Show Summary");
            } else {
                $("#btnShowSummary").val("Hide Summary");
            }
        });
        //$("#studentsummary").removeClass("hideblock");
        //$("#studentsummary").addClass("showblock");
    });
}
function getTeacherValuesFromTableRow() {
    var tr = $('#tcharSummary').find('tr');
    tr.bind('click', function(event) {
        tr.removeClass('row-highlight');
        var tds = $(this).addClass('row-highlight').find('td');
        $.each(tds, function(index, item) {
            if (index === 0) {
                $("#txtTeacherName").val(item.innerHTML);
                $("#txtTeacherName").attr('readonly', true); //attr('disabled', true);                
            } else if (index === 1) {
                $("#txtDesignation").val(item.innerHTML);
            } else if (index === 2) {
                $("#txtContactNo").val(item.innerHTML);
            } else if (index === 3) {
                $("#txtEmail").val(item.innerHTML);
            } 
            //values = values + 'td' + (index + 1) + ':' + item.innerHTML + '<br/>';
        });
    });
    tr.hover(
            function() {  // mouseover
                $(this).addClass('row-highlight');
            },
            function() {  // mouseout
                $(this).removeClass('row-highlight');
            }
    );
}

function getHoberOnResultTableRow() {
    var tr = $('#procResult').find('tr');    
    tr.hover(
            function() {  // mouseover
                $(this).addClass('row-highlight');
            },
            function() {  // mouseout
                $(this).removeClass('row-highlight');
            }
    );
}



