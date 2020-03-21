package com.me.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO extends JDBCContext {

    private JDBCContext _JDBCContext = new JDBCContext();
    private Connection _Connection = null;
    private Statement _Statement = null;
    private PreparedStatement _PreparedStatement = null;
    private ResultSet _ResultSet = null;
    private String _SQL = "";

    public boolean ValidateUser(String query) throws SQLException, ClassNotFoundException {
        boolean validUser = false;
        try {
            //Get a db connection
            _Connection = _JDBCContext.getConnection();
            //Creating statement...
            _Statement = _Connection.createStatement();
            // Let us check if it returns a true Result Set or not.
            boolean retrieved = _Statement.execute(query);
            if (retrieved) {
                validUser = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            //Finally block used to close resources
            if (_Statement != null) {
                _Statement.close();
            }
            if (_Connection != null) {
                _Connection.close();
            }
        }
        return validUser;
    }

    public boolean ValidateUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean validUser = false;
        try {
            //Get a db connection
            _Connection = _JDBCContext.getConnection();
            //Creating prepared statement...
            _SQL = "SELECT UserId FROM ERESULT_USER WHERE Login=? AND PIN=?";
            _PreparedStatement = _Connection.prepareStatement(_SQL);
            _PreparedStatement.setString(1, username);
            _PreparedStatement.setString(2, password);
            //Execute a query
            _ResultSet = _PreparedStatement.executeQuery();
            //Extract data from result set
            while (_ResultSet.next()) {
                int userId = _ResultSet.getInt("UserId");
                if (userId > 0) {
                    validUser = true;
                }
            }
            //Clean-up environment
            //_ResultSet.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            //Finally block used to close resources
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
        return validUser;
    }

    public ResultSet getValidUser(String query) throws SQLException, ClassNotFoundException {
        try {
            _Connection = _JDBCContext.getConnection();
            _ResultSet = _Connection.createStatement().executeQuery(query);
            while (_ResultSet.next()) {
                System.out.println(_ResultSet.getString("UserID") + " "
                        + _ResultSet.getString("USERNAME"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return _ResultSet;
    }
}
