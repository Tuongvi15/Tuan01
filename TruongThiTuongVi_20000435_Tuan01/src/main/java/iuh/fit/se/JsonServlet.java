package iuh.fit.se;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/json")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Đặt kiểu dữ liệu trả về là JSON
        response.setContentType("application/json;charset=UTF-8");

        // Tạo một User mẫu
        User user = new User("Nguyen Van A", "tuongvi15022002@gmail.com");

        // Dùng Jackson để convert object -> JSON string
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);

        // Gửi dữ liệu JSON về client
        response.getWriter().print(json);
    }
}