package com.me.dao;

import com.me.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAO extends JDBCContext {

    private JDBCContext _BaseDAO = new JDBCContext();
    private Connection _Connection = null;
    private PreparedStatement _PreparedStatement = null;
    private Statement _Statement = null;
    private ResultSet _ResultSet = null;
    private String _SQL = "";

    public int saveStudent(String query) throws SQLException, ClassNotFoundException {
        int result = -1;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            result = _Statement.executeUpdate(query);
            if (result > 0) {
                _Connection.commit();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (_Statement != null) {
                _Statement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return result;
    }

    public int saveStudent(Student student, String action) throws SQLException, ClassNotFoundException {
        int result = 0;
        try {
            _SQL = getQueryString(student, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            result = _PreparedStatement.executeUpdate();
            if (result > 0) {
                _Connection.commit();
            }
        } catch (SQLException ex) {
            result = -1;
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

    public ArrayList<Student> getAllStudentList() throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            _SQL = "SELECT * FROM STUDENT ORDER BY STUDENTID ASC";
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            Student student;
            while (_ResultSet.next()) {
                student = new Student(
                        _ResultSet.getInt("StudentId"),
                        _ResultSet.getString("FirstName"),
                        _ResultSet.getString("LastName"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("StdSession"),
                        _ResultSet.getString("Email"),
                        _ResultSet.getString("ContactNo"));
                studentList.add(student);
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
        return studentList;
    }

    public ArrayList<Student> getAllStudentList(Student student, String action) throws SQLException, ClassNotFoundException {
        ArrayList<Student> studentList = new ArrayList<Student>();
        try {
            _SQL = getQueryString(student, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();
            //Student student = null;
            while (_ResultSet.next()) {
                student = new Student(
                        _ResultSet.getInt("StudentId"),
                        _ResultSet.getString("FirstName"),
                        _ResultSet.getString("LastName"),
                        _ResultSet.getString("BatchNo"),
                        _ResultSet.getString("StdSession"),
                        _ResultSet.getString("Email"),
                        _ResultSet.getString("ContactNo"));
                studentList.add(student);
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
        return studentList;
    }

    public Student getStudent(String query) throws SQLException, ClassNotFoundException {
        Student student = null;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);

            while (_ResultSet.next()) {
                student = new Student(
                        _ResultSet.getInt("STUDENTID"),
                        _ResultSet.getString("FIRSTNAME"),
                        _ResultSet.getString("LASTNAME"),
                        _ResultSet.getString("BATCHNO"),
                        _ResultSet.getString("STDSESSION"),
                        _ResultSet.getString("EMAIL"),
                        _ResultSet.getString("CONTACTNO"));
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
        return student;
    }

    public int getStudentId(String query) throws SQLException, ClassNotFoundException {
        int result = -1;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                result = _ResultSet.getInt("StudentId");
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

    public String getQueryString(Student student, String action) {
        String sql = "";
        if (action != null) {
            if ("Add".equalsIgnoreCase(action)) {
                sql = "INSERT INTO STUDENT VALUES("
                        + student.getStudentId() + ","
                        + "'" + student.getFirstName() + "',"
                        + "'" + student.getLastName() + "',"
                        + "'" + student.getBatchNo() + "',"
                        + "'" + student.getStdSession() + "',"
                        + "'" + student.getEmail() + "',"
                        + "'" + student.getContactNo() + "')";
            } else if ("Edit".equalsIgnoreCase(action)) {
                sql = "UPDATE STUDENT SET FirstName='" + student.getFirstName() + "',"
                        + "LastName='" + student.getLastName() + "',"
                        + "BatchNo='" + student.getBatchNo() + "',"
                        + "StdSession='" + student.getStdSession() + "',"
                        + "Email='" + student.getEmail() + "',"
                        + "ContactNo='" + student.getContactNo() + "'"
                        + " WHERE StudentId=" + student.getStudentId() + "";
            } else if ("Delete".equalsIgnoreCase(action)) {
                sql = "DELETE FROM STUDENT WHERE StudentId=" + student.getStudentId() + "";
            } else if ("Search".equalsIgnoreCase(action)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM STUDENT ");
                String strWhere = "WHERE";
                String strAnd = "";
                if (student.getStudentId() > 0) {
                    sb.append(strWhere).append(" StudentId=").append(student.getStudentId());
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (student.getFirstName() != null && !student.getFirstName().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" FirstName LIKE '%").append(student.getFirstName()).append("%'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (student.getLastName() != null && !student.getLastName().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" LastName LIKE '%").append(student.getLastName()).append("%'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (student.getBatchNo() != null && !student.getBatchNo().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" BatchNo='").append(student.getBatchNo()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (student.getStdSession() != null && !student.getStdSession().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" StdSession='").append(student.getStdSession()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (student.getEmail() != null && !student.getEmail().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" Email='").append(student.getEmail()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (student.getContactNo() != null && !student.getContactNo().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" ContactNo='").append(student.getContactNo()).append("'");
                }
                sql = sb.toString();
            }
        } else {
            sql = "SELECT * FROM STUDENT";
        }
        return sql;
    }
}
