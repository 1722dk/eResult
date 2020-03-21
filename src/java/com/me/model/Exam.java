package com.me.model;

public class Exam {
    private int _ExamId;
    private String _BatchNo;
    private String _CourseId;
    private String _ExamType;
    private String _ExamNo;
    private String _ExamMarks; 

    public int getExamId() {
        return _ExamId;
    }

    public void setExamId(int _ExamId) {
        this._ExamId = _ExamId;
    }

    public String getBatchNo() {
        return _BatchNo;
    }

    public void setBatchNo(String _BatchNo) {
        this._BatchNo = _BatchNo;
    }

    public String getCourseId() {
        return _CourseId;
    }

    public void setCourseId(String _CourseId) {
        this._CourseId = _CourseId;
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

    public String getExamMarks() {
        return _ExamMarks;
    }

    public void setExamMarks(String _ExamMarks) {
        this._ExamMarks = _ExamMarks;
    }

    public Exam() {
    }

    public Exam(int _ExamId, String _BatchNo, String _CourseId, String _ExamType, String _ExamNo, String _ExamMarks) {
        this._ExamId = _ExamId;
        this._BatchNo = _BatchNo;
        this._CourseId = _CourseId;
        this._ExamType = _ExamType;
        this._ExamNo = _ExamNo;
        this._ExamMarks = _ExamMarks;
    }
}
