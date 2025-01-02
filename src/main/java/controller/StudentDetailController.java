package controller;

import dao.StudentDAO;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentDetail")
public class StudentDetailController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số ID từ yêu cầu
        String idParam = request.getParameter("id");

        try {
            if (idParam == null || idParam.trim().isEmpty()) {
                // Nếu không có ID, lấy danh sách tất cả học viên
                List<Student> students = StudentDAO.getAllStudents();

                // Gắn danh sách vào request
                request.setAttribute("students", students);

                // Chuyển tiếp đến JSP hiển thị danh sách học viên
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentList.jsp");
                dispatcher.forward(request, response);
            } else {
                // Nếu có ID, lấy chi tiết học viên
                int studentId = Integer.parseInt(idParam);
                Student student = StudentDAO.getStudentById(studentId);

                if (student == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy học viên với ID: " + studentId);
                    return;
                }

                // Gắn thông tin học viên vào request
                request.setAttribute("student", student);

                // Chuyển tiếp đến JSP hiển thị chi tiết học viên
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentDetail.jsp");
                dispatcher.forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Tham số ID phải là một số hợp lệ.");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Đã xảy ra lỗi trong quá trình xử lý yêu cầu.");
            e.printStackTrace();
        }
    }
}
