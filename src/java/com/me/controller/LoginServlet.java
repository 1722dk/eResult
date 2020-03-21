/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private LoginDAO _LoginDAO = new LoginDAO();
    private String _Query;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strUsername = request.getParameter("txtUsername");
        String strPassword = request.getParameter("txtPassword");

        //strUsername.trim().equals("") 
        //strPassword.trim().equals("")
        if (strUsername != null && strPassword != null) {
            _Query = "SELECT UserId FROM ERESULT_USER WHERE Login='" + strUsername + "' AND PIN='" + strPassword + "'";

            try {
                boolean validUser;
                //Executing Statement
                //validUser = _LoginDAO.ValidateUser(_Query); 
                validUser = _LoginDAO.ValidateUser(strUsername, strPassword);
                if (validUser) {
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                } else {
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
