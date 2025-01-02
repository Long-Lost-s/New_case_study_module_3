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

@WebServlet("/studentList")
public class StudentListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số trạng thái từ yêu cầu
        String status = request.getParameter("status");

        // Kiểm tra tham số trạng thái
        if (status == null || status.trim().isEmpty()) {
            // Nếu không có tham số, chuyển tới trang JSP yêu cầu chọn trạng thái
            request.setAttribute("error", "Vui lòng chọn trạng thái học viên để hiển thị danh sách.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentList.jsp");

            dispatcher.forward(request, response);
            return;
        }

        try {
            // Lấy danh sách học viên theo trạng thái
            List<Student> students = StudentDAO.getStudentsByStatus(status);

            // Kiểm tra nếu danh sách trống
            if (students.isEmpty()) {
                request.setAttribute("error", "Không tìm thấy học viên nào với trạng thái: " + status);
            } else {
                request.setAttribute("students", students);
            }

        } catch (Exception e) {
            // Xử lý lỗi truy vấn cơ sở dữ liệu
            request.setAttribute("error", "Đã xảy ra lỗi trong quá trình lấy dữ liệu học viên.");
            e.printStackTrace();
        }

        // Chuyển tiếp đến JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/studentList.jsp");

        dispatcher.forward(request, response);
    }
}
