package com.me.controller;

import com.me.dao.StudentDAO;
import com.me.model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    private StudentDAO _StudentDAO = new StudentDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Get form values...
        String action = request.getParameter("action");
        String strStudentId = request.getParameter("txtStudentId");
        int studentId = 0;
        if (strStudentId != null && !strStudentId.trim().equals("")) {
            studentId = Integer.parseInt(strStudentId);
        }
        String strFirstName = request.getParameter("txtFirstName");
        String strLastName = request.getParameter("txtLastName");
        String strBatchNo = (String)request.getParameter("ddlBatch");
        String strSession = request.getParameter("txtSession");
        String strEmail = request.getParameter("txtEmail");
        String strContactNo = request.getParameter("txtContactNo");

        //Create a student object
        Student student = new Student(studentId, strFirstName, strLastName, strBatchNo, strSession, strEmail, strContactNo);

        try {
            if (action != null && !action.trim().equals("")) {
                if (action.trim().equalsIgnoreCase("View All")) {
                    request.setAttribute("modelList", _StudentDAO.getAllStudentList());
                } else if (action.trim().equalsIgnoreCase("Search")) {
                    request.setAttribute("modelList", _StudentDAO.getAllStudentList(student, action));
                } else {
                    _StudentDAO.saveStudent(student, action);
                    request.setAttribute("modelList", _StudentDAO.getAllStudentList());
                }
            }
            //request.setAttribute(("student"), student);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
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
