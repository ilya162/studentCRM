package controllers;

import db.DbManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentModify", value = "/student_modify")
public class StudentModify extends HttpServlet {
    private String id;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//  получаем данные
//  отображаем
//  открываем страницу
        id = request.getParameter("modifyStudentHidden");
        DbManager db = new DbManager();
        Student student = db.getStudentToId(id);
        request.setAttribute("student",student);
        request.getRequestDispatcher("JSP/student_modify.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// получаем данные с о страницы
//                сохраняем
//                возвращаемся на страницу студентов
//
        String ser_name = request.getParameter("ser_name");
        String name = request.getParameter("name");
        String group = request.getParameter("group");
        String date_in = request.getParameter("date_in");
        DbManager db = new DbManager();

        db.modifyStudent(id,ser_name,name,group,date_in);
        response.sendRedirect("/student");
    }
}
