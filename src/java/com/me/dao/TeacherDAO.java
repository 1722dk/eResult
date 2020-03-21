package com.me.dao;

import com.me.model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherDAO {
    private JDBCContext _BaseDAO = new JDBCContext();
    private Connection _Connection = null;
    private PreparedStatement _PreparedStatement = null;
    private Statement _Statement = null;
    private ResultSet _ResultSet = null;
    private String _SQL = "";

    public int saveTeacher(Teacher teacher, String action) throws SQLException, ClassNotFoundException {
        int result = -1;
        try {
            _SQL = getQueryString(teacher, action);
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

    public ArrayList<Teacher> getAllTeacherList() throws SQLException, ClassNotFoundException {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        try {
            _SQL = "SELECT * FROM TEACHER ORDER BY TEACHERNAME ASC";
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();

            Teacher teacher;
            while (_ResultSet.next()) {
                teacher = new Teacher(
                        _ResultSet.getString("TeacherName"),
                        _ResultSet.getString("Designation"),
                        _ResultSet.getString("ContactNo"),
                        _ResultSet.getString("Email"));
                teacherList.add(teacher);
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
        return teacherList;
    }

    public ArrayList<Teacher> getAllTeacherList(Teacher teacher, String action) throws SQLException, ClassNotFoundException {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        try {
            _SQL = getQueryString(teacher, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();
            
            //Teacher teacher = null;
            while (_ResultSet.next()) {
                teacher = new Teacher(
                        _ResultSet.getString("TeacherName"),
                        _ResultSet.getString("Designation"),
                        _ResultSet.getString("ContactNo"),
                        _ResultSet.getString("Email"));
                teacherList.add(teacher);
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
        return teacherList;
    }

    public Teacher getTeacher(String query) throws SQLException, ClassNotFoundException {
        Teacher teacher = null;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                teacher = new Teacher(
                        _ResultSet.getString("TeacherName"),
                        _ResultSet.getString("Designation"),
                        _ResultSet.getString("ContactNo"),
                        _ResultSet.getString("Email"));
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
        return teacher;
    }

    public String getTeacherId(String query) throws SQLException, ClassNotFoundException {
        String result = "";
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                result = _ResultSet.getString("TeacherName");
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

    public String getQueryString(Teacher teacher, String action) {
        String sql = "";
        if (action != null) {
            if ("Add".equalsIgnoreCase(action)) {
                sql = "INSERT INTO TEACHER VALUES("
                        + "'" + teacher.getTeacherName()+ "',"
                        + "'" + teacher.getDesignation()+ "',"                        
                        + "'" + teacher.getContactNo()+ "',"                        
                        + "'" + teacher.getEmail()+ "')";
                
            } else if ("Edit".equalsIgnoreCase(action)) {
                sql = "UPDATE TEACHER SET Designation='" + teacher.getDesignation() + "',"
                        + "ContactNo='" + teacher.getContactNo() + "',"
                        + "Email='" + teacher.getEmail() + "'"
                        + " WHERE TeacherName='" + teacher.getTeacherName() + "'";
                
            } else if ("Delete".equalsIgnoreCase(action)) {
                sql = "DELETE FROM TEACHER WHERE TeacherName='" + teacher.getTeacherName() + "'";
                
            } else if ("Search".equalsIgnoreCase(action)) {
                //sql = "SELECT * FROM TEACHER ";
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM TEACHER ");
                String strWhere = "WHERE";
                String strAnd = "";
                if (teacher.getTeacherName() != null && !teacher.getTeacherName().trim().equals("")) {
                    sb.append(strWhere).append(" TeacherName='").append(teacher.getTeacherName()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (teacher.getDesignation() != null && !teacher.getDesignation().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" Designation='").append(teacher.getDesignation()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (teacher.getContactNo() != null && !teacher.getContactNo().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" ContactNo='").append(teacher.getContactNo()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (teacher.getEmail()!= null && !teacher.getEmail().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" Email='").append(teacher.getEmail()).append("'");
                }
                sql = sb.toString();
            }
        } else {
            sql = "SELECT * FROM TEACHER";
        }
        return sql;
    }
}
