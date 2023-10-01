package filters;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;


        String isLogin = req.getSession().getAttribute("isLogin") != null ?
                req.getSession().getAttribute("isLogin").toString()
                : null;


        String URI = req.getRequestURI();


            if (isLogin != null && isLogin.equals("1") && URI.endsWith("/login")) {
                resp.sendRedirect("/title");
                return;
            }
            if (isLogin != null && isLogin.equals("1") && !URI.endsWith("/login")) {
                filterChain.doFilter(req, resp);
            }
            if (isLogin == null && URI.endsWith("/login")) {
                filterChain.doFilter(req, resp);

            }

            if (isLogin == null && !URI.endsWith("/login")) {
                resp.sendRedirect("/login");
                return;
            }


        }
    public void destroy(){

    }



}



