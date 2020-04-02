package com.epam.servlets;

import com.epam.dao.PizzeriaDaoImpl;
import com.epam.models.Pizzeria;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TestServlet", urlPatterns = "/")
public class TestServlet extends HttpServlet {

    private final PizzeriaDaoImpl pizzeriaDao = new PizzeriaDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pizzeriaDao.createPizzeriaTable();

        pizzeriaDao.addPizzeria(new Pizzeria("Lviv", "9:00 - 20:00"));
        pizzeriaDao.addPizzeria(new Pizzeria("Kyiv", "8:00 - 21:00"));
        pizzeriaDao.addPizzeria(new Pizzeria("Kharkiv", "8:30 - 21:30"));
        pizzeriaDao.addPizzeria(new Pizzeria("Dnipro", "7:30 - 22:00"));
        pizzeriaDao.addPizzeria(new Pizzeria("Odessa", "10:00 - 6:00"));

        List<Pizzeria> pizzeriaList =  pizzeriaDao.getAllPizzerias();

        request.setAttribute("pizzeriaList", pizzeriaList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pizzerias.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
