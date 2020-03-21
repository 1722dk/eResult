package com.me.model;

public class Course {
    private String _CourseId;
    private String _CourseCredit;
    private String _CourseTitle;    

    public String getCourseId() {
        return _CourseId;
    }

    public void setCourseId(String _CourseId) {
        this._CourseId = _CourseId;
    }

    public String getCourseCredit() {
        return _CourseCredit;
    }

    public void setCourseCredit(String _CourseCredit) {
        this._CourseCredit = _CourseCredit;
    }

    public String getCourseTitle() {
        return _CourseTitle;
    }

    public void setCourseTitle(String _CourseTitle) {
        this._CourseTitle = _CourseTitle;
    }

    public Course() {
    }

    public Course(String _CourseId, String _CourseCredit, String _CourseTitle) {
        this._CourseId = _CourseId;
        this._CourseCredit = _CourseCredit;
        this._CourseTitle = _CourseTitle;
    }
}
