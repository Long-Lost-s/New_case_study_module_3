package controller;

import DAO.StudentScoreDAO;
import DAO.SubjectDAO;
import model.StudentScore;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Academic Affairs", urlPatterns = "/academicAffair")
public class AcademicAffairsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentScoreDAO studentScoreDAO;
    private SubjectDAO subjectDAO;

    @Override
    public void init() {
        studentScoreDAO = new StudentScoreDAO();
        subjectDAO = new SubjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                case "edit":
                    showEditForm(request, response);
                    break;
                default:
                    listStudentScores(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));

        StudentScore studentScore = studentScoreDAO.getStudentScoreBySubjectAndStudent(subjectId, studentId);
        request.setAttribute("studentScore", studentScore);

        request.getRequestDispatcher("academicAffairs/editStudentScore.jsp").forward(request, response);
    }

    private void listStudentScores(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subjectId = request.getParameter("subjectId");
        if (subjectId == null) subjectId = "-1";

        List<StudentScore> studentScores = studentScoreDAO.getStudentScoreBySubject(Integer.parseInt(subjectId));
        List<Subject> subjects = subjectDAO.selectAllSubjects();

        request.setAttribute("subjectId", subjectId);
        request.setAttribute("subjects", subjects);
        request.setAttribute("studentScores", studentScores);

        request.getRequestDispatcher("academicAffairs/listStudentScores.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "edit":
                    editStudentScore(request, response);
                    break;
                default:
                    listStudentScores(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editStudentScore(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        float theoryScore = Float.parseFloat(request.getParameter("theoryScore"));
        float practicalScore = Float.parseFloat(request.getParameter("practicalScore"));
        studentScoreDAO.updateStudentScore(studentId,subjectId,theoryScore,practicalScore);

        request.setAttribute("subjectId", subjectId);
        listStudentScores(request, response);
    }
}
