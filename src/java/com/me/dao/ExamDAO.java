package com.me.dao;

import com.me.model.Exam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ExamDAO {

    private JDBCContext _BaseDAO = new JDBCContext();
    private Connection _Connection = null;
    private PreparedStatement _PreparedStatement = null;
    private Statement _Statement = null;
    private ResultSet _ResultSet = null;
    private String _SQL = "";

    public int saveExam(Exam exam, String action) throws SQLException, ClassNotFoundException {
        int result = -1;
        try {
            _SQL = getQueryString(exam, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            result = _PreparedStatement.executeUpdate();
            if (result > 0) {
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
        return result;
    }

    public ArrayList<Exam> getAllExamList() throws SQLException, ClassNotFoundException {
        ArrayList<Exam> examList = new ArrayList<Exam>();
        try {
            _SQL = "SELECT * FROM EXAM ORDER BY EXAMID ASC";
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            Exam exam;
            while (_ResultSet.next()) {
                exam = new Exam(
                        _ResultSet.getInt("ExamId"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("ExamType"),
                        _ResultSet.getString("ExamNo"),
                        _ResultSet.getString("ExamMark"));
                examList.add(exam);
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
        return examList;
    }

    public ArrayList<Exam> getAllExamList(Exam exam, String action) throws SQLException, ClassNotFoundException {
        ArrayList<Exam> examList = new ArrayList<Exam>();
        try {
            _SQL = getQueryString(exam, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();
            
            //Exam exam = null;
            while (_ResultSet.next()) {
                exam = new Exam(
                        _ResultSet.getInt("ExamId"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("ExamType"),
                        _ResultSet.getString("ExamNo"),
                        _ResultSet.getString("ExamMark"));
                examList.add(exam);
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
        return examList;
    }

    public Exam getExam(String query) throws SQLException, ClassNotFoundException {
        Exam exam = null;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                exam = new Exam(
                        _ResultSet.getInt("ExamId"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("ExamType"),
                        _ResultSet.getString("ExamNo"),
                        _ResultSet.getString("ExamMark"));
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
        return exam;
    }

    public String getExamId(String query) throws SQLException, ClassNotFoundException {
        String result = "";
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                result = _ResultSet.getString("ExamId");
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

    public String getQueryString(Exam exam, String action) {
        String sql = "";
        if (action != null) {
            if ("Add".equalsIgnoreCase(action)) {
                sql = "INSERT INTO EXAM VALUES("
                        + exam.getExamId() + ","
                        + "'" + exam.getExamType()+ "',"                        
                        + "'" + exam.getExamNo()+ "',"
                        + "'" + exam.getExamMarks()+ "',"
                        + "'" + exam.getBatchNo()+ "',"                        
                        + "'" + exam.getCourseId()+ "')";
                
            } else if ("Edit".equalsIgnoreCase(action)) {
                sql = "UPDATE EXAM SET ExamType='" + exam.getExamType() + "',"
                        + "ExamNo='" + exam.getExamNo() + "',"
                        + "ExamMark='" + exam.getExamMarks() + "',"
                        + "BatchNo='" + exam.getBatchNo() + "',"
                        + "CourseId='" + exam.getCourseId() + "'"
                        + " WHERE ExamId=" + exam.getExamId() + "";
                
            } else if ("Delete".equalsIgnoreCase(action)) {
                sql = "DELETE FROM EXAM WHERE ExamId=" + exam.getExamId() + "";
                
            } else if ("Search".equalsIgnoreCase(action)) {
                //sql = "SELECT * FROM EXAM ";
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM EXAM ");
                String strWhere = "WHERE";
                String strAnd = "";
                if (exam.getExamId() >0) {
                    sb.append(strWhere).append(" ExamId=").append(exam.getExamId());
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (exam.getExamType() != null && !exam.getExamType().trim().equals("") && !exam.getExamType().trim().equals("0")) {
                    sb.append(strWhere).append(strAnd).append(" ExamType='").append(exam.getExamType()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (exam.getExamNo() != null && !exam.getExamNo().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" ExamNo='").append(exam.getExamNo()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (exam.getExamMarks()!= null && !exam.getExamMarks().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" ExamMark='").append(exam.getExamMarks()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (exam.getBatchNo()!= null && !exam.getBatchNo().trim().equals("") && !exam.getBatchNo().trim().equals("0")) {
                    sb.append(strWhere).append(strAnd).append(" BatchNo='").append(exam.getBatchNo()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (exam.getCourseId()!= null && !exam.getCourseId().trim().equals("") && !exam.getCourseId().trim().equals("0")) {
                    sb.append(strWhere).append(strAnd).append(" CourseId='").append(exam.getCourseId()).append("'");
                }
                sql = sb.toString();
            }
        } else {
            sql = "SELECT * FROM EXAM";
        }
        return sql;
    }
}
