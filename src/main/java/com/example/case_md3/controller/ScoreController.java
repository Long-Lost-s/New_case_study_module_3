package com.example.case_md3.controller;

import com.example.case_md3.dao.ScoreDAO;
import com.example.case_md3.model.Score;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/scores")
public class ScoreController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentIdParam = request.getParameter("studentId");
        String classIdParam = request.getParameter("classId");

        if (studentIdParam == null || studentIdParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing studentId parameter");
            return;
        }

        try {
            int studentId = Integer.parseInt(studentIdParam);
            ScoreDAO scoreDAO = new ScoreDAO();
            List<Score> scores = scoreDAO.getScoresByStudentId(studentId);

            request.setAttribute("scores", scores);
            request.setAttribute("classId", classIdParam);
            request.getRequestDispatcher("view/scores.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid studentId format");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request");
        }
    }
}
