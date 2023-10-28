package controllers;

import DB.DbManager;
import entity.Discipline;
import entity.Term;
import functions.Operations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TermController", value = "/term")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DbManager db = new DbManager();
        List<Term> terms = db.getActiveTerms();
        DbManager db2 = new DbManager();


        String selectId = request.getParameter("idTerm");
        Term termFirst = new Term();
        if (terms.size() > 0) {
            if (selectId == null) {

                termFirst = terms.get(0);

            } else {
                termFirst = Operations.getSelectTerm(selectId, terms);

            }

            String id = String.valueOf(termFirst.getId());
            request.setAttribute("terms", terms);
            request.setAttribute("termFirst", termFirst);
            List<Discipline> disciplines = db.getDisciplineToTerm(id);
            request.setAttribute("disciplines", disciplines);
        }
            request.getRequestDispatcher("JSP/term.jsp").forward(request, response);

    }
}





