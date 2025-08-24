package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/html")
public class HtmlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Đặt kiểu dữ liệu trả về là HTML
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Bài 2 - HTML Response</title></head>");
        out.println("<body>");
        out.println("<h1>Đây là response dạng HTML từ Servlet!</h1>");
        out.println("<p>Ví dụ: Thời gian hiện tại là: " + new java.util.Date() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
