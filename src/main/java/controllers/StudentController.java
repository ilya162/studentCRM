package controllers;

import db.DbManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // подключиться к бд, получить данные,передать данные на фронт
        DbManager db = new DbManager();
        List<Student> students = db.getActiveStudent();
        request.setAttribute("students",students);
request.getRequestDispatcher("JSP/student.jsp").forward(request,response);
    }


}
