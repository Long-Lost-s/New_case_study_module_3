package controller;

import DAO.ClassesDAO;
import DAO.IClassesDAO;
import DAO.IStudentDAO;
import DAO.StudentDAO;
import model.Classes;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Teacher Action Controller", urlPatterns = "/teacher")
public class TeacherActionController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IStudentDAO studentDAO;
    private IClassesDAO classDAO;

    @Override
    public void init() {
        studentDAO = new StudentDAO();
        classDAO = new ClassesDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        try {
            switch (action) {
                default:
                    listStudents(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listStudents (HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> studentList = studentDAO.selectAllStudents();
        List<Classes> classesList = classDAO.selectAllClasses();

        request.setAttribute("studentList", studentList);
        request.setAttribute("classesList", classesList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("teacherAction/listStudent.jsp");
        dispatcher.forward(request, response);
    }
}
