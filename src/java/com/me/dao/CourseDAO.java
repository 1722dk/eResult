package com.me.dao;

import com.me.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAO {

    private JDBCContext _BaseDAO = new JDBCContext();
    private Connection _Connection = null;
    private PreparedStatement _PreparedStatement = null;
    private Statement _Statement = null;
    private ResultSet _ResultSet = null;
    private String _SQL = "";

    public int saveCourse(Course course, String action) throws SQLException, ClassNotFoundException {
        int result = -1;
        try {
            _SQL = getQueryString(course, action);
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

    public ArrayList<Course> getAllCourseList() throws SQLException, ClassNotFoundException {
        ArrayList<Course> courseList = new ArrayList<Course>();
        try {
            _SQL = "SELECT * FROM COURSE ORDER BY COURSEID ASC";
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();
            Course course = null;
            while (_ResultSet.next()) {
                course = new Course(
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("CourseCredit"),
                        _ResultSet.getString("CourseTitle"));
                courseList.add(course);
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
        return courseList;
    }

    public ArrayList<Course> getAllCourseList(Course course, String action) throws SQLException, ClassNotFoundException {
        ArrayList<Course> courseList = new ArrayList<Course>();
        try {
            _SQL = getQueryString(course, action);
            _Connection = _BaseDAO.getConnection();
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _ResultSet = _PreparedStatement.executeQuery();
            //Course course = null;
            while (_ResultSet.next()) {
                course = new Course(
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("CourseCredit"),
                        _ResultSet.getString("CourseTitle"));
                courseList.add(course);
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
        return courseList;
    }

    public Course getCourse(String query) throws SQLException, ClassNotFoundException {
        Course course = null;
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                course = new Course(
                        _ResultSet.getString("CourseId"),
                        _ResultSet.getString("CourseCredit"),
                        _ResultSet.getString("CourseTitle"));
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
        return course;
    }

    public String getCourseId(String query) throws SQLException, ClassNotFoundException {
        String result = "";
        try {
            _Connection = _BaseDAO.getConnection();
            _Statement = _Connection.createStatement();
            _ResultSet = _Statement.executeQuery(query);
            while (_ResultSet.next()) {
                result = _ResultSet.getString("CourseId");
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

    public String getQueryString(Course course, String action) {
        String sql = "";
        if (action != null) {
            if ("Add".equalsIgnoreCase(action)) {
                sql = "INSERT INTO COURSE VALUES("
                        + "'" + course.getCourseId() + "',"
                        + "'" + course.getCourseCredit() + "',"
                        + "'" + course.getCourseTitle()+ "')";
            } else if ("Edit".equalsIgnoreCase(action)) {
                sql = "UPDATE COURSE SET CourseCredit='" + course.getCourseCredit() + "',"
                        + "CourseTitle='" + course.getCourseTitle() + "'"
                        + " WHERE CourseId='" + course.getCourseId() + "'";
            } else if ("Delete".equalsIgnoreCase(action)) {
                sql = "DELETE FROM COURSE WHERE CourseId='" + course.getCourseId() + "'";
            } else if ("Search".equalsIgnoreCase(action)) {
                //sql = "SELECT * FROM COURSE ";
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT * FROM COURSE ");
                String strWhere = "WHERE";
                String strAnd = "";
                if (course.getCourseId() != null && !course.getCourseId().trim().equals("")) {
                    sb.append(strWhere).append(" CourseId='").append(course.getCourseId()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (course.getCourseCredit() != null && !course.getCourseCredit().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" CourseCredit ='").append(course.getCourseCredit()).append("'");
                    strAnd = " AND ";
                    strWhere = "";
                }
                if (course.getCourseTitle() != null && !course.getCourseTitle().trim().equals("")) {
                    sb.append(strWhere).append(strAnd).append(" CourseTitle LIKE '%").append(course.getCourseTitle()).append("%'");
                }
                sql = sb.toString();
            }
        } else {
            sql = "SELECT * FROM COURSE";
        }
        return sql;
    }
}
