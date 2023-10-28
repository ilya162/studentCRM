package controllers;

import database.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        DbManager db = new DbManager();
        if (db.checkUser(login, password)) {
            request.getSession().setAttribute("isLogin", "1");
            response.sendRedirect("/title");
        } else {
            request.setAttribute("Error", "loginError");
            request.getRequestDispatcher("JSP/login.jsp").forward(request, response);
        }
    }
}
