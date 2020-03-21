package com.me.controller;

import com.me.dao.ExamDAO;
import com.me.model.Exam;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExamServlet", urlPatterns = {"/ExamServlet"})
public class ExamServlet extends HttpServlet {

    private ExamDAO _ExamDAO = new ExamDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get form values...
        String action = request.getParameter("action");
        String strExamId = request.getParameter("txtExamId");
        int examId = 0;
        if (strExamId != null && !strExamId.trim().equals("")) {
            examId = Integer.parseInt(strExamId);
        }
        String strBatchNo = (String)request.getParameter("ddlBatch");
        String strCourseId = (String)request.getParameter("ddlCourse");
        String strExamType = (String)request.getParameter("ddlExamType");
        String strExamNo = request.getParameter("txtExamNo");
        String strExamMark = request.getParameter("txtExamMark");

        //Create a exam object
        Exam exam = new Exam(examId, strBatchNo, strCourseId, strExamType, strExamNo, strExamMark);

        try {
            if (action != null && !action.trim().equals("")) {
                if (action.trim().equalsIgnoreCase("View All")) {
                    request.setAttribute("modelList", _ExamDAO.getAllExamList());
                } else if (action.trim().equalsIgnoreCase("Search")) {
                    request.setAttribute("modelList", _ExamDAO.getAllExamList(exam, action));
                } else {
                    _ExamDAO.saveExam(exam, action);
                    request.setAttribute("modelList", _ExamDAO.getAllExamList());
                }
            }
            //request.setAttribute(("student"), student);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        request.getRequestDispatcher("examinfo.jsp").forward(request, response);
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
