package controllers;

import DB.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DisciplineDelete", value = "/deleteDiscipline")
public class DisciplineDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ids = request.getParameter("deleteDisciplineHidden");
        DbManager db = new DbManager();
        db.deleteDiscipline(ids);
        response.sendRedirect("/disciplines");
    }
}
