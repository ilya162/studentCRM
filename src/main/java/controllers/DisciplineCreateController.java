package controllers;

import DB.DbManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplineCreateController", value = "/discipline_create")
public class DisciplineCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("JSP/discipline_create.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//перехватить данные,2) сохранить данные в бд 3) перейти на страницу студентов

            String name = request.getParameter("name");
            DbManager manager = new DbManager();
            manager.createDiscipline(name);
            response.sendRedirect("/disciplines");
        }


    }



