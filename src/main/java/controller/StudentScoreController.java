package controller;

import model.ExamResult;
import dao.ExamResultDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentScores")
public class StudentScoreController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tham số ID từ yêu cầu
        String idParam = request.getParameter("id");

        try {
            if (idParam == null || idParam.trim().isEmpty()) {
                // Nếu không có ID, chuyển hướng về danh sách học viên
                response.sendRedirect("studentList");
                return;
            }

            // Chuyển đổi ID sang số nguyên
            int studentId = Integer.parseInt(idParam);

            // Lấy danh sách điểm thi của học viên từ DAO
            List<ExamResult> scores = ExamResultDAO.getScoresByStudentId(studentId);

            if (scores == null || scores.isEmpty()) {
                // Nếu không có điểm thi, hiển thị thông báo lỗi
                request.setAttribute("error", "Không tìm thấy điểm thi nào cho học viên này.");
                request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
                return;
            }

            // Gắn danh sách điểm thi vào request
            request.setAttribute("scores", scores);

            // Chuyển tiếp đến JSP hiển thị điểm thi
            request.getRequestDispatcher("/WEB-INF/views/studentScores.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Xử lý nếu tham số ID không phải là số
            request.setAttribute("error", "Định dạng mã học viên không hợp lệ.");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        } catch (Exception e) {
            // Xử lý lỗi khác
            request.setAttribute("error", "Đã xảy ra lỗi trong quá trình xử lý.");
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
        }
    }
}
