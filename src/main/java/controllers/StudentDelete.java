package controllers;

import db.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentDelete", value = "/deleteStudent")
public class StudentDelete extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Получение данных
        //Удаление
        //Переходим на контроллер студенты
        String ids = request.getParameter("deleteStudentHidden");
        DbManager db = new DbManager();
        db.deleteStudent(ids);
        response.sendRedirect("/student");

    }
}
