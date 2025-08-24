package iuh.fit.se;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigServlet extends HttpServlet {

    private String author;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // Lấy init-param từ web.xml
        author = config.getInitParameter("author");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Lấy context-param từ web.xml
        ServletContext context = getServletContext();
        String appName = context.getInitParameter("appName");

        out.println("<html><body>");
        out.println("<h2>Bài 4 - Init Param & Context Param</h2>");
        out.println("<p>Author (init-param): " + author + "</p>");
        out.println("<p>App Name (context-param): " + appName + "</p>");
        out.println("</body></html>");
    }
}
