package controllers;

import DB.DbManager;
import entity.DisciplineMark;
import entity.Student;
import entity.Term;
import functions.Operations;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentProgressController", value = "/student_progress")
public class StudentProgressController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("progressStudentHidden");
        DbManager db = new DbManager();
        Student student = db.getStudentTOId(id);
        request.setAttribute("student", student);
        List<Term> terms = db.getActiveTermStudent(id);
        String selectId = request.getParameter("selectId");
        Term termFirst = new Term();
        if (terms.size() > 0) {
            if (selectId == null) {

                termFirst = terms.get(0);

            } else {
                termFirst = Operations.getSelectTerm(selectId,terms);

                    }



            request.setAttribute("terms", terms);
            request.setAttribute("termFirst", termFirst);
            List<DisciplineMark> dm = db.getDisciplineMarkToTerm(termFirst, student);
            request.setAttribute("dm", dm);
            double avg = Operations.getAvarage(dm);
            request.setAttribute("avg", avg);
        }

        request.getRequestDispatcher("JSP/student_progress.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}


