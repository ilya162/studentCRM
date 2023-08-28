package controllers;

import DB.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplineDelete", value = "/deleteDiscipline")
public class DisciplineDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Получение данных
        //Удаление
        //Переходим на контроллер дисциплины
        String ids = request.getParameter("deleteDisciplineHidden");
        DbManager db = new DbManager();
        db.deleteDiscipline(ids);
        response.sendRedirect("/disciplines");
    }
}
