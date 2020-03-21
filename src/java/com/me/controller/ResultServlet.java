package com.me.controller;

import com.me.dao.ResultDAO;
import com.me.model.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResultServlet", urlPatterns = {"/ResultServlet"})
public class ResultServlet extends HttpServlet {

    private ResultDAO _ResultDAO = new ResultDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get form values...
        String action = request.getParameter("action");
        /*String strResultId = request.getParameter("txtResultId");
        int resultId = 0;
        if (strResultId != null && !strResultId.trim().equals("")) {
            resultId = Integer.parseInt(strResultId);
        }*/
        String strCourseId = (String) request.getParameter("ddlCourse");
        String strBatchNo = (String) request.getParameter("ddlBatch");
        String strExamType = (String) request.getParameter("ddlExamType");
        String strExamNo = (String) request.getParameter("ddlExamNo");
        String strStudentId = request.getParameter("txtStudentId");
        String strMark = request.getParameter("textMark");

        //Create a result object
        Result result = new Result(strCourseId, strBatchNo, strStudentId, strExamType, strExamNo, strMark);

        try {
            if (action != null && !action.trim().equals("")) {
                if (action.trim().equalsIgnoreCase("View All")) {
                    //request.setAttribute("modelList", _ResultDAO.getAllResultList());
                    request.getRequestDispatcher("resultinfo.jsp").forward(request, response);
                } else if (action.trim().equalsIgnoreCase("Search")) {
                    request.setAttribute("modelList", _ResultDAO.getAllResultList(result, action));
                } else if (action.trim().equalsIgnoreCase("Submit")) {
                    request.setAttribute(("result"), result);
                    request.setAttribute("modelList", _ResultDAO.getStudentList(result, action));
                } else if (action.trim().equalsIgnoreCase("View Result")) {
                    //request.setAttribute(("result"), result);
                    request.setAttribute("modelList", _ResultDAO.getFinalResultList(result, action));
                    request.getRequestDispatcher("resultsummary.jsp").forward(request, response);
                } else {
                    _ResultDAO.saveResult(result, action);
                    request.setAttribute("modelList", _ResultDAO.getAllResultList());
                }
            }
            //request.setAttribute(("student"), student);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //request.getRequestDispatcher("resultinfo.jsp").forward(request, response);
        //resultposting.jsp
        request.setAttribute(("strCourseId"), strCourseId);
        request.setAttribute(("strBatchNo"), strBatchNo);
        request.setAttribute(("strExamType"), strExamType);
        request.setAttribute(("strExamNo"), strExamNo);
        request.getRequestDispatcher("resultposting.jsp").forward(request, response);
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
