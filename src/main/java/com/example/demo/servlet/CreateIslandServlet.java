package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import com.example.demo.model.Island;
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
        String surface = req.getParameter("surface");
        String inhabitants = req.getParameter("inhabitants");
        String latitude = req.getParameter("latitude");
        String longitude = req.getParameter("longitude");
        String country = req.getParameter("country");

        DaoFactory.getIslandDAO().create(new Island(
                name,
                pictureUrl,
                Double.parseDouble(surface),
                Long.parseLong(inhabitants),
                Double.parseDouble(latitude),
                Double.parseDouble(longitude),
                country));

        resp.sendRedirect(req.getContextPath() + "/islands");

    }
}
