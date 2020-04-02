package com.epam.servlets;

import com.epam.dao.PizzeriaDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/TestServlet", urlPatterns = "/*")
public class TestServlet extends HttpServlet {

    private final PizzeriaDaoImpl pizzeriaDao = new PizzeriaDaoImpl();

    private void processRequest(HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
