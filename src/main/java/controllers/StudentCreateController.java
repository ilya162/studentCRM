package controllers;

import DB.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentCreateController", value = "/student_create")
public class StudentCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/student_create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//перехватить данные,2) сохранить данные в бд 3) перейти на страницу студентов
        String ser_name = request.getParameter("ser_name");
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        String date_in = request.getParameter("date_in");
        if (ser_name.isEmpty() || name.isEmpty() || group.isEmpty() || date_in.isEmpty()) {
        } else {
            DbManager manager = new DbManager();
            manager.createStudent(ser_name, name, group, date_in);
            response.sendRedirect("/student");
        }


    }
}
