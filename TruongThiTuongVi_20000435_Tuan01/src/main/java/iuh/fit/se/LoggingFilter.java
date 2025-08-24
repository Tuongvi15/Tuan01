package iuh.fit.se;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter("/*")   // áp dụng cho tất cả request
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("LoggingFilter initialized!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received at: " + new Date());
        // Cho phép request đi tiếp tới Servlet
        chain.doFilter(request, response);
        // Sau khi Servlet xử lý xong
        System.out.println("Response sent at: " + new Date());
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed!");
    }
}
