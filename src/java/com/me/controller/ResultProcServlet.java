package com.me.controller;

import com.me.dao.ResultDAO;
import com.me.model.Result;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResultProcServlet", urlPatterns = {"/ResultProcServlet"})
public class ResultProcServlet extends HttpServlet {

    private ResultDAO _ResultDAO = new ResultDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get form values...
        String action = request.getParameter("action");
        String strCourseId = (String) request.getParameter("txtCourseId");
        String strBatchNo = (String) request.getParameter("txtBatchNo");
        String strExamType = (String) request.getParameter("txtExamType");
        String strExamNo = (String) request.getParameter("txtExamNo");
        
        int rslt = -1;
        try {
            if (action != null && !action.trim().equals("")) {
                String[] arrStudents = request.getParameterValues("txtStudents");
                String[] arrMarks = request.getParameterValues("txtMarks");

                String strStudentId = "";
                String strMark = "";
                Result result = null;
                if ((arrStudents != null && arrStudents.length > 0) && (arrMarks != null && arrMarks.length > 0)) {
                    for (int i = 0; i < arrStudents.length; i++) {
                        strStudentId = arrStudents[i].trim().toString();
                        strMark = arrMarks[i].trim().toString();
                        result = new Result(strCourseId, strBatchNo, strStudentId, strExamType, strExamNo, strMark);
                        rslt = _ResultDAO.saveResult(result, action);
                        if (rslt < 1) {
                            request.setAttribute("lblErrorMsg", "Data insert failed.");
                            request.getRequestDispatcher("resultposting.jsp").forward(request, response);
                        }
                    }
                }
                //_ResultDAO.saveResult(result, action);
                //request.setAttribute("modelList", _ResultDAO.getAllResultList());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (rslt > 0) {
            request.setAttribute("lblMsg", "Data saved successfully.");
            request.getRequestDispatcher("resultinfo.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("resultposting.jsp").forward(request, response);
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
    }// </editor-fold>
}
