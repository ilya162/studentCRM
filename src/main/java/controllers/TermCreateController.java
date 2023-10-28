package controllers;

import database.DbManager;
import entity.Discipline;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String name = request.getParameter("name");
        String duration = request.getParameter("duration");
        String[] id = (request.getParameterValues("idDiscipline"));
        DbManager db = new DbManager();
        db.createTerm(name, duration, id);
        response.sendRedirect("/term");
    }
}
