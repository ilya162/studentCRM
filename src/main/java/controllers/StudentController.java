package controllers;

import database.DbManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbManager db = new DbManager();
        List<Student> students = db.getActiveStudent();
        request.setAttribute("students",students);
request.getRequestDispatcher("JSP/student.jsp").forward(request,response);
    }


}
