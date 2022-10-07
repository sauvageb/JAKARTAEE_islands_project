package com.example.demo.servlet;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.entity.Country;
import com.example.demo.model.Island;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/islands/add")
public class CreateIslandServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Country> countryList = DaoFactory.getCountryDAO().findAll();
        request.setAttribute("countries", countryList);

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
        String countryId = req.getParameter("countryId");

        try {
            Country country = DaoFactory.getCountryDAO().findById(Long.parseLong(countryId)).get();

            DaoFactory.getIslandDAO().create(new Island(
                    name,
                    pictureUrl,
                    Double.parseDouble(surface),
                    Long.parseLong(inhabitants),
                    Double.parseDouble(latitude),
                    Double.parseDouble(longitude),
                    country));

        } catch (Exception e) {
            req.setAttribute("error", true);
            doGet(req, resp);
        }
        resp.sendRedirect(req.getContextPath() + "/islands");

    }
}
