package com.me.dao;

import com.me.model.Result;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResultDAO {

    private JDBCContext _BaseDAO = new JDBCContext();
    private Connection _Connection = null;
    private PreparedStatement _PreparedStatement = null;
    private Statement _Statement = null;
    private ResultSet _ResultSet = null;
    private String _SQL = "";

    public int saveResult(Result result, String action) throws SQLException, ClassNotFoundException {
        int rslt = -1;
        try {
            _SQL = getQueryString(result, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            rslt = _PreparedStatement.executeUpdate();
            if (rslt > 0) {
                _Connection.commit();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_PreparedStatement != null) {
                _PreparedStatement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return rslt;
    }

    public int executeUpdate(String query) throws SQLException, ClassNotFoundException {
        int rslt = -1;
        try {
            //_SQL = getQueryString(result, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(query);
            rslt = _PreparedStatement.executeUpdate();
            if (rslt > 0) {
                _Connection.commit();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_PreparedStatement != null) {
                _PreparedStatement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return rslt;
    }
    public void executeCallable(Result result) throws SQLException, ClassNotFoundException {
        try {
            _Connection = _BaseDAO.getConnection();
            CallableStatement cstmt = _Connection.prepareCall("{call GETFINALRESULT(?, ?)}");
            cstmt.setString("COURSEID", result.getCourseId());
            cstmt.setString("BATCHNO", result.getBatchNo());
            ResultSet rs = cstmt.executeQuery();
            rs.close();
            cstmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {            
            if (_Connection != null) {
                _Connection.close();
            }
        }
    }

    public ArrayList<Result> getAllResultList() throws SQLException, ClassNotFoundException {
        ArrayList<Result> resultList = new ArrayList<Result>();
        try {
            _SQL = "SELECT * FROM RESULT ORDER BY STUDENTID ASC";
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            Result result;
            while (_ResultSet.next()) {
                result = new Result(
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("StudentId"),
                        _ResultSet.getString("ExamType"),
                        _ResultSet.getString("Mark"));
                resultList.add(result);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_ResultSet != null) {
                _ResultSet.close();
            }
            if (_PreparedStatement != null) {
                _PreparedStatement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return resultList;
    }

    public ArrayList<Result> getAllResultList(Result result, String action) throws SQLException, ClassNotFoundException {
        ArrayList<Result> resultList = new ArrayList<Result>();
        try {
            _SQL = getQueryString(result, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            //Result result = null;
            while (_ResultSet.next()) {
                result = new Result(
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("StudentId"),
                        _ResultSet.getString("ExamType"),
                        _ResultSet.getString("Mark"));
                resultList.add(result);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_ResultSet != null) {
                _ResultSet.close();
            }
            if (_PreparedStatement != null) {
                _PreparedStatement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return resultList;
    }

    public ArrayList<Result> getFinalResultList(Result result, String action) throws SQLException, ClassNotFoundException {
        ArrayList<Result> resultList = new ArrayList<Result>();
        try {
            this.executeCallable(result);
            _SQL = getFinalSQL();
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            //Result result = null;
            //STUDENTID,COURSEID,BATCHNO,QUIZ,ASSIGNMENT,PRESENTATION,ATTENDANCE,MIDTERM,FINAL,GRADEPOINT,GRADPOINTLETTER
            while (_ResultSet.next()) {
                result = new Result(
                        _ResultSet.getString("STUDENTID"),
                        _ResultSet.getString("COURSEID"),
                        _ResultSet.getString("BATCHNO"),
                        _ResultSet.getString("QUIZ"),
                        _ResultSet.getString("ASSIGNMENT"),
                        _ResultSet.getString("PRESENTATION"),
                        _ResultSet.getString("ATTENDANCE"),
                        _ResultSet.getString("MIDTERM"),
                        _ResultSet.getString("FINAL"),
                        _ResultSet.getString("GRADEPOINT"),
                        _ResultSet.getString("GRADPOINTLETTER"),
                       _ResultSet.getString("TOTAL"));
                resultList.add(result);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_ResultSet != null) {
                _ResultSet.close();
            }
            if (_PreparedStatement != null) {
                _PreparedStatement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return resultList;
    }

    public Result getResult(String query) throws SQLException, ClassNotFoundException {
        Result result = null;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                result = new Result(
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("StudentId"),
                        _ResultSet.getString("ExamType"),
                        _ResultSet.getString("Mark"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_ResultSet != null) {
                _ResultSet.close();
            }
            if (_Statement != null) {
                _Statement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return result;
    }

    public String getResultId(String query) throws SQLException, ClassNotFoundException {
        String result = "";
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                result = _ResultSet.getString("ResultId");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_ResultSet != null) {
                _ResultSet.close();
            }
            if (_Statement != null) {
                _Statement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return result;
    }

    public ArrayList<Result> getStudentList(Result result, String action) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT DISTINCT student.studentid,"
                + "(exam.examtype || exam.examno || '(' ||exam.exammark || ')') AS examtype"
                + " FROM EXAM"
                + " INNER JOIN COURSE ON exam.courseid =course.courseid"
                + " INNER JOIN STUDENT ON exam.batchno =student.batchno"
                + " WHERE course.courseid='" + result.getCourseId() + "'"
                + " AND student.batchno='" + result.getBatchNo() + "'"
                + " AND exam.examtype='" + result.getExamType() + "'"
                + " AND exam.examno='" + result.getExamNo() + "'"
                + " ORDER BY student.studentid ASC");
        ArrayList<Result> resultList = new ArrayList<Result>();
        try {
            _SQL = sb.toString();
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            //Result result = null;
            while (_ResultSet.next()) {
                result = new Result(
                        _ResultSet.getString("StudentId"),
                        _ResultSet.getString("ExamType"));
                resultList.add(result);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_ResultSet != null) {
                _ResultSet.close();
            }
            if (_PreparedStatement != null) {
                _PreparedStatement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return resultList;
    }

    public String getQueryString(Result result, String action) {
        //StringBuilder sb = new StringBuilder();
        String strTable = "";
        if (result != null) {
            if ("QUIZ".equalsIgnoreCase(result.getExamType())) {
                strTable = "QUIZ";
            } else if ("ASSIGNMENT".equalsIgnoreCase(result.getExamType())) {
                strTable = "ASSIGNMENT";
            } else if ("ATTENDANCE".equalsIgnoreCase(result.getExamType())) {
                strTable = "ATTENDANCE";
            } else if ("ASSIGNMENT".equalsIgnoreCase(result.getExamType())) {
                strTable = "ASSIGNMENT";
            } else if ("MID TERM".equalsIgnoreCase(result.getExamType())) {
                strTable = "MIDTERM";
            } else if ("FINAL".equalsIgnoreCase(result.getExamType())) {
                strTable = "FINAL";
            }
        }
        String sql = "";
        if (action != null) {
            if ("Add".equalsIgnoreCase(action)) {
                sql = "INSERT INTO " + strTable + " VALUES("
                        + "'" + result.getCourseId() + "',"
                        + "'" + result.getBatchNo() + "',"
                        + "'" + result.getStudentId() + "',"
                        + "'" + result.getMark() + "')";

            } else if ("Edit".equalsIgnoreCase(action)) {
                sql = "UPDATE " + strTable + ""
                        + " SET Mark='" + result.getMark() + "'"
                        + " WHERE CourseId='" + result.getCourseId() + "'"
                        + " ANd BatchNo='" + result.getBatchNo() + "'"
                        + " ANd StudentId='" + result.getStudentId() + "'";

            } else if ("Delete".equalsIgnoreCase(action)) {
                sql = "DELETE FROM " + strTable + ""
                        + " WHERE CourseId='" + result.getCourseId() + "'"
                        + " ANd BatchNo='" + result.getBatchNo() + "'"
                        + " ANd StudentId='" + result.getStudentId() + "'";
            }
        } else {
            sql = "SELECT * FROM " + strTable;
        }
        return sql;
    }

    public String getFinalSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT * FROM FINALRESULT ");
        return sb.toString();
    }

    public String getInitFinalSQL(Result result, String action) {
        StringBuilder sb = new StringBuilder();
        sb.append(" DELETE FROM TEMPMAIN ");
        sb.append(" DELETE FROM TEMPQUIZ ");
        sb.append(" DELETE FROM TEMPASSIGNMENT ");
        sb.append(" DELETE FROM TEMPPRESENTATION ");
        sb.append(" DELETE FROM TEMPATTENDANCE ");
        sb.append(" DELETE FROM TEMPMIDTERM ");
        sb.append(" DELETE FROM TEMPFINAL ");
        sb.append(" DELETE FROM TEMPGRADE ");
        sb.append(" DELETE FROM FINALRESULT ");

        sb.append(" INSERT INTO TEMPMAIN(STUDENTID,COURSEID,BATCHNO) "
                + " SELECT DISTINCT student.studentid,exam.courseid,exam.batchno "
                + " FROM EXAM "
                + " INNER JOIN COURSE ON exam.courseid =course.courseid "
                + " INNER JOIN STUDENT ON exam.batchno =student.batchno "
                + " WHERE course.courseid='" + result.getCourseId() + "' AND student.batchno='" + result.getBatchNo() + "' "
                + " ORDER BY student.studentid ASC ");

        sb.append(" INSERT INTO TEMPQUIZ(COURSEID,BATCHNO,STUDENTID,AVGMARK) "
                + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGMARK "
                + " FROM QUIZ GROUP BY COURSEID,BATCHNO,STUDENTID "
                + " ORDER BY STUDENTID ASC ");

        sb.append(" INSERT INTO TEMPASSIGNMENT(COURSEID,BATCHNO,STUDENTID,AVGASSIGNMENT) "
                + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGASSIGNMENT "
                + " FROM ASSIGNMENT GROUP BY COURSEID,BATCHNO,STUDENTID "
                + " ORDER BY STUDENTID ASC ");

        sb.append(" INSERT INTO TEMPPRESENTATION(COURSEID,BATCHNO,STUDENTID,AVGPRESENTATION) "
                + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGPRESENTATION FROM PRESENTATION "
                + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                + " ORDER BY STUDENTID ASC ");

        sb.append(" INSERT INTO TEMPATTENDANCE(COURSEID,BATCHNO,STUDENTID,AVGATTENDANCE) "
                + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGATTENDANCE "
                + " FROM ATTENDANCE GROUP BY COURSEID,BATCHNO,STUDENTID "
                + " ORDER BY STUDENTID ASC ");

        sb.append(" INSERT INTO TEMPMIDTERM(COURSEID,BATCHNO,STUDENTID,AVGMIDTERM) "
                + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGMIDTERM "
                + " FROM MIDTERM GROUP BY COURSEID,BATCHNO,STUDENTID "
                + " ORDER BY STUDENTID ASC ");

        sb.append(" INSERT INTO TEMPFINAL(COURSEID,BATCHNO,STUDENTID,AVGFINAL) "
                + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGFINAL "
                + " FROM FINAL GROUP BY COURSEID,BATCHNO,STUDENTID "
                + " ORDER BY STUDENTID ASC ");

        sb.append(" INSERT INTO FINALRESULT (STUDENTID,COURSEID,BATCHNO,QUIZ,ASSIGNMENT,PRESENTATION,ATTENDANCE,MIDTERM,FINAL,GRADEPOINT,GRADPOINTLETTER) "
                + " SELECT STUDENTID,COURSEID,BATCHNO,'0','0','0','0','0','0','0','' "
                + " FROM TEMPMAIN ");

        sb.append(" UPDATE FINALRESULT "
                + " SET QUIZ = (SELECT TEMPQUIZ.AVGMARK "
                + " FROM TEMPQUIZ "
                + " WHERE TEMPQUIZ.STUDENTID = FINALRESULT.STUDENTID AND TEMPQUIZ.COURSEID='" + result.getCourseId() + "' AND TEMPQUIZ.BATCHNO='" + result.getBatchNo() + "') "
                + " WHERE EXISTS (SELECT TEMPQUIZ.AVGMARK FROM TEMPQUIZ WHERE TEMPQUIZ.STUDENTID = FINALRESULT.STUDENTID AND TEMPQUIZ.COURSEID='" + result.getCourseId() + "' AND TEMPQUIZ.BATCHNO='" + result.getBatchNo() + "') ");

        sb.append(" UPDATE FINALRESULT SET ASSIGNMENT = (SELECT TEMPASSIGNMENT.AVGASSIGNMENT FROM TEMPASSIGNMENT "
                + " WHERE TEMPASSIGNMENT.STUDENTID = FINALRESULT.STUDENTID AND TEMPASSIGNMENT.COURSEID='" + result.getCourseId() + "' AND TEMPASSIGNMENT.BATCHNO='" + result.getBatchNo() + "') "
                + " WHERE EXISTS (SELECT TEMPASSIGNMENT.AVGASSIGNMENT "
                + " FROM TEMPASSIGNMENT "
                + " WHERE TEMPASSIGNMENT.STUDENTID = FINALRESULT.STUDENTID AND TEMPASSIGNMENT.COURSEID='" + result.getCourseId() + "' AND TEMPASSIGNMENT.BATCHNO='" + result.getBatchNo() + "') ");

        sb.append(" UPDATE FINALRESULT SET PRESENTATION = (SELECT TEMPPRESENTATION.AVGPRESENTATION FROM TEMPPRESENTATION "
                + " WHERE TEMPPRESENTATION.STUDENTID = FINALRESULT.STUDENTID AND TEMPPRESENTATION.COURSEID='" + result.getCourseId() + "' AND TEMPPRESENTATION.BATCHNO='" + result.getBatchNo() + "') "
                + " WHERE EXISTS (SELECT TEMPPRESENTATION.AVGPRESENTATION FROM TEMPPRESENTATION "
                + " WHERE TEMPPRESENTATION.STUDENTID = FINALRESULT.STUDENTID AND TEMPPRESENTATION.COURSEID='" + result.getCourseId() + "' AND TEMPPRESENTATION.BATCHNO='" + result.getBatchNo() + "') ");

        sb.append(" UPDATE FINALRESULT SET ATTENDANCE = (SELECT TEMPATTENDANCE.AVGATTENDANCE FROM TEMPATTENDANCE "
                + " WHERE TEMPATTENDANCE.STUDENTID = FINALRESULT.STUDENTID AND TEMPATTENDANCE.COURSEID='" + result.getCourseId() + "' AND TEMPATTENDANCE.BATCHNO='" + result.getBatchNo() + "') "
                + " WHERE EXISTS (SELECT TEMPATTENDANCE.AVGATTENDANCE FROM TEMPATTENDANCE "
                + " WHERE TEMPATTENDANCE.STUDENTID = FINALRESULT.STUDENTID AND TEMPATTENDANCE.COURSEID='" + result.getCourseId() + "' AND TEMPATTENDANCE.BATCHNO='" + result.getBatchNo() + "') ");

        sb.append(" UPDATE FINALRESULT SET MIDTERM = (SELECT TEMPMIDTERM.AVGMIDTERM FROM TEMPMIDTERM "
                + " WHERE TEMPMIDTERM.STUDENTID = FINALRESULT.STUDENTID AND TEMPMIDTERM.COURSEID='" + result.getCourseId() + "' AND TEMPMIDTERM.BATCHNO='" + result.getBatchNo() + "') "
                + " WHERE EXISTS (SELECT TEMPMIDTERM.AVGMIDTERM FROM TEMPMIDTERM "
                + " WHERE TEMPMIDTERM.STUDENTID = FINALRESULT.STUDENTID AND TEMPMIDTERM.COURSEID='" + result.getCourseId() + "' AND TEMPMIDTERM.BATCHNO='" + result.getBatchNo() + "') ");

        sb.append(" UPDATE FINALRESULT SET FINAL = (SELECT TEMPFINAL.AVGFINAL FROM TEMPFINAL "
                + " WHERE TEMPFINAL.STUDENTID = FINALRESULT.STUDENTID AND TEMPFINAL.COURSEID='" + result.getCourseId() + "' AND TEMPFINAL.BATCHNO='" + result.getBatchNo() + "') "
                + " WHERE EXISTS (SELECT TEMPFINAL.AVGFINAL FROM TEMPFINAL "
                + " WHERE TEMPFINAL.STUDENTID = FINALRESULT.STUDENTID AND TEMPFINAL.COURSEID='" + result.getCourseId() + "' AND TEMPFINAL.BATCHNO='" + result.getBatchNo() + "') ");

        sb.append(" INSERT INTO TEMPGRADE(STUDENTID,COURSEID,BATCHNO,TOTALMARK) "
                + " SELECT STUDENTID,COURSEID,BATCHNO,SUM(QUIZ)+SUM(ASSIGNMENT)+SUM(PRESENTATION)+SUM(ATTENDANCE)+SUM(MIDTERM)+SUM(FINAL) "
                + " FROM FINALRESULT "
                + " GROUP BY STUDENTID,COURSEID,BATCHNO ");

        return sb.toString();
    }

    public ArrayList<String> getQueryStringForFinalResult(Result result, String action) {
        //StringBuilder sb = new StringBuilder();
        ArrayList<String> queryList = new ArrayList<String>();
        if (result != null) {
            //DELET ALL TEMP TABLES FIRST
            queryList.add(" TRUNCATE TABLE TEMPMAIN ");
            queryList.add(" TRUNCATE TABLE TEMPQUIZ ");
            queryList.add(" TRUNCATE TABLE TEMPASSIGNMENT ");
            queryList.add(" TRUNCATE TABLE TEMPPRESENTATION ");
            queryList.add(" TRUNCATE TABLE TEMPATTENDANCE ");
            queryList.add(" TRUNCATE TABLE TEMPMIDTERM ");
            queryList.add(" TRUNCATE TABLE TEMPFINAL ");
            queryList.add(" TRUNCATE TABLE TEMPGRADE ");
            queryList.add(" TRUNCATE TABLE FINALRESULT ");
            //queryList.add("TRUNCATE TABLE FINALRESULT ");

            //ROOT DATA
            queryList.add(" INSERT INTO TEMPMAIN(STUDENTID,COURSEID,BATCHNO) "
                    + " SELECT DISTINCT student.studentid,exam.courseid,exam.batchno "
                    + " FROM EXAM "
                    + " INNER JOIN COURSE ON exam.courseid =course.courseid "
                    + " INNER JOIN STUDENT ON exam.batchno =student.batchno "
                    + " WHERE course.courseid='" + result.getCourseId() + "' "
                    + " AND student.batchno='" + result.getBatchNo() + "' "
                    + " ORDER BY student.studentid ASC ");

            //QUIZ PART
            queryList.add(" INSERT INTO TEMPQUIZ(COURSEID,BATCHNO,STUDENTID,AVGMARK) "
                    + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGMARK "
                    + " FROM QUIZ "
                    + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                    + " ORDER BY STUDENTID ASC ");

            //ASSIGNMENT PART
            queryList.add(" INSERT INTO TEMPASSIGNMENT(COURSEID,BATCHNO,STUDENTID,AVGASSIGNMENT) "
                    + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGASSIGNMENT "
                    + " FROM ASSIGNMENT "
                    + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                    + " ORDER BY STUDENTID ASC ");

            //PRESENTATION PART
            queryList.add(" INSERT INTO TEMPPRESENTATION(COURSEID,BATCHNO,STUDENTID,AVGPRESENTATION) "
                    + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGPRESENTATION "
                    + " FROM PRESENTATION "
                    + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                    + " ORDER BY STUDENTID ASC ");

            //ATTENDANCE PART
            queryList.add(" INSERT INTO TEMPATTENDANCE(COURSEID,BATCHNO,STUDENTID,AVGATTENDANCE) "
                    + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGATTENDANCE "
                    + " FROM ATTENDANCE "
                    + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                    + " ORDER BY STUDENTID ASC ");

            //MIDTERM PART
            queryList.add(" INSERT INTO TEMPMIDTERM(COURSEID,BATCHNO,STUDENTID,AVGMIDTERM) "
                    + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGMIDTERM "
                    + " FROM MIDTERM "
                    + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                    + " ORDER BY STUDENTID ASC ");

            //FINAL PART
            queryList.add(" INSERT INTO TEMPFINAL(COURSEID,BATCHNO,STUDENTID,AVGFINAL) "
                    + " SELECT COURSEID,BATCHNO,STUDENTID,AVG(MARK) AS AVGFINAL "
                    + " FROM FINAL "
                    + " GROUP BY COURSEID,BATCHNO,STUDENTID "
                    + " ORDER BY STUDENTID ASC ");

            //INSERT DATA TO FINAL RESULT PROCESSING
            queryList.add(" INSERT INTO FINALRESULT ("
                    + "STUDENTID,COURSEID,BATCHNO,QUIZ,ASSIGNMENT,PRESENTATION,ATTENDANCE,MIDTERM,FINAL,GRADEPOINT,GRADPOINTLETTER) "
                    + " SELECT STUDENTID,COURSEID,BATCHNO,'0','0','0','0','0','0','0','' "
                    + " FROM TEMPMAIN ");
            //UPDATE FROM TEMPQUIZ TABLE
            queryList.add(" UPDATE FINALRESULT "
                    + " SET QUIZ = (SELECT TEMPQUIZ.AVGMARK "
                    + " FROM TEMPQUIZ "
                    + " WHERE TEMPQUIZ.STUDENTID = FINALRESULT.STUDENTID AND TEMPQUIZ.COURSEID='" + result.getCourseId() + "' AND TEMPQUIZ.BATCHNO='" + result.getBatchNo() + "') "
                    + " WHERE EXISTS (SELECT TEMPQUIZ.AVGMARK "
                    + " FROM TEMPQUIZ "
                    + " WHERE TEMPQUIZ.STUDENTID = FINALRESULT.STUDENTID AND TEMPQUIZ.COURSEID='" + result.getCourseId() + "' AND TEMPQUIZ.BATCHNO='" + result.getBatchNo() + "') ");

            //UPDATE FROM TEMPASSIGNMENT TABLE
            queryList.add(" UPDATE FINALRESULT "
                    + " SET ASSIGNMENT = (SELECT TEMPASSIGNMENT.AVGASSIGNMENT "
                    + " FROM TEMPASSIGNMENT "
                    + " WHERE TEMPASSIGNMENT.STUDENTID = FINALRESULT.STUDENTID AND TEMPASSIGNMENT.COURSEID='" + result.getCourseId() + "' AND TEMPASSIGNMENT.BATCHNO='" + result.getBatchNo() + "') "
                    + " WHERE EXISTS (SELECT TEMPASSIGNMENT.AVGASSIGNMENT "
                    + " FROM TEMPASSIGNMENT "
                    + " WHERE TEMPASSIGNMENT.STUDENTID = FINALRESULT.STUDENTID AND TEMPASSIGNMENT.COURSEID='" + result.getCourseId() + "' AND TEMPASSIGNMENT.BATCHNO='" + result.getBatchNo() + "') ");
            //UPDATE FROM TEMPPRESENTATION TABLE
            queryList.add(" UPDATE FINALRESULT "
                    + " SET PRESENTATION = (SELECT TEMPPRESENTATION.AVGPRESENTATION "
                    + " FROM TEMPPRESENTATION "
                    + " WHERE TEMPPRESENTATION.STUDENTID = FINALRESULT.STUDENTID AND TEMPPRESENTATION.COURSEID='" + result.getCourseId() + "' AND TEMPPRESENTATION.BATCHNO='" + result.getBatchNo() + "') "
                    + " WHERE EXISTS (SELECT TEMPPRESENTATION.AVGPRESENTATION "
                    + " FROM TEMPPRESENTATION "
                    + " WHERE TEMPPRESENTATION.STUDENTID = FINALRESULT.STUDENTID AND TEMPPRESENTATION.COURSEID='" + result.getCourseId() + "' AND TEMPPRESENTATION.BATCHNO='" + result.getBatchNo() + "') ");

            //UPDATE FROM TEMPATTENDANCE TABLE
            queryList.add(" UPDATE FINALRESULT "
                    + " SET ATTENDANCE = (SELECT TEMPATTENDANCE.AVGATTENDANCE "
                    + " FROM TEMPATTENDANCE "
                    + " WHERE TEMPATTENDANCE.STUDENTID = FINALRESULT.STUDENTID AND TEMPATTENDANCE.COURSEID='" + result.getCourseId() + "' AND TEMPATTENDANCE.BATCHNO='" + result.getBatchNo() + "') "
                    + " WHERE EXISTS (SELECT TEMPATTENDANCE.AVGATTENDANCE "
                    + " FROM TEMPATTENDANCE "
                    + " WHERE TEMPATTENDANCE.STUDENTID = FINALRESULT.STUDENTID AND TEMPATTENDANCE.COURSEID='" + result.getCourseId() + "' AND TEMPATTENDANCE.BATCHNO='" + result.getBatchNo() + "') ");

            //UPDATE FROM TEMPMIDTERM TABLE
            queryList.add(" UPDATE FINALRESULT "
                    + " SET MIDTERM = (SELECT TEMPMIDTERM.AVGMIDTERM "
                    + " FROM TEMPMIDTERM "
                    + " WHERE TEMPMIDTERM.STUDENTID = FINALRESULT.STUDENTID AND TEMPMIDTERM.COURSEID='" + result.getCourseId() + "' AND TEMPMIDTERM.BATCHNO='" + result.getBatchNo() + "') "
                    + " WHERE EXISTS (SELECT TEMPMIDTERM.AVGMIDTERM "
                    + " FROM TEMPMIDTERM "
                    + " WHERE TEMPMIDTERM.STUDENTID = FINALRESULT.STUDENTID AND TEMPMIDTERM.COURSEID='" + result.getCourseId() + "' AND TEMPMIDTERM.BATCHNO='" + result.getBatchNo() + "') ");
            //UPDATE FROM TEMPFINAL TABLE
            queryList.add(" UPDATE FINALRESULT "
                    + " SET FINAL = (SELECT TEMPFINAL.AVGFINAL "
                    + " FROM TEMPFINAL "
                    + " WHERE TEMPFINAL.STUDENTID = FINALRESULT.STUDENTID AND TEMPFINAL.COURSEID='" + result.getCourseId() + "' AND TEMPFINAL.BATCHNO='" + result.getBatchNo() + "') "
                    + " WHERE EXISTS (SELECT TEMPFINAL.AVGFINAL "
                    + " FROM TEMPFINAL "
                    + " WHERE TEMPFINAL.STUDENTID = FINALRESULT.STUDENTID AND TEMPFINAL.COURSEID='" + result.getCourseId() + "' AND TEMPFINAL.BATCHNO='" + result.getBatchNo() + "') ");

            //TOTAL MARKS CALCULATION
            queryList.add(" INSERT INTO TEMPGRADE(STUDENTID,COURSEID,BATCHNO,TOTALMARK) "
                    + " SELECT STUDENTID,COURSEID,BATCHNO,SUM(QUIZ)+SUM(ASSIGNMENT)+SUM(PRESENTATION)+SUM(ATTENDANCE)+SUM(MIDTERM)+SUM(FINAL) "
                    + " FROM FINALRESULT "
                    + " GROUP BY STUDENTID,COURSEID,BATCHNO ");

            //RETURN FINAL RESULT
            //queryList.add(" SELECT * FROM FINALRESULT ");
        }
        //return sb.toString();
        return queryList;
    }
}
