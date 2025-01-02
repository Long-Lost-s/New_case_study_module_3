package com.example.case_md3.controller;

import com.example.case_md3.dao.SchoolClassDAO;
import com.example.case_md3.model.SchoolClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classes")
public class SchoolClassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SchoolClassDAO classDAO = new SchoolClassDAO();
        List<SchoolClass> classes = classDAO.getAllClasses();

        request.setAttribute("classes", classes);
        request.getRequestDispatcher("view/classes.jsp").forward(request, response);
    }
}
