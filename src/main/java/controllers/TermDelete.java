package controllers;

import database.DbManager;
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

@WebServlet(name = "TermDelete", value = "/deleteTerm")
public class TermDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectId = request.getParameter("deleteTermHidden");
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
            db.deleteTerm(ids);

        }


        response.sendRedirect("/term");


    }
}
