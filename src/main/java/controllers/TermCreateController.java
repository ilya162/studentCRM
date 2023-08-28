package controllers;

import DB.DbManager;
import entity.Discipline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermCreateController", value = "/term_create")
public class TermCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbManager db = new DbManager();
        List<Discipline> disciplines = db.getActiveDiscipline();
        request.setAttribute("disciplines", disciplines);
        request.getRequestDispatcher("JSP/term_create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//перехватить данные,2) сохранить данные в бд 3) перейти на страницу семестров

        String name = request.getParameter("name");
        String duration = request.getParameter("duration");
        String disciplines = request.getParameter("disciplines");

        DbManager db = new DbManager();
        db.createTerm(name, duration,disciplines);


        response.sendRedirect("/term");
    }
}
