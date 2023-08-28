package controllers;

import DB.DbManager;
import entity.Discipline;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplineModifyController", value = "/discipline_modify")
public class DisciplineModifyController extends HttpServlet {
    private String id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        id = request.getParameter("modifyDisciplineHidden");
        DbManager db = new DbManager();
        Discipline discipline = db.getDisciplineToId(id);
        request.setAttribute("discipline", discipline);
        request.getRequestDispatcher("JSP/discipline_modify.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// получаем данные со страницы
//                сохраняем
//                возвращаемся на страницу студентов
//

        String name = request.getParameter("name");

        DbManager db = new DbManager();

        db.modifyDiscipline(id,name);
        response.sendRedirect("/disciplines");


    }
}
