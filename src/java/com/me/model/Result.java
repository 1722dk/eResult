package com.me.model;

public class Result {
    private String _CourseId;
    private String _BatchNo;
    private String _StudentId;
    private String _ExamType;
    private String _ExamNo;
    private String _Mark;
    
    private String _Quiz;
    private String _Assignment;
    private String _Presentation;
    private String _Attendance;
    private String _MidTerm;
    private String _Final;
    private String _GradePoint;
    private String _GradePointLetter;
    private String _Total;

    public String getTotal() {
        return _Total;
    }

    public void setTotal(String _Total) {
        this._Total = _Total;
    }

    

    public String getQuiz() {
        return _Quiz;
    }

    public void setQuiz(String _Quiz) {
        this._Quiz = _Quiz;
    }

    public String getAssignment() {
        return _Assignment;
    }

    public void setAssignment(String _Assignment) {
        this._Assignment = _Assignment;
    }

    public String getPresentation() {
        return _Presentation;
    }

    public void setPresentation(String _Presentation) {
        this._Presentation = _Presentation;
    }

    public String getAttendance() {
        return _Attendance;
    }

    public void setAttendance(String _Attendance) {
        this._Attendance = _Attendance;
    }

    public String getMidTerm() {
        return _MidTerm;
    }

    public void setMidTerm(String _MidTerm) {
        this._MidTerm = _MidTerm;
    }

    public String getFinal() {
        return _Final;
    }

    public void setFinal(String _Final) {
        this._Final = _Final;
    }

    public String getGradePoint() {
        return _GradePoint;
    }

    public void setGradePoint(String _GradePoint) {
        this._GradePoint = _GradePoint;
    }

    public String getGradePointLetter() {
        return _GradePointLetter;
    }

    public void setGradePointLetter(String _GradePointLetter) {
        this._GradePointLetter = _GradePointLetter;
    }

    public String getCourseId() {
        return _CourseId;
    }

    public void setCourseId(String _CourseId) {
        this._CourseId = _CourseId;
    }

    public String getBatchNo() {
        return _BatchNo;
    }

    public void setBatchNo(String _BatchNo) {
        this._BatchNo = _BatchNo;
    }

    public String getStudentId() {
        return _StudentId;
    }

    public void setStudentId(String _StudentId) {
        this._StudentId = _StudentId;
    }

    public String getExamType() {
        return _ExamType;
    }

    public void setExamType(String _ExamType) {
        this._ExamType = _ExamType;
    }

    public String getExamNo() {
        return _ExamNo;
    }

    public void setExamNo(String _ExamNo) {
        this._ExamNo = _ExamNo;
    }

    public String getMark() {
        return _Mark;
    }

    public void setMark(String _Mark) {
        this._Mark = _Mark;
    }

    public Result() {
    }

    public Result(String _StudentId, String _ExamType) {
        this._StudentId = _StudentId;
        this._ExamType = _ExamType;
    }

    public Result(String _CourseId, String _BatchNo, String _StudentId, String _ExamType, String _Mark) {
        this._CourseId = _CourseId;
        this._BatchNo = _BatchNo;
        this._StudentId = _StudentId;
        this._ExamType = _ExamType;
        this._Mark = _Mark;
    }

    public Result(String _CourseId, String _BatchNo, String _StudentId, String _ExamType, String _ExamNo, String _Mark) {
        this._CourseId = _CourseId;
        this._BatchNo = _BatchNo;
        this._StudentId = _StudentId;
        this._ExamType = _ExamType;
        this._ExamNo = _ExamNo;
        this._Mark = _Mark;
    }
    
    
    //STUDENTID,COURSEID,BATCHNO,QUIZ,ASSIGNMENT,PRESENTATION,ATTENDANCE,MIDTERM,FINAL,GRADEPOINT,GRADPOINTLETTER
    public Result(String _StudentId, String _CourseId, String _BatchNo, String _Quiz, String _Assignment, String _Presentation, String _Attendance, String _MidTerm, String _Final, String _GradePoint, String _GradePointLetter, String _Total) {
        this._StudentId = _StudentId;
        this._CourseId = _CourseId;
        this._BatchNo = _BatchNo;
        this._Quiz = _Quiz;
        this._Assignment = _Assignment;
        this._Presentation = _Presentation;
        this._Attendance = _Attendance;
        this._MidTerm = _MidTerm;
        this._Final = _Final;
        this._GradePoint = _GradePoint;
        this._GradePointLetter = _GradePointLetter;
        this._Total=_Total;
    }
}
