package controllers;

import DB.DbManager;
import entity.Discipline;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DisciplineController", value = "/disciplines")
public class DisciplineController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbManager db = new DbManager();
        List<Discipline> disciplines = db.getActiveDiscipline();
        request.setAttribute("disciplines",disciplines);
        request.getRequestDispatcher("JSP/disciplines.jsp").forward(request,response);
    }


}
