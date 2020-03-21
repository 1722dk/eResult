package com.me.model;

public class Student {
    private int _StudentId;
    private String _FirstName;
    private String _LastName;
    private String _BatchNo;
    private String _StdSession;
    private String _Email;
    private String _ContactNo;

    public int getStudentId() {
        return _StudentId;
    }

    public void setStudentId(int _StudentId) {
        this._StudentId = _StudentId;
    }

    public String getFirstName() {
        return _FirstName;
    }

    public void setFirstName(String _FirstName) {
        this._FirstName = _FirstName;
    }

    public String getLastName() {
        return _LastName;
    }

    public void setLastName(String _LastName) {
        this._LastName = _LastName;
    }

    public String getBatchNo() {
        return _BatchNo;
    }

    public void setBatchNo(String _BatchNo) {
        this._BatchNo = _BatchNo;
    }

    public String getStdSession() {
        return _StdSession;
    }

    public void setStdSession(String _StdSession) {
        this._StdSession = _StdSession;
    }

    public String getEmail() {
        return _Email;
    }

    public void setEmail(String _Email) {
        this._Email = _Email;
    }

    public String getContactNo() {
        return _ContactNo;
    }

    public void setContactNo(String _ContactNo) {
        this._ContactNo = _ContactNo;
    }

    public Student() {
    }
    
    public Student(int _StudentId, String _FirstName, String _LastName, String _BatchNo, String _StdSession, String _Email, String _ContactNo) {
        this._StudentId = _StudentId;
        this._FirstName = _FirstName;
        this._LastName = _LastName;
        this._BatchNo = _BatchNo;
        this._StdSession = _StdSession;
        this._Email = _Email;
        this._ContactNo = _ContactNo;
    }
}
