package com.me.controller;

import com.me.dao.CourseDAO;
import com.me.model.Course;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {

    private CourseDAO _CourseDAO = new CourseDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get form values...
        String action = request.getParameter("action");
        String strCourseId = request.getParameter("txtCourseId");
        String strCourseCredit = request.getParameter("txtCourseCredit");
        String strCourseTitle = request.getParameter("txtCourseTitle");

        //Create a course object
        Course course = new Course(strCourseId, strCourseCredit, strCourseTitle);

        try {
            if (action != null && !action.trim().equals("")) {
                if (action.trim().equalsIgnoreCase("View All")) {
                    request.setAttribute("modelList", _CourseDAO.getAllCourseList());
                } else if (action.trim().equalsIgnoreCase("Search")) {
                    request.setAttribute("modelList", _CourseDAO.getAllCourseList(course, action));
                } else {
                    _CourseDAO.saveCourse(course, action);
                    request.setAttribute("modelList", _CourseDAO.getAllCourseList());
                }
            }
            //request.setAttribute(("student"), student);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        request.getRequestDispatcher("courseinfo.jsp").forward(request, response);
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
