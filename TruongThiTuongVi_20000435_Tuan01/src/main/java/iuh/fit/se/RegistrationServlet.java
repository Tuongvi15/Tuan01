package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // không hiển thị
        String gender = request.getParameter("gender");
        String[] hobbies = request.getParameterValues("hobby");
        String country = request.getParameter("country");
        String bio = request.getParameter("bio");

        // Hiển thị kết quả (không show password)
        out.println("<html><body>");
        out.println("<h2>Kết quả đăng ký</h2>");
        out.println("<p>Họ tên: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Giới tính: " + gender + "</p>");

        if (hobbies != null) {
            out.println("<p>Sở thích: ");
            for (String hobby : hobbies) {
                out.print(hobby + " ");
            }
            out.println("</p>");
        }

        out.println("<p>Quốc gia: " + country + "</p>");
        out.println("<p>Giới thiệu: " + bio + "</p>");
        out.println("</body></html>");
    }

    // Nếu form dùng GET thì cũng xử lý tương tự
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}