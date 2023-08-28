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

@WebServlet(name = "TermController", value = "/term")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("changeTermHidden");
        DbManager db = new DbManager();
        List<Term> terms = db.getActiveTerms();
        DbManager db2 = new DbManager();
        List<Discipline> disciplines = db2.getDisciplineToTerm(id);

        String selectId = request.getParameter("selectId");
        Term termFirst = new Term();
        if (terms.size() > 0) {
            if (selectId == null) {

                termFirst = terms.get(0);

            } else {
                termFirst = Operations.getSelectTerm(selectId, terms);

            }
            request.setAttribute("terms", terms);
            request.setAttribute("termFirst", termFirst);
            request.setAttribute("disciplines", disciplines);
            request.getRequestDispatcher("JSP/term.jsp").forward(request, response);
        }
    }
}




