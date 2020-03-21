package com.me.model;

public class Teacher {
    private String _TeacherName;
    private String _Designation;
    private String _ContactNo;
    private String _Email;

    public String getTeacherName() {
        return _TeacherName;
    }

    public void setTeacherName(String _TeacherName) {
        this._TeacherName = _TeacherName;
    }

    public String getDesignation() {
        return _Designation;
    }

    public void setDesignation(String _Designation) {
        this._Designation = _Designation;
    }

    public String getContactNo() {
        return _ContactNo;
    }

    public void setContactNo(String _ContactNo) {
        this._ContactNo = _ContactNo;
    }

    public String getEmail() {
        return _Email;
    }

    public void setEmail(String _Email) {
        this._Email = _Email;
    }

    public Teacher() {
    }

    public Teacher(String _TeacherName, String _Designation, String _ContactNo, String _Email) {
        this._TeacherName = _TeacherName;
        this._Designation = _Designation;
        this._ContactNo = _ContactNo;
        this._Email = _Email;
    }
}
