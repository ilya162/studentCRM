package controllers;

import DB.DbManager;
import entity.Discipline;
import entity.Term;
import functions.Operations;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermModifyController", value = "/term_modify")
public class TermModifyController extends HttpServlet {
    private String ids;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectId = request.getParameter("modifyTermHidden");
        DbManager db = new DbManager();
        List<Term> terms = db.getActiveTerms();
        Term termFirst = new Term();
        if (terms.size() > 0) {
            if (selectId == null) {

                termFirst = terms.get(0);

            } else {
                termFirst = Operations.getSelectTerm(selectId, terms);

            }

            String ids = String.valueOf(termFirst.getId());
            request.setAttribute("terms", terms);
            request.setAttribute("termFirst", termFirst);


            List<Discipline> disciplines = db.getDisciplineToTerm(ids);
            request.setAttribute("disciplines", disciplines);
            request.getRequestDispatcher("JSP/term_modify.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String duration = request.getParameter("duration");
        String[] ids = request.getParameterValues("idDiscipline");

        DbManager db = new DbManager();

        db.modifyTerm(id, duration, ids);
        response.sendRedirect("/term");
    }
}
