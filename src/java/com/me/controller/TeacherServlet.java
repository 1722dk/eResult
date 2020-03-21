package com.me.controller;

import com.me.dao.TeacherDAO;
import com.me.model.Teacher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TeacherServlet", urlPatterns = {"/TeacherServlet"})
public class TeacherServlet extends HttpServlet {
    private TeacherDAO _TeacherDAO = new TeacherDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get form values...
        String action = request.getParameter("action");
        String strTeacherName = request.getParameter("txtTeacherName");        
        String strDesignation = request.getParameter("txtDesignation");
        String strContactNo = request.getParameter("txtContactNo");
        String strEmail = request.getParameter("txtEmail");

        //Create a teacher object
        Teacher teacher = new Teacher(strTeacherName, strDesignation, strContactNo, strEmail);

        try {
            if (action != null && !action.trim().equals("")) {
                if (action.trim().equalsIgnoreCase("View All")) {
                    request.setAttribute("modelList", _TeacherDAO.getAllTeacherList());
                } else if (action.trim().equalsIgnoreCase("Search")) {
                    request.setAttribute("modelList", _TeacherDAO.getAllTeacherList(teacher, action));
                } else {
                    _TeacherDAO.saveTeacher(teacher, action);
                    request.setAttribute("modelList", _TeacherDAO.getAllTeacherList());
                }
            }
            //request.setAttribute(("student"), student);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        request.getRequestDispatcher("teacherinfo.jsp").forward(request, response);
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
