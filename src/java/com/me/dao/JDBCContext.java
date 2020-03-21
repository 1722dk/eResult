
package com.me.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCContext {

    //JDBC driver name
    private static final String _JDBCDriver = "oracle.jdbc.driver.OracleDriver";
    //Database URL
    private static final String _ConnectionString = "jdbc:oracle:thin:juthi/juthi@localhost:1521:XE";
    //Database credentials
    private static final String _Username = "juthi";
    private static final String _Password = "juthi";
    
    private static Connection _Connection = null;

    public String getJDBCDriver() {
        return JDBCContext._JDBCDriver;
    }

    public String getConnectionString() {
        return JDBCContext._ConnectionString;
    }

    public String getUsername() {
        return JDBCContext._Username;
    }

    public String getPassword() {
        return JDBCContext._Password;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
             //Register JDBC driver
            Class.forName(_JDBCDriver);
            //Open a connection
            JDBCContext._Connection = DriverManager.getConnection(_ConnectionString, _Username, _Password);            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return JDBCContext._Connection;
    }
}
