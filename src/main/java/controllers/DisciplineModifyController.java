package controllers;

import DB.DbManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        String name = request.getParameter("name");
        DbManager db = new DbManager();
        db.modifyDiscipline(id,name);
        response.sendRedirect("/disciplines");


    }
}
