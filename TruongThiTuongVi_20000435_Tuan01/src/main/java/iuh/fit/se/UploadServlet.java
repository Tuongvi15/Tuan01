package iuh.fit.se;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig   // bật chế độ multipart để nhận file
public class UploadServlet extends HttpServlet {

    private String uploadPath;

    @Override
    public void init() throws ServletException {
        // Đường dẫn lưu file vào thư mục uploads trong webapp
        uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        StringBuilder result = new StringBuilder("<h2>Kết quả Upload:</h2><ul>");

        // Lặp qua tất cả file người dùng chọn
        for (Part part : request.getParts()) {
            if (part.getName().equals("files") && part.getSize() > 0) {
                String fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName); // lưu file vào server
                result.append("<li>").append(fileName).append(" uploaded thành công!</li>");
            }
        }

        result.append("</ul>");
        response.getWriter().println(result.toString());
    }
}