package iuh.fit.se;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/filter-test")
public class FilterTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h2>Bài 1 - Servlet Filter hoạt động!</h2>");
    }
}

