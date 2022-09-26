package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import com.example.demo.model.Island;
import com.example.demo.dao.MemoryIslandDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/islands/add")
public class CreateIslandServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/createIslandForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pictureUrl = req.getParameter("pictureUrl");

       DaoFactory.getIslandDAO().create(new Island(name, pictureUrl, 0, 0, 0, 0, ""));

        resp.sendRedirect(req.getContextPath() + "/islands");

    }
}
