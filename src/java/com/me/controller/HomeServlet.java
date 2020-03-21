
package com.me.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strRedirectAction="";
        strRedirectAction = request.getParameter("studentinfo");
        strRedirectAction = request.getParameter("studentsummary");
        strRedirectAction = request.getParameter("teacherinfo");
        strRedirectAction = request.getParameter("teachersummary");
        strRedirectAction = request.getParameter("courseinfo");
        strRedirectAction = request.getParameter("coursesummary");
        strRedirectAction = request.getParameter("examinfo");
        strRedirectAction = request.getParameter("examsummary");
        strRedirectAction = request.getParameter("resultinfo");
        strRedirectAction = request.getParameter("resultsummary");
        if("Add/Edit Student".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
        }else if("Student Summary".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("studentsummary.jsp").forward(request, response);
        } else if("Add/Edit Teacher".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("teacherinfo.jsp").forward(request, response);
        } else if("Teacher Summary".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("teachersummary.jsp").forward(request, response);
        } else if("Add/Edit Course".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("courseinfo.jsp").forward(request, response);
        } else if("Course Summary".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("coursesummary.jsp").forward(request, response);
        } else if("Add/Edit Exam".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("examinfo.jsp").forward(request, response);
        } else if("Exam Summary".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("examsummary.jsp").forward(request, response);
        } else if("Add/Edit Result".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("resultinfo.jsp").forward(request, response);
        } else if("Result Summary".equalsIgnoreCase(strRedirectAction)){
            request.getRequestDispatcher("resultsummary.jsp").forward(request, response);
        }       
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
