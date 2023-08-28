package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String isLogin = null;

        if (req.getSession().getAttribute("isLogin.") != null) {
            isLogin = req.getSession().getAttribute("isLogin.").toString();

        }
        String requestURI = req.getRequestURI();


        if (isLogin == null && !requestURI.endsWith("/login")) {
            resp.sendRedirect("/login");
            return;
        }

        if (isLogin == null && requestURI.endsWith("/login")) {
            filterChain.doFilter(req, resp);

        }


        if (isLogin != null && isLogin.equals("1") && requestURI.endsWith("/login")) {
            resp.sendRedirect("/title");
            return;
        }
        if (isLogin != null && isLogin.equals("1") && !requestURI.endsWith("/login")) {
            filterChain.doFilter(req, resp);
        }


    }
}